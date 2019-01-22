public class reindeer{
  int life;
  String sprite =
"  \\         /   \\         /   \\         /   \\         /\n"+
"                                                                                 _\\/     \\/_   _\\/     \\/_   _\\/     \\/_   _\\/     \\/_\n"+
"                                                                                  _\\-\'\"\'-/_     _\\-\'\"\'-/_     _\\-\'\"\'-/_     _\\-\'\"\'-/_\n"+
"                                                                                 (_,     ,_)   (_,     ,_)   (_,     ,_)   (_,     ,_)\n"+
"                                                                                   | ^ ^ |       | o o |       | a a |       | 6 6 |\n"+
"                                                                                   |     |       |     |       |     |       |     |\n"+
"                                                                                   |     |       |     |       |     |       |     |\n"+
"                                                                                   |  Y  |       |  @  |       |  O  |       |  V  |\n"+
"                                                                                   `._|_.\'       `._|_.\'       `._|_.\'       `._|_.\'\n"+
"                                                                                    Dasher        Dancer       Prancer        Vixen\n"+
"                                                                                 \\         /   \\         /   \\         /   \\         /\n"+
"                                                                                 _\\/     \\/_   _\\/     \\/_   _\\/     \\/_   _\\/     \\/_\n"+
"                                                                                  _\\-\'\"\'-/_     _\\-\'\"\'-/_     _\\-\'\"\'-/_     _\\-\'\"\'-/_\n"+
"                                                                                 (_,     ,_)   (_,     ,_)   (_,     ,_)   (_,     ,_)\n"+
"                                                                                   | q p |       | @ @ |       | 9 9 |       | d b |\n"+
"                                                                                   |     |       |     |       |     |       |     |\n"+
"                                                                                   |     |       |     |       |  _  |       |     |\n"+
"                                                                                   | \\_/ |       |  V  |       | (_) |       |  0  |\n"+
"                                                                                   `._|_.\'       `._|_.\'       `._|_.\'       `._|_.\'\n"+
"                                                                                    Comet         Cupid         Donder       Blitzen\n"+
"                                                                                                      \\         / \n"+
"                                                                                                      _\\/     \\/_ \n"+
"                                                                                                       _\\-\'\"\'-/_ \n"+
"                                                                                                      (_,     ,_) \n"+
"                                                                                                        | e e | \n"+
"                                                                                                        |     | \n"+
"                                                                                                   \'-.  |  _  |  .-\'\n"+
"                                                                                                  --=   |((@))|   =--\n"+
"                                                                                                   .-\'  `._|_.\'  \'-.\n"+
"                                                                                                        Rudolph";


  int xlength = "     \\         /   \\         /   \\         /   \\         /".length();
  int ylength = 29;

  public int height(){
    return ylength;
  }
  public int length(){
    return xlength;
  }
  public String getSprite(){
    return sprite;
  }
  public void hurt(int damage){
    life -= damage;
  }
  public int getLife(){
    return life;
  }

  public reindeer(int life){
    this.life = life;
  }

}
