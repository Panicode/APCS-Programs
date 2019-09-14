public class Student{
    String firstName;
    String lastName;
    double GPA;
    int gradYear;
    double grades[]=new double[5];
    public void setGPA(double eng,double math,double sci,double FA,double SS){
        grades[0]=eng;grades[1]=math;grades[2]=sci;grades[3]=FA;grades[4]=SS;
    }
    public double calcGPA(){
        double cc=0;
        for(int i=0;i<grades.length;i++){
            cc+=grades[i];
        }
        cc=cc/5;
        return cc;
    }
    public Student(){ //zero arg
        firstName="";lastName="";GPA=0;gradYear=0000;
        for(int i=0;i<grades.length;i++){
            grades[i]=0.0;
        }
    }
    public Student(String fn,String ln,double gp,int gy){ //basic arg
        this.firstName=fn;
        this.lastName=ln;
        this.GPA=gp;
        this.gradYear=gy;
    }
    public Student(String fn,String ln,int gy,double f[]){ //array arg
        this.firstName=fn;
        this.lastName=ln;
        this.gradYear=gy;
        for(int i=0;i<grades.length;i++){
            grades[i]=f[i];
        }
        this.GPA=calcGPA();
    }
    public String toString(){
        return "Name: "+firstName+" "+lastName+"\n"+"Graduation year: "+gradYear+"\n"+"GPA: "+GPA;
    }
}



public class StudentDriver{ //Seperate file!
    public static void main(String args[]){
        //Student frosh001=new Student("Barack","Obama",2.3,2023);
        //System.out.println(frosh001);
        double georgeG[]={2.4,5,3.5,2.3,3.7};
        Student ex001=new Student("George","Bush",2020,georgeG);
        System.out.println(ex001);
    }
}
