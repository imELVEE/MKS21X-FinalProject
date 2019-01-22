public class reindeer{
  int life;
  String inbetween = "                                                           ";
  String sprite =
" \\         /   \\         /   \\         /   \\         /       \n"+inbetween+
"_\\/     \\/_   _\\/     \\/_   _\\/     \\/_   _\\/     \\/_       \n"+inbetween+
" _\\-\'\"\'-/_     _\\-\'\"\'-/_     _\\-\'\"\'-/_     _\\-\'\"\'-/_       \n"+inbetween+
"(_,     ,_)   (_,     ,_)   (_,     ,_)   (_,     ,_)       \n"+inbetween+
"  | ^ ^ |       | o o |       | a a |       | 6 6 |       \n"+inbetween+
"  |     |       |     |       |     |       |     |       \n"+inbetween+
"  |     |       |     |       |     |       |     |       \n"+inbetween+
"  |  Y  |       |  @  |       |  O  |       |  V  |       \n"+inbetween+
"  `._|_.\'       `._|_.\'       `._|_.\'       `._|_.\'       \n"+inbetween+
"   Dasher        Dancer       Prancer        Vixen       \n"+inbetween+
"\\         /   \\         /   \\         /   \\         /       \n"+inbetween+
"_\\/     \\/_   _\\/     \\/_   _\\/     \\/_   _\\/     \\/_       \n"+inbetween+
" _\\-\'\"\'-/_     _\\-\'\"\'-/_     _\\-\'\"\'-/_     _\\-\'\"\'-/_       \n"+inbetween+
"(_,     ,_)   (_,     ,_)   (_,     ,_)   (_,     ,_)       \n"+inbetween+
"  | q p |       | @ @ |       | 9 9 |       | d b |       \n"+inbetween+
"  |     |       |     |       |     |       |     |       \n"+inbetween+
"  |     |       |     |       |  _  |       |     |       \n"+inbetween+
"  | \\_/ |       |  V  |       | (_) |       |  0  |       \n"+inbetween+
"  `._|_.\'       `._|_.\'       `._|_.\'       `._|_.\'       \n"+inbetween+
"   Comet         Cupid         Donder       Blitzen       \n"+inbetween+
"                     \\         /        \n"+inbetween+
"                     _\\/     \\/_        \n"+inbetween+
"                      _\\-\'\"\'-/_        \n"+inbetween+
"                     (_,     ,_)        \n"+inbetween+
"                       | e e |        \n"+inbetween+
"                       |     |        \n"+inbetween+
"                  \'-.  |  _  |  .-\'       \n"+inbetween+
"                 --=   |((@))|   =--       \n"+inbetween+
"                  .-\'  `._|_.\'  \'-.       \n"+inbetween+
"                       Rudolph";


  int xlength = "  \\         /   \\         /   \\         /   \\         /".length();
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
  public void inbetweenminus(){
    inbetween = inbetween.substring(0,inbetween.length()-1);
    sprite =
    " \\         /   \\         /   \\         /   \\         /       \n"+inbetween+
    "_\\/     \\/_   _\\/     \\/_   _\\/     \\/_   _\\/     \\/_       \n"+inbetween+
    " _\\-\'\"\'-/_     _\\-\'\"\'-/_     _\\-\'\"\'-/_     _\\-\'\"\'-/_       \n"+inbetween+
    "(_,     ,_)   (_,     ,_)   (_,     ,_)   (_,     ,_)       \n"+inbetween+
    "  | ^ ^ |       | o o |       | a a |       | 6 6 |       \n"+inbetween+
    "  |     |       |     |       |     |       |     |       \n"+inbetween+
    "  |     |       |     |       |     |       |     |       \n"+inbetween+
    "  |  Y  |       |  @  |       |  O  |       |  V  |       \n"+inbetween+
    "  `._|_.\'       `._|_.\'       `._|_.\'       `._|_.\'       \n"+inbetween+
    "   Dasher        Dancer       Prancer        Vixen       \n"+inbetween+
    "\\         /   \\         /   \\         /   \\         /       \n"+inbetween+
    "_\\/     \\/_   _\\/     \\/_   _\\/     \\/_   _\\/     \\/_       \n"+inbetween+
    " _\\-\'\"\'-/_     _\\-\'\"\'-/_     _\\-\'\"\'-/_     _\\-\'\"\'-/_       \n"+inbetween+
    "(_,     ,_)   (_,     ,_)   (_,     ,_)   (_,     ,_)       \n"+inbetween+
    "  | q p |       | @ @ |       | 9 9 |       | d b |       \n"+inbetween+
    "  |     |       |     |       |     |       |     |       \n"+inbetween+
    "  |     |       |     |       |  _  |       |     |       \n"+inbetween+
    "  | \\_/ |       |  V  |       | (_) |       |  0  |       \n"+inbetween+
    "  `._|_.\'       `._|_.\'       `._|_.\'       `._|_.\'       \n"+inbetween+
    "   Comet         Cupid         Donder       Blitzen       \n"+inbetween+
    "                     \\         /        \n"+inbetween+
    "                     _\\/     \\/_        \n"+inbetween+
    "                      _\\-\'\"\'-/_        \n"+inbetween+
    "                     (_,     ,_)        \n"+inbetween+
    "                       | e e |        \n"+inbetween+
    "                       |     |        \n"+inbetween+
    "                  \'-.  |  _  |  .-\'       \n"+inbetween+
    "                 --=   |((@))|   =--       \n"+inbetween+
    "                  .-\'  `._|_.\'  \'-.       \n"+inbetween+
    "                       Rudolph";
  }
  public void inbetweenplus(){
    inbetween = inbetween + " ";
    sprite =
    " \\         /   \\         /   \\         /   \\         /       \n"+inbetween+
    "_\\/     \\/_   _\\/     \\/_   _\\/     \\/_   _\\/     \\/_       \n"+inbetween+
    " _\\-\'\"\'-/_     _\\-\'\"\'-/_     _\\-\'\"\'-/_     _\\-\'\"\'-/_       \n"+inbetween+
    "(_,     ,_)   (_,     ,_)   (_,     ,_)   (_,     ,_)       \n"+inbetween+
    "  | ^ ^ |       | o o |       | a a |       | 6 6 |       \n"+inbetween+
    "  |     |       |     |       |     |       |     |       \n"+inbetween+
    "  |     |       |     |       |     |       |     |       \n"+inbetween+
    "  |  Y  |       |  @  |       |  O  |       |  V  |       \n"+inbetween+
    "  `._|_.\'       `._|_.\'       `._|_.\'       `._|_.\'       \n"+inbetween+
    "   Dasher        Dancer       Prancer        Vixen       \n"+inbetween+
    "\\         /   \\         /   \\         /   \\         /       \n"+inbetween+
    "_\\/     \\/_   _\\/     \\/_   _\\/     \\/_   _\\/     \\/_       \n"+inbetween+
    " _\\-\'\"\'-/_     _\\-\'\"\'-/_     _\\-\'\"\'-/_     _\\-\'\"\'-/_       \n"+inbetween+
    "(_,     ,_)   (_,     ,_)   (_,     ,_)   (_,     ,_)       \n"+inbetween+
    "  | q p |       | @ @ |       | 9 9 |       | d b |       \n"+inbetween+
    "  |     |       |     |       |     |       |     |       \n"+inbetween+
    "  |     |       |     |       |  _  |       |     |       \n"+inbetween+
    "  | \\_/ |       |  V  |       | (_) |       |  0  |       \n"+inbetween+
    "  `._|_.\'       `._|_.\'       `._|_.\'       `._|_.\'       \n"+inbetween+
    "   Comet         Cupid         Donder       Blitzen       \n"+inbetween+
    "                     \\         /        \n"+inbetween+
    "                     _\\/     \\/_        \n"+inbetween+
    "                      _\\-\'\"\'-/_        \n"+inbetween+
    "                     (_,     ,_)        \n"+inbetween+
    "                       | e e |        \n"+inbetween+
    "                       |     |        \n"+inbetween+
    "                  \'-.  |  _  |  .-\'       \n"+inbetween+
    "                 --=   |((@))|   =--       \n"+inbetween+
    "                  .-\'  `._|_.\'  \'-.       \n"+inbetween+
    "                       Rudolph";
  }

}
