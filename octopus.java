//API : http://mabe02.github.io/lanterna/apidocs/2.1/ import com.googlecode.lanterna.terminal.Terminal.SGR; import com.googlecode.lanterna.TerminalFacade; 
import com.googlecode.lanterna.input.Key; import com.googlecode.lanterna.input.Key.Kind; import com.googlecode.lanterna.terminal.Terminal; import
com.googlecode.lanterna.terminal.Terminal.Color; import com.googlecode.lanterna.terminal.TerminalSize; import com.googlecode.lanterna.LanternaException; import
com.googlecode.lanterna.input.CharacterPattern; import com.googlecode.lanterna.input.InputDecoder; import com.googlecode.lanterna.input.InputProvider; import
com.googlecode.lanterna.input.Key; import com.googlecode.lanterna.input.KeyMappingProfile; public class octopus {
  private String name;
  private boolean alive;
  private int x;
  private int y;
  public octopus(){
    name="(oo)";
    alive=true;
    x=0;
    y=2;
  }
  public octopus(int x,int y){
    name="(oo)";
    alive=true;
    this.x=x;
    this.y=y;
  }
  public void setName(String name){
    this.name=name;
  }
  public void setX(int x){
    this.x=x;
  }
  public void setY(int y){
    this.y=y;
  }
  public int getX(){
    return this.x;
  }
  public int getY(){
    return this.y;
  }
  public void disappear(){
    name="";
  }
  public void putString(int r, int c,Terminal t, String s){
    t.moveCursor(r,c);
    for(int i = 0; i < s.length();i++){
      t.putCharacter(s.charAt(i));
    }
  }
  public void setPosition(TerminalSize size,Terminal terminal){
    //moveCursor(size.getColumns()-5,5);
    this.putString(0,2,terminal,this.name);
  }
  public String getName(){
    return this.name;
  }
}
