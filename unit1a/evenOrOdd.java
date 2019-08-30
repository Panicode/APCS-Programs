import java.util.Scanner;
public class evenOrOdd{
    public static void main(String args[])
  {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter the intger to see if it's odd or even.");
      int num1 = input.nextInt();
      if(num1%2==0){
        System.out.println("The number is even.");
      }else{
        System.out.println("The number is odd.");
      }
  }
}
