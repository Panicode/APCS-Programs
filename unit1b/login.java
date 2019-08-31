import java.util.Scanner;
public class login{
    public static void main(String []args){
        Scanner input=new Scanner(System.in);
        String username="Panic";
        int password=1337;
        System.out.println("Please enter your username.");
        System.out.print("username:");
        String inuser=input.nextLine();
        System.out.println("Please enter your password.");
        System.out.print("password:");
        int inpass=input.nextInt();
        if(inuser.contains(username)&&inpass==password){
            System.out.println("Login Successful.");
        }else{System.out.println("Login Failed.");}
    }
}
