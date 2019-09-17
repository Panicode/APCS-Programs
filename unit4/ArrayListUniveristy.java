import java.util.ArrayList;
public class ArrayListUniversity{
    public static void main(String args[]){
        ArrayList<String> uni = new ArrayList<String>();
        uni.add("UCLA");
        uni.add("Caltech");
        uni.add("Stanford");
        uni.add("UCSD");
        uni.add("Yale");
        System.out.println("The amount of universities are: "+uni.size());
        for(String nam:uni){
            System.out.println(nam);
        }
        System.out.println("Time to remove all universities with 4 letters!");
        for(int i=0;i<uni.size();i++){
            if(uni.get(i).length()==4){
                uni.remove(i);
            }
        }
        System.out.println("The NEW amount of universities are: "+uni.size());
        for(String nam:uni){
            System.out.println(nam);
        }
    }
}
