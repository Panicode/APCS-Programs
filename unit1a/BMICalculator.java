import java.util.Scanner;
public class BMICalculator{
    public static void main(String args[]){
    Scanner input = new Scanner(System.in);
      
    System.out.println("Input your weight in pounds.");
      int weight = input.nextInt();
      System.out.println("Your weight is: "+ weight+"lbs");
      System.out.println("Input you height in inches.");
      int height = input.nextInt();
      System.out.println("Your height is: "+ height+"in");
      double kiloc=(weight*0.45359237);
      double heigc=(height*0.0254);
      double sqhei=Math.pow(heigc,2);
      double BMI=(kiloc/sqhei);
      System.out.print("For a weight of "+kiloc+" pounds and a height of "+heigc+" inches, Your BMI is: "+Math.round(BMI));
  }
}
