public abstract class monster{
  String name;
  int lives;
  public monster(String name,int lives){
    this.name=name;
    this.lives=lives;
  }

  
  public abstract void shoot();
  public abstract String getName();
  public  abstract int getLives();
}
