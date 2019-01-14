public class monsterbullet implements ammo{
  private String sprite;
  private int damage;
  private int speed;
  private int size;
  private int x,y;
  private long bLast;


  public monsterbullet(int damage, int speed, int size, String sprite, int x, int y, long bLast){
    this.damage = damage;
    this.speed = speed;
    this.size = size;
    this.sprite = sprite;
    this.x = x;
    this.y = y;
    this.bLast = bLast;
  }
  public int getSpeed(){
    return speed;
  }
  public int getDamage(){
    return damage;
  }
  public int getSize(){
    return size;
  }
  public void setSpeed(int val){
    speed = val;
  }
  public void setDamage(int val){
    damage = val;
  }
  public void setSize(int val){
    size = val;
  }
  public void setx(int val){
    x = val;
  }
  public void sety(int val){
    y = val;
  }
  public int getx(){
    return x;
  }
  public int gety(){
    return y;
  }
  public String getSprite(){
    return sprite;
  }
  public void setbLast(long value){
    bLast = value;
  }
  public long getbLast(){
    return bLast;
  }
  public int move(){
    return y++;
  }
}
