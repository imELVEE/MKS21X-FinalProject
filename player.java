public class player{
  private String ship;
  private int lives;
  public player(String thing, int lives){
    ship = thing;
    lives = this.lives;
  }
  public String toString(){
    return ship;
  }
  public int getLives(){
    return lives;
  }


}
