import java.util.Scanner;
public class gradeScore{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the precentage from 1-100 for a grade.");
        int grade = input.nextInt();
        if((grade<0)||(grade>100)){System.out.print("bruh that aint a precentage");}
        else if(grade>=90){System.out.print("You got an A!");}
        else if(grade>=80){System.out.print("You got a B!");}
        else if(grade>=70){System.out.print("You got a C.");}
        else if(grade>=60){System.out.print("You got an D..");}
        else if(grade<60){System.out.print("Your grade is unsatisfactory grade...");}

    }
}
