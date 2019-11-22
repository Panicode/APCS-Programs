/*This file can be executed and it can help you with programming simple statements! Have fun!*/

public class Help2{
  public static void main(String[] args)throws java.io.IOException{
    char coice, ignore;
    do{
      System.out.println("Help on:");
      System.out.println("  1. if\n  2. switch\n  3. for\n  4. while\n  5.d-while\n\nChoose one: ");
      choice=(char)System.in.read();
      do{
        ignore=(char)System.in.read();
      }while(ignore!='\n');
    }while(choice<'1'|choice>'5')
    System.out.println("\n");
    switch(choice){
      case '1':
        System.out.println("The if:\n\nThe if statement is usually used for a particular system of checking variable(s) in order to finish a function.\nThe standard way to portray an if statement is:\n\nif(condition) statement;\n\nA else statement can be used in this if the if statement fails.");break;
      case '2':
        System.out.println("The switch:\n\nA switch expression is wayyyyy better than many if statements being used right next to each other. the standard usage for a switch expresion is:\n\nswitch(expression){\n  case constant:\n    statement sequence\n    break;(break is optional, it could be voided in order to run all other switch statements without checking them.)\n//...\n}");break;
      case '3':
        System.out.println("");break;
      case '4':
        System.out.println("");break;
      case '5':
        System.out.println("");break;
    }
  }
}
