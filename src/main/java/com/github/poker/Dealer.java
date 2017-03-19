package.com.github.com ;

public class Dealer{

  public static ArrayList<Player> player;

public Dealer(String name){
  this.name = name;
  }

public void setName(String name){
  this.name = name;
  }

public String getName(){
  return name;
  }
public void setPlayer(ArrayList<Player> player){
  this.player = player;
}
public Player getPlayer(){
  return player;
}
}
