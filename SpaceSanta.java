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
<<<<<<< HEAD
    player santa = new player("</^\\>", 2);

    List<bullet> b = new ArrayList<bullet>();

    Terminal terminal = TerminalFacade.createTextTerminal();
=======
    Terminal terminal=TerminalFacade.createTextTerminal();
>>>>>>> ac04dfbd4fd2de702a2d9303a17a5888ea4a422e
    terminal.enterPrivateMode();
    TerminalSize size=terminal.getTerminalSize();
    player santa = new player("</^\\>", 2,size);
    octopus Octopus=new octopus();
    terminal.setCursorVisible(false);

    boolean running = true;

    int x = 10;
    int y = size.getRows()/2;
    int zx=0;
    int zy=2;
    long tStart = System.currentTimeMillis();
    long tCount=0;
		long lastSecond = 0;
    Octopus.setPosition(size,terminal);
    while(running){
    terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
   terminal.applyForegroundColor(Terminal.Color.DEFAULT);
    Octopus.putString(zx,zy,terminal,Octopus.getName());
    terminal.putCharacter(' ');

    if(zx==size.getRows()*4 ){
      terminal.moveCursor(zx,zy);
      terminal.putCharacter(' ');
      zx=0;
      zy++;
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
          terminal.moveCursor(b.get(i).getx(),b.get(i).gety());
          terminal.putCharacter(' ');
          b.remove(i);
        }
      }
    }
    long tEnd = System.currentTimeMillis();
    long millis = tEnd - tStart;
  //	putString(1,2,terminal,"Milliseconds since start of program: "+millis);
    if(millis/1000 > lastSecond){
      lastSecond = millis / 1000;
    }
    long tLastCount=millis;

    if(tLastCount-tCount>40){
      long temporary=tLastCount;
      tCount=tLastCount;
      terminal.moveCursor(zx,zy);
      terminal.putCharacter(' ');
      zx++;
    }

    putString(size.getColumns()/2-2 , size.getRows()*2/3 , terminal ,  "LIVES: " + santa.getLives());
    putString(size.getColumns()/2-2 , size.getRows()*2/3+2 , terminal , "SCORE: " + santa.getScore());
    }
  }
}
