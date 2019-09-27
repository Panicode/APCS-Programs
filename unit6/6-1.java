import java.util.ArrayList;
class Superhero{
    String motto="";
    public void getMotto(){
        System.out.println(motto);
    }
}
class GeorgeBush extends Superhero{
    public void getMotto(){System.out.println("whoa");}
    String bushPower="i have bushpower";
    String unique="very cool";
    public void GeorgeBushMethod(String bP){
       unique=bP;
    }
}
class Obama extends Superhero{
    public void getMotto(){System.out.println("epic");}
    String obamaPower="obama power bro";
    public String basketBalls(String gg){
        if(gg.contains("Bruh")==true){
            return "Bruh found";
        }else{return "Bruh not found";}
    }
}
class JakeFromStateFarm extends Superhero{
    String jakePower="uhh";
    public void getMotto(){System.out.println("awesome");}
}
public class SuperheroDriver{
    public static void main(String args[]){
        Superhero obj1=new Obama();
        ArrayList<Superhero> superheroes = new ArrayList<Superhero>();
        superheroes.add(new GeorgeBush());
        superheroes.add(new Obama());   
        superheroes.add(new JakeFromStateFarm());
        for(int i=0;i<superheroes.size();i++){
           obj1.getMotto();
        }
    }
}
