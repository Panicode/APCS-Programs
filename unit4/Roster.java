public class Roster{ //Must have "Student" class!
    private Student Students[]=new Student[3];
    public Roster(){
        double stu1g[]={2.5,4.0,1.6,3.5,2.7,3.8};//grades
        Students[0]=new Student("Samantha","Cole",2020,stu1g);
        double stu2g[]={3.5,4.0,2.6,3.2,1.7,2.8};
        Students[1]=new Student("Damien","Marie",2022,stu2g);
        double stu3g[]={3.5,3.0,3.8,1.5,2.3,3.1};
        Students[2]=new Student("Donald","Cory",2021,stu3g);
    }
    public String findStudentWithMaxGPA(){
        double max=0;
        String name="";
        for(int i=0;i<Students.length;i++){
            if(max<Students[i].calcGPA()){
                max=Students[i].calcGPA();
                name=Students[i].firstName;
            }
        }
        return name;
    }
    public String toString(){
        Roster obj1=new Roster();
        return "The Student with the maximum GPA is: "+obj1.findStudentWithMaxGPA();
    }
}

public class RosterDriver{ //Seperate file!
    public static void main(String args[]){
        Roster obj1=new Roster();
        System.out.println(obj1);
    }
}
