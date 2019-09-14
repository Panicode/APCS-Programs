import java.util.Scanner;
class createNewPassword{ // 3.8
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        boolean rest=false;
        System.out.println("Please input a password!"+"\n"+"The password has to have a length of at least 6 characters"+"\n"+"and at least one non-alphanumeric character");
        while(rest==false){
            String inpass=input.nextLine();
            int inlength = inpass.length();
            boolean ch=inpass.matches("^.*[^a-zA-Z0-9 ].*$");
            //System.out.println(inpass.substring(3,4));
            if(inlength>=6&&ch==true){
                System.out.println("\n"+"~Valid Password!~");
                rest=true;
            }else{
                System.out.println("\n"+"~Invalid Password, Please try again!~"+"\n");
                System.out.println("Remember:"+"\n"+"The password has to have a length of at least 6 characters"+"\n"+"and at least one non-alphanumeric character");
            }
        }
    }
}
