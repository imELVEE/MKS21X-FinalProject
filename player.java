public class player implements CharSequence{
  private String ship;
  private int lives;
  private int score;
  public player(String thing, int lives){
    ship = thing;
    this.lives = lives;
    score = 0;
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
