//unfinished!

import java.util.ArrayList;
class Superhero{
    public void getMotto(String motto){
        System.out.println(motto);
    }
}
class GeorgeBush extends Superhero{
    public void motto(){super.getMotto("whoa");}
    String bushPower="i have bushpower";
    String unique="very cool";
    public void GeorgeBushMethod(String bP){
       unique=bP;
    }
}
class Obama extends Superhero{
    public void motto(){super.getMotto("nice");}
    String obamaPower="obama power bro";
    public String basketBalls(String gg){
        if(gg.contains("Bruh")==true){
            return "Bruh found";
        }else{return "Bruh not found";}
    }
}
class JakeFromStateFarm extends Superhero{
    String jakePower="uhh";
    public void motto(){super.getMotto("epic");}
}
public class SuperheroDriver{
    public static void main(String args[]){
        ArrayList<Superhero> superheroes = new ArrayList<Superhero>();
        superheroes.add(new GeorgeBush());
        superheroes.add(new Obama());   
        superheroes.add(new JakeFromStateFarm());
        for(int i=0;i<superheroes.size();i++){
           superheroes.get(i).motto();
        }
    }
}
