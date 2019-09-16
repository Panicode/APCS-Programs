public class texter{
    public static void main(String args[])throws InterruptedException { //throws InterruptedException is NEEDED
        String in="Bruh.";
        for(int i=0;i<in.length();i++){
        System.out.print(in.substring(i,i+1));
        Thread.sleep(80);
        }
    }
}
