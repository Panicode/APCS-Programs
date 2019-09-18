//4.7
import java.util.ArrayList;
public class Roster2{ //Must have "Student" class!
    ArrayList<Student> enrolledStudents= new ArrayList<Student>();
    public void addStudent(Student newStudent){
        enrolledStudents.add(newStudent);
    }
    public void dropStudent(String lastName){
        for(int i=0;i<enrolledStudents.size();i++){
            if(enrolledStudents.get(i).lastName==lastName){
                enrolledStudents.remove(i);
            }
        }
    }
    public String toString(){
        String retstu="";
        for(Student stu:enrolledStudents){
            retstu=retstu+stu+"\n"+"\n";
        }
        return retstu;
    }
}



public class Roster2Driver{ //seperate file!
    public static void main(String args[]){
        Roster2 apComputerScience=new Roster2();
        double stu1g[]={2.5,4.0,1.6,3.5,2.7,3.8};//grades
        Student stu1=new Student("Samantha","Cole",2020,stu1g);
        double stu2g[]={2.5,4.0,1.6,3.5,2.7,3.8};
        Student stu2=new Student("Henry","Dux",2020,stu2g);
        double stu3g[]={2.5,4.0,1.6,3.5,2.7,3.8};
        Student stu3=new Student("Donald","Cory",2020,stu3g);
        apComputerScience.addStudent(stu1);
        apComputerScience.addStudent(stu2);
        apComputerScience.addStudent(stu3);
        System.out.println("Here's the class!");
        System.out.println(apComputerScience);
        System.out.println("Oop! Time to drop a student!");
        apComputerScience.dropStudent("Dux");
        System.out.println("Here's a revised list!");
        System.out.println(apComputerScience);
    }
}
