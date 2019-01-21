import java.util.ArrayList;
import java.util.List;

//API : http://mabe02.github.io/lanterna/apidocs/2.1/
import com.googlecode.lanterna.terminal.Terminal.SGR;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.Key.Kind;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.LanternaException;
import com.googlecode.lanterna.input.CharacterPattern;
import com.googlecode.lanterna.input.InputDecoder;
import com.googlecode.lanterna.input.InputProvider;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.KeyMappingProfile;


public class SpaceSanta{

  public static void putString(int r, int c,Terminal t, CharSequence s){
		t.moveCursor(r,c);
		for(int i = 0; i < s.length();i++){
			t.putCharacter(s.charAt(i));
		}
  }

  public static void main(String[] args){


    List<bullet> b = new ArrayList<bullet>();
    List<ammo> m = new ArrayList<ammo>();
    List<monster> monsterList = new ArrayList<monster>();
    int num=(int) (Math.random()*2)+4;

    int zx=0;
    int zy=2;
  //  for(int i=0;i<num;i++){
  //    if (Math.random()*10 <= 5){
  //      monsterList.add(new octopus(zx,zy));
  ////    }
      //else{
    ////    monsterList.add(new crab(zx,zy));
      //}
      //zx+=10;
    //}
    for(int i=0; i<num;i++){
        if((int)(Math.random()*10)<=4){
             monsterList.add(new octopus(zx,zy));
             monsterList.add(new octopus(zx,zy+1));
             monsterList.add(new octopus(zx,zy+2));
        }
        else{
          monsterList.add(new crab(zx,zy));
          monsterList.add(new crab(zx,zy+1));
          monsterList.add(new crab(zx,zy+2));
       }
       zx+=10;
    }



    Terminal terminal = TerminalFacade.createTextTerminal();


    terminal.enterPrivateMode();
    TerminalSize size=terminal.getTerminalSize();
    player santa = new player("</^\\>", 2,size);
    terminal.setCursorVisible(false);

    boolean running = true;

    int x = 10;
    int y = size.getRows()/2;
    long tStart = System.currentTimeMillis();
    long tCount=0;	
    long lastSecond = 0;
    long last2sec = 0;
    //Octopus.setPosition(size,terminal);  // you may need to use this
    while(running){
    terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
    terminal.applyForegroundColor(Terminal.Color.DEFAULT);
    //Octopus.putString(zx,zy,terminal,Octopus.getName());
    terminal.putCharacter(' ');

    if(zx==size.getRows()*4 ){
      terminal.moveCursor(zx,zy);
    }
   terminal.applyForegroundColor(Terminal.Color.DEFAULT);
   for(int i=0;i<monsterList.size();i++){   // change this
     monster a=monsterList.get(i);
     a.putString(a.getX(),a.getY(), terminal,a.getName());
     terminal.putCharacter(' ');
   }
    for(int i=0;i<monsterList.size();i++){
    monster a= monsterList.get(i);
    if(a.getX()==size.getRows()*4){
      terminal.moveCursor(a.getX(),a.getY());
      terminal.putCharacter(' ');
      a.setX(0);
      a.setY(a.getY()+1);
    }
  }

   terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
   terminal.applyForegroundColor(Terminal.Color.DEFAULT);
   terminal.moveCursor(x,y);
   if (!santa.notStunned()){
     terminal.applyForegroundColor(Terminal.Color.YELLOW);
   }
    putString(x,y,terminal,santa);
    terminal.putCharacter(' ');
    terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
    terminal.applyForegroundColor(Terminal.Color.DEFAULT);

    Key key = terminal.readInput();

    if (key != null && santa.notStunned()){


      if (key.getKind() == Key.Kind.Escape) {

        terminal.exitPrivateMode();
        running = false;
      }

      if (key.getKind() == Key.Kind.ArrowLeft) {
        terminal.moveCursor(x,y);
        terminal.putCharacter(' ');
        x--;
      }

      if (key.getKind() == Key.Kind.ArrowRight) {
        terminal.moveCursor(x,y);
        terminal.putCharacter(' ');
        x++;
      }

      if (key.getCharacter() == ' '){
        b.add(new bullet(1,1,1,"|",x+2,y-1,System.currentTimeMillis()));
      }
    }

    if (b.size() > 0){
      for (int i = 0 ; i < b.size(); i++){
        if (b.get(i).gety() > 0 && System.currentTimeMillis() - b.get(i).getbLast() >= 50){
          terminal.moveCursor(b.get(i).getx(),b.get(i).gety());
          terminal.putCharacter(' ');
          b.get(i).move();
          putString(b.get(i).getx(),b.get(i).gety(),terminal,b.get(i).getSprite());
          b.get(i).setbLast(System.currentTimeMillis());
        }
        if (b.get(i).gety() == 0){
          for(int mi = 0 ; mi < monsterList.size() ; mi++){
            monster ma = monsterList.get(mi);
            if (b.get(i).getx() >= ma.getX() && b.get(i).getx() <= ma.getX() + 4){
              monsterList.remove(mi);
              putString(ma.getX(),ma.getY(),terminal,"    ");
              santa.incrementScore(50);
            }
          }
          terminal.moveCursor(b.get(i).getx(),b.get(i).gety());
          terminal.putCharacter(' ');
          b.remove(i);
        }
      }
    }
    if (m.size() > 0){
      for (int i = 0 ; i < m.size(); i++){
        if (m.get(i).gety() < y && System.currentTimeMillis() - m.get(i).getbLast() >= 50){
          terminal.moveCursor(m.get(i).getx(),m.get(i).gety());
          terminal.putCharacter(' ');
          terminal.putCharacter(' ');
          m.get(i).move();
          putString(m.get(i).getx(),m.get(i).gety(),terminal,m.get(i).getSprite());
          m.get(i).setbLast(System.currentTimeMillis());
        }
        if (m.get(i).gety() == y){
          if (m.get(i).getx() >= x && m.get(i).getx() <= x+5){
            if (m.get(i).getSprite() == "|"){
              santa.die();
            }
            if (m.get(i).getSprite() == "vv"){
              santa.stun();
            }
          }
          terminal.moveCursor(m.get(i).getx(),m.get(i).gety());
          terminal.putCharacter(' ');
          terminal.putCharacter(' ');
          m.remove(i);
        }
      }
    }

    long tEnd = System.currentTimeMillis();
    long millis = tEnd - tStart;
  //	putString(1,2,terminal,"Milliseconds since start of program: "+millis);
    if(millis/1000 > lastSecond){
      lastSecond = millis / 1000;
      for(int i=0;i<monsterList.size();i++){
        monster a= monsterList.get(i);
        if (Math.random()*10 <= 3.5){
          if (a.monstertype().equals("crab")){
            m.add(new crabbullet(a.getX()+2,a.getY()+1,System.currentTimeMillis()));
          }
          else{
            m.add(new octopusbullet(a.getX()+2,a.getY()+1,System.currentTimeMillis()));
          }
        }
      }
    //  if (Math.random()*10 <= 2.5){
    //    if (Math.random()*10 <= 5){
    //      monsterList.add(new octopus(0,2));
    //    }
      //  else{
      
        //}
      //}
    }// this is for the above for loop

  if(millis/5000 > last2sec){
     last2sec = millis / 2000;
      santa.unstun();
      //for(int i = 0 ; i < monsterList.size() ; i++){
       // monsterList.get(i).toggle();
     // }
   // }
   }
    long tLastCount=millis;
    // this is where the monster changes x

    if(tLastCount-tCount>20){
      long temporary=tLastCount;
      tCount=tLastCount;
      for(int i=0;i<monsterList.size();i++){
        monster d=monsterList.get(i);
        terminal.moveCursor(d.getX(),d.getY());
        terminal.putCharacter(' ');
        d.setX(d.getX()+1);
      }
      //terminal.moveCursor(zx,zy);
      //terminal.putCharacter(' ');
    //  zx++;
  }

    putString(size.getColumns()/2-2 , size.getRows()*2/3 , terminal ,  "LIVES: " + santa.getLives());
    putString(size.getColumns()/2-2 , size.getRows()*2/3+2 , terminal , "SCORE: " + santa.getScore());

    if (santa.getLives() <= 0){
      terminal.exitPrivateMode();
      running = false;
    }
    }

  }
}

