import java.util.Scanner;

public class IntegerSetup{
  public static void main(String args[]){
      Scanner input = new Scanner(System.in);
      while(true){
      System.out.println("Input the first number");
      int number1 = input.nextInt();
      System.out.println("The first number's value is: "+ number1);
      System.out.println("Input the second number");
      int number2 = input.nextInt();
      System.out.println("The second number's value is: "+ number2);
      if(number1 > number2){
          System.out.println("The first number is greater than the second number.");
          System.out.println(number1+">"+number2);
        }else if(number1 < number2){
            System.out.println("The first number is less than the second number.");
            System.out.println(number1+"<"+number2);
        }else if(number1 == number2){
            System.out.println("The two numbers are equal.");
            System.out.println(number1+"="+number2);
        }
    }
  }
}
