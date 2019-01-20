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
public class crab implements monster{
  private String name = "╰pq╮";
  private int x;
  private int y;

  public crab(int x, int y){
    this.x = x;
    this.y = y;
  }


  public String getName(){
    return name;
  }
  public int getSize(){
    return name.length();
  }
  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }
  public void move(){
    x++;
  }
  public void moveDown(){
    y--;
  }

  public void setX(int x){
    this.x = x;
  }
  public void setY(int y){
    this.y = y;
  }
  public void putString(int r, int c,Terminal t, String s){
    t.moveCursor(r,c);
    for(int i = 0; i < s.length();i++){
      t.putCharacter(s.charAt(i));
    }
  }
  public String monstertype(){
    return "crab";
  }
  public void toggle(){
    if (name.equals("╰pq╮")){
      name = "╭pq╯";
    }
    else{
      name = "╰pq╮";
    }
  }
}
