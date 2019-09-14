public class uniCompare{
    public static void main(String []args){
        String school1=new String("Stanford");
        String school2=new String("Caltech");
        String school3=new String("UCLA"); 
        System.out.println(school1.compareTo(school2));
    }
    
    // The output of the "compareTo" statements are comparing both Strings lexicographically/Alphabetically.
    // The compareTo statement reads every single character and generates the componets Alphabetically.
}
