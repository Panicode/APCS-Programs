import java.util.ArrayList;
public class ArrayListTech{
    public static void main(String args[]){
        //Shoutouts to the only loving family in my life; it's not even biological.
        ArrayList<String> fam = new ArrayList<String>();
        fam.add("Samantha");
        fam.add("Donald");
        fam.add("Damien");
        fam.add("Elmer");
        fam.add("Henry");
        fam.add("Carl");
        System.out.println("The size of the family is: "+fam.size());
        //for(int i=0;i<fam.size();i++){
        //    System.out.println(fam.get(i));
        //}
        for(String nam:fam){
            System.out.println(nam);
        }
    }
}
