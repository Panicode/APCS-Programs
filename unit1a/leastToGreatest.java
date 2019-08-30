import java.util.Scanner;
public class leastToGreatest{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter three integers");
        int num1 = input.nextInt();
        System.out.println("The first integer is: "+num1);
        int num2 = input.nextInt();
        System.out.println("The second integer is: "+num2);
        int num3 = input.nextInt();
        System.out.println("The third integer is: "+num3);
        if (num1>num2){
            int temp = num1;num1 = num2;num2 = temp;
        }if(num2>num3){
            int temp = num2;num2 = num3;num3 = temp;
        }if (num1>num2){
            int temp = num1;num1 = num2;num2 = temp;
        }
        System.out.print("The numbers in order from least to greatest are: "+num1+" "+num2+" "+num3);
    }
}
