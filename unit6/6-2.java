public class Games{
    
}
class CounterStrike extends Games{
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
    int toxicity=100;
    public void CheckToxicity(){
        if(toxicity>50){
            System.out.println("It's pretty toxic.");
        }
    }
}
class SmashBros extends Games{
    public void Bruh(){
        System.out.println("bruh");
    }
}
