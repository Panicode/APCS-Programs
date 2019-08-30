//Write a program that gives a prompt to input two integers, then use the new scanner class to enter those two integers. Call those integers number1 and number2. Use ” if statements “ 
//to determine which integer is larger  and using System.out.println output the statements,
//“the value of number1 is 5 and it is greater than number2 whose value is 1” or “the value of number2 is 5 and 
//it is greater than number1 whose value is 1” or  ”number1 and number2 have the same value which is 5”.
//(the values of number1 and number2 will be entered by the user and can be any integer value).

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
