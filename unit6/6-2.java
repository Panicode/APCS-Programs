import java.util.ArrayList;
class Games{
    public void PlayGame(){
        System.out.println("Let's play a game!");
    }
    public void PlaySmash(){
        System.out.println("Hello! Wanna play smash?");
    }
}
class CounterStrike extends Games{
    public void PlayGame(){
        System.out.println("Let's play Counter Strike!");
    }
    String map;
    CounterStrike(){
        map="Dust 2";
    }
    public void SetMap(String mp){
        this.map=mp;
    }
    public void Display(){
        System.out.println("The map is: "+map);
    }
}
class RainbowSix extends Games{
    public void PlayGame(){
        System.out.println("Let's play Rainbow Six Siege!");
    }
    int toxicity=100;
    public void CheckToxicity(){
        if(toxicity>50){
            System.out.println("It's pretty toxic.");
        }
    }
}
class SmashBros extends Games{
    public void PlayGame(){
        System.out.println("Let's play Smash Bros!");
    }
    public void PlaySmash(){
        System.out.println("wanna play smash??? ok final destination 3 stock no items idiot haha");
    }
}
public class GamesDriver{
    public static void main(String args[]){
        Games games[]=new Games[3];
        games[0]=new CounterStrike();
        games[1]=new RainbowSix();
        games[2]=new SmashBros();
        ArrayList<Games> gameList=new ArrayList<Games>();
        gameList.add(new CounterStrike());
        gameList.add(new RainbowSix());
        gameList.add(new SmashBros());
        for(int i=0;i<games.length;i++){
            games[i].PlayGame();
        }
        for(int i=0;i<gameList.size();i++){
            gameList.get(i).PlayGame();
        }
    }
}
