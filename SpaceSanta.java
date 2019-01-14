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
    List<monsterbullet> m = new ArrayList<monsterbullet>();
    List<octopus> monster = new ArrayList<octopus>();
    int num=(int) (Math.random()*4)+1;

    int zx=0;
    int zy=2;
    for(int i=0;i<num;i++){
      monster.add(new octopus(zx,zy));
      zx+=10;
    }

    Terminal terminal = TerminalFacade.createTextTerminal();


    terminal.enterPrivateMode();
    TerminalSize size=terminal.getTerminalSize();
    player santa = new player("</^\\>", 2,size);
  //  octopus Octopus=new octopus();
    terminal.setCursorVisible(false);

    boolean running = true;

    int x = 10;
    int y = size.getRows()/2;
    long tStart = System.currentTimeMillis();
    long tCount=0;
		long lastSecond = 0;
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
   for(int i=0;i<monster.size();i++){   // change this
     octopus a=monster.get(i);
     a.putString(a.getX(),a.getY(), terminal,a.getName());
     terminal.putCharacter(' ');
   }
    for(int i=0;i<monster.size();i++){
    octopus a= monster.get(i);
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
    putString(x,y,terminal,santa);
    terminal.putCharacter(' ');
    terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
    terminal.applyForegroundColor(Terminal.Color.DEFAULT);

    Key key = terminal.readInput();

    if (key != null){


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
        if (b.get(i).gety() > 0 && System.currentTimeMillis() - b.get(i).getbLast() >= 125){
          terminal.moveCursor(b.get(i).getx(),b.get(i).gety());
          terminal.putCharacter(' ');
          b.get(i).move();
          putString(b.get(i).getx(),b.get(i).gety(),terminal,b.get(i).getSprite());
          b.get(i).setbLast(System.currentTimeMillis());
        }
        if (b.get(i).gety() == 0){
          for(int mi = 0 ; mi < monster.size() ; mi++){
            octopus ma = monster.get(mi);
            if (b.get(i).getx() >= ma.getX() && b.get(i).getx() <= ma.getX() + 4){
              monster.remove(mi);
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
        if (m.get(i).gety() < y && System.currentTimeMillis() - m.get(i).getbLast() >= 125){
          terminal.moveCursor(m.get(i).getx(),m.get(i).gety());
          terminal.putCharacter(' ');
          m.get(i).move();
          putString(m.get(i).getx(),m.get(i).gety(),terminal,m.get(i).getSprite());
          m.get(i).setbLast(System.currentTimeMillis());
        }
        if (m.get(i).gety() == y){
          if (m.get(i).getx() >= x && m.get(i).getx() <= x+5){
            santa.die();
          }
          terminal.moveCursor(m.get(i).getx(),m.get(i).gety());
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
      for(int i=0;i<monster.size();i++){
        octopus a= monster.get(i);
        if (Math.random()*10 <= 3.5){
          m.add(new monsterbullet(1,1,1,"|",a.getX()+2,a.getY()+1,System.currentTimeMillis()));
        }
      }
      if (Math.random()*10 <= 2.5){
        monster.add(new octopus(0,2));
      }
    }
    long tLastCount=millis;

    if(tLastCount-tCount>20){
      long temporary=tLastCount;
      tCount=tLastCount;
      for(int i=0;i<monster.size();i++){
        octopus d=monster.get(i);
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
