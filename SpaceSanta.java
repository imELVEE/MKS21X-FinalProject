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

    Terminal terminal = TerminalFacade.createTextTerminal();
    terminal.enterPrivateMode();
    TerminalSize size=terminal.getTerminalSize();
    terminal.setCursorVisible(false);
    int mode=1;
    int score=0;

    List<bullet> b = new ArrayList<bullet>();
    List<ammo> m = new ArrayList<ammo>();
    List<monster> monsterList = new ArrayList<monster>();
    int num=(int) (Math.random()*2)+7;
    int random=0;// this is used to make the game more challenging with each level progression
    int zx=0;
    int zy=2;
    for(int i=0;i<num;i++){
     if (Math.random()*10 <= 5){
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
    player santa = new player("</^\\>", 2,size);
    boolean running = true;
    int x = 10;
    int y = size.getRows()/2;
    long tStart = System.currentTimeMillis();
    long tCount=0;
		long lastSecond = 0;
    long last2sec = 0;
    long timeStart=System.currentTimeMillis();
    //Octopus.setPosition(size,terminal);  // you may need to use this
    while(running){
      if(mode==4){
        zx=0;
        zy=2;
        long currentTime=System.currentTimeMillis();
        putString(size.getColumns()/2-2 , size.getRows()/2 , terminal , "NEXTLEVEL!");
        if(currentTime/1000-timeStart/1000>4){
            mode=2;
            terminal.clearScreen();
       
            random=(int)(Math.random()*2)+1;
            int number=(int) (Math.random()*2)+7+random;// the last random is a global variable
            for(int i=0;i<number;i++){
             if (Math.random()*10 <= 5){
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
        }
      }
      if(mode==1){
        putString(size.getColumns()/2-2 , size.getRows()/2+5 , terminal ,  "Press Space to play game ");
        putString(size.getColumns()/2-2 , size.getRows()/2 , terminal , "HighScore: "+ score);
        Key key = terminal.readInput();

        if (key != null ){
          if (key.getKind() == Key.Kind.Escape) {
            terminal.exitPrivateMode();
            running=false;
          }
          if (key.getCharacter() == ' '){
            mode=2;
            terminal.clearScreen();
          }
      }
    }
    if(mode==3){

      Key key = terminal.readInput();
      if (score<santa.getScore()){
        score=santa.getScore();
      }
      if (key != null ){
        if (key.getKind() == Key.Kind.Escape) {
          terminal.exitPrivateMode();
          running=false;

        }
        if (key.getCharacter() == ' '){
          mode=2;
          terminal.clearScreen();
        }
    }

      putString(size.getColumns()/2-2 , size.getRows()/2 , terminal ,  "YOU LOST!");
      putString(size.getColumns()/2-2 , size.getRows()/2-3 , terminal , "HIGHSCORE: " + score);
      putString(size.getColumns()/2-2 , size.getRows()/2-6 , terminal , "CURRENTSCORE: " + santa.getScore());
      putString
      (size.getColumns()/2-2 , size.getRows()/2-9 , terminal , "press  esc to escape");

}
    if(mode==2){
    terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
    terminal.applyForegroundColor(Terminal.Color.DEFAULT);
    //Octopus.putString(zx,zy,terminal,Octopus.getName());
    terminal.putCharacter(' ');

 
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
      //    monsterList.add(new crab(0,2));
        //}
      //}
    }// this is for the above for loop
    if(millis/2000 > last2sec){
      last2sec = millis / 2000;
      santa.unstun();
    //  for(int i = 0 ; i < monsterList.size() ; i++){
    //    monsterList.get(i).toggle();
      //}
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
    if(monsterList.size()==0){
      mode=4;
      timeStart=System.currentTimeMillis();
      terminal.clearScreen();

    }
    if (santa.getLives() <= 0){
      mode=3;
      terminal.clearScreen();
      }
    }
  }
 }
}

