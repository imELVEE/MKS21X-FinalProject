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
    player santa = new player("</^\\>", 2);

    List<bullet> b = new ArrayList<bullet>();

    Terminal terminal = TerminalFacade.createTextTerminal();
    terminal.enterPrivateMode();

    TerminalSize size = terminal.getTerminalSize();
    terminal.setCursorVisible(false);

    boolean running = true;

    int x = 10;
    int y = size.getRows()/2;

    while(running){

    terminal.moveCursor(x,y);
    putString(x,y,terminal,santa);
    terminal.putCharacter(' ');
    terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
    terminal.applyForegroundColor(Terminal.Color.DEFAULT);

    Key key = terminal.readInput();

    if (key != null)
    {

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

    putString(size.getColumns()/2-2 , size.getRows()*2/3 , terminal ,  "LIVES: " + santa.getLives());
    putString(size.getColumns()/2-2 , size.getRows()*2/3+2 , terminal , "SCORE: " + santa.getScore());
    }
  }
}
