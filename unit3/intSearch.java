import javax.swing.*;
public class intSearch{
    int inte[]={-9,2,3,4,7,9,10,23,45,67,41,22,35,21,92,2048,44,51,32,89};
    int finder(int find){
        boolean check=false;
        for(int i=0;i<inte.length;i++){
            if(inte[i]==find){
               return i;
            }
        }
        return -1;
    }
    JFrame f;  //Challenge
    intSearch(){  
        f=new JFrame();   
        String integ=JOptionPane.showInputDialog(f,"Enter integer");     
        int num1 = Integer.parseInt(integ);
        System.out.println(finder(num1));
    } 
    public static void main(String []args){
        new intSearch();
    }
}
