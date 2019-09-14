public class Student{
    String firstName;
    String lastName;
    double GPA;
    int gradYear;
    double grades[]=new double[5];
    public void setGPA(double eng,double math,double sci,double FA,double SS){
        grades[0]=eng;grades[1]=math;grades[2]=sci;grades[3]=FA;grades[4]=SS;
        double ee=0;
        for(int i=0;i<grades.length;i++){
            ee+=grades[i];
        }
        ee=ee/5;
        this.GPA=ee;
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
        double geG[]={4.0,4,3.5,4,4};
        Student ex001=new Student("Joe","Senior",2020,geG);
        System.out.println(ex001);
        System.out.println("~Grad Change!~");
        ex001.setGPA(4.0,4.0,4.0,4.0,4.0);
        System.out.println(ex001);
    }
}
