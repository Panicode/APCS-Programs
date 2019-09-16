//Improved!

class Texter{
    public void exec(String inp){
        try{for(int i=0;i<inp.length();i++){
                System.out.print(inp.substring(i,i+1));
                Thread.sleep(80);//Time
            }
        }catch(InterruptedException e){}
    }
}
public class Driver{
    public static void main(String []args){
        Texter obj1 = new Texter();
        obj1.exec("Bruh.");
    }
}
