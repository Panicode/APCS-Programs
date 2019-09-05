class Student{
    String firstName;
    String lastName;
    double GPA;
    int gradYear;
    public Student(){
        firstName="John";
        lastName="Smith";
        GPA=4.0;
        gradYear=2020;
    }
    public Student(String fn,String ln,double gp,int gy){
        firstName=fn;
        lastName=ln;
        GPA=gp;
        gradYear=gy;
    }
    public String toString(){
        return "Name: "+firstName+" "+lastName+", GPA:"+GPA+", Graduation year:"+gradYear;
    }
}
public class StudentDriver{
    public static void main(String args[]){
        Student senior001=new Student();
        Student frosh001=new Student("Barack","Obama",2.3,2023);
        System.out.println(senior001);
        System.out.println(frosh001);
    }
}
