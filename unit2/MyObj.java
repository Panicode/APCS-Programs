class Game{
    String name;
    int year;
    public Game(){
        name="Rainbow Six Siege";
        year=2015;
    }
    public Game(String nm,int ye){
        name=nm;
        year=ye;
    }
    public String toString(){
        return "The game's name is: "+name+", and the publish year is: "+year;
    }
}
public class GameDriver{
    public static void main(String args[]){
        Game obj1=new Game();
        Game obj2=new Game("Minecraft",2009);
        System.out.println(obj1);
        System.out.println(obj2);
    }
}
