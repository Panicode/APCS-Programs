/*This file can be executed and it can help you with programming simple statements! Have fun!*/
import java.util.Scanner;
public class HelpDesk{
  public static void main(String[] args){
    String check="";
    System.out.println("Do you want to learn about java? y/n");
    do{
      Scanner input=new Scanner(System.in);
      check=input.nextLine();
    }while((!check.contains("y"))&&(!check.contains("n")));
    if(check.contains("y")&&check.contains("n"))new HelpDesk().main(args);
    if(check.contains("y")){
      try{
        new HelpDesk().Help();
      }catch(java.io.IOException e){}
    }else{System.out.println("Okay!! Have fun!! :)");System.exit(0);}
  }
  public void Help()throws java.io.IOException{
    char choice, ignore;
    do{
      System.out.println("Help on:");
      System.out.println("  1. if\n  2. switch\n  3. for\n  4. while\n  5. do-while\n\nChoose one: ");
      choice=(char)System.in.read();
      do{
        ignore=(char)System.in.read();
      }while(ignore!='\n');
    }while(choice<'1'|choice>'5');
    System.out.println("\n");
    switch(choice){
      case '1':
        System.out.println("The if:\n\nThe if statement is usually used for a particular system of checking variable(s) in order to finish a function.\nThe standard way to portray an if statement is:\n\nif(condition) statement;\n\nA else statement can be used in this if the if statement fails.");break;
      case '2':
        System.out.println("The switch:\n\nA switch expression is wayyyyy better than many if statements being used right next to each other. the standard usage for a switch expresion is:\n\nswitch(expression){\n  case constant:\n    statement sequence\n    break;\n    //break is optional, it could be voided in order to run all other switch statements without checking them.\n    //...\n}");break;
      case '3':
        System.out.println("The for:\n\nA for loop is primarily used for iteration and recursion with subtle variable changing.\nThe standard usage of a for loop is:\n\nfor(init;condition;iteration){ //A for loop can skip all statements (for(;;){})or any statements by that standard.\n   statement; //could iterate with the init's iteration condition.\n}");break;
      case '4':
        System.out.println("The while:\n\nWhile(condition){\n   statement;\n}\n\nA while loop checks if a statement is true in order to run through the statement, it could run infinitely.");break;
      case '5':
        System.out.println("The do-while:\n\ndo{\n  statement;\n}while(condition);\n\nA do-while loop is the same as a while, but checks at the bottom of the statement.");break;
    }
  }
}
