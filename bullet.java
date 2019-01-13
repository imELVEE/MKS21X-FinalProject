import com.googlecode.lanterna.terminal.Terminal.SGR; import com.googlecode.lanterna.TerminalFacade; import com.googlecode.lanterna.input.Key; import 
com.googlecode.lanterna.input.Key.Kind; import com.googlecode.lanterna.terminal.Terminal; import com.googlecode.lanterna.terminal.Terminal.Color; import 
com.googlecode.lanterna.terminal.TerminalSize; import com.googlecode.lanterna.LanternaException; import com.googlecode.lanterna.input.CharacterPattern; import 
com.googlecode.lanterna.input.InputDecoder; import com.googlecode.lanterna.input.InputProvider; import com.googlecode.lanterna.input.Key; import 
com.googlecode.lanterna.input.KeyMappingProfile; public class bullet{
  private int x;
  private int y;
  private String name;
  private boolean disappear;
  public bullet(int x, int y,Terminal t){// the terminal does nothing
    this.name="|";
    this.x=x;
    this.y=y;
    this.disappear=true;
  // this.putString(t);
  }
  public int getY(){
    return this.y;
  }
  public int getX(){
    return this.x;
  }
  public void setX(int x){
    this.x=x;
  }
  public void setY(int y){
    this.y=y;
  }
  public void putString(Terminal t) {
      t.moveCursor(this.x,this.y);
      for(int i = 0; i < this.name.length();i++){
        t.putCharacter(this.name.charAt(i));
      }
    }
    public void disappear(){
      this.name="";
      this.disappear=false;
    }
    public boolean getDisappear(){
      return this.disappear;
    }
    public void setDisappear(boolean t){
      this.disappear=t;
    }
    public String getName(){
       return this.name;
    }
    public void setName(String a){
      this.name=a;
    }
  }
