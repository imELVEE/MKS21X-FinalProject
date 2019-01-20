public class crabbullet implements ammo{
  private String sprite = "vv";
  private int damage = 0;
  private int speed = 2;
  private int size = 2;
  private int x,y;
  private long bLast;

  public crabbullet(int x, int y, long bLast){
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
