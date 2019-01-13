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

public class player implements CharSequence{
  private String ship;
  private int lives;
  private int score;
  int x;
  int y;
  public void setX(int x){
    this.x=x;
  }
  public void setY(int y){
    this.y=y;
  }
  public player(String thing, int lives,TerminalSize size){
    ship = thing;
    this.lives = lives;
    score = 0;
    this.x=10;
    this.y=size.getRows()/2;
  }
  public bullet fire(Terminal t){
    bullet Bullet= new bullet(this.x,this.y,t);
    return Bullet;
  }
  public String toString(){
    return ship;
  }
  public int getLives(){
    return lives;
  }
  public int getScore(){
    return score;
  }
  public void incrementScore(int value){
    score += value;
  }


  public char charAt(int index){
    return ship.charAt(index);
  }
  public int length(){
    return ship.length();
  }
  public CharSequence subSequence(int start, int end){
    return ship.subSequence(start, end);
  }

}

