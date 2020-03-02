import java.util.Scanner;
public class WarmUpU5{
    public static void main(String[] args){
        new WarmUpU5().start();
        new WarmUpU52().start();
    }
    private void start(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Input dimension X");int xin=scan.nextInt();
        System.out.println("Input dimension Y");int yin=scan.nextInt();
        char[][] nums=new char[yin][xin];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                nums[i][j]=(char)((int)(Math.random()*6)+97);
            }
        }
        for(char[] ar:nums){
            for(char arr:ar){
                System.out.print(arr+" ");
            }
            System.out.println();
        }
        System.out.println("Input char to find");char cin=scan.next().charAt(0);
        System.out.println("The amount of "+cin+"'s are: "+countChar(nums,cin));
    }
    private int countChar(char[][] list, char find){
        int count=0;
        for(char[] ar:list){
            for(char arr:ar){
                if(arr==find)count++;
            }
        }
        return count;
    }
}
class WarmUpU52{
    public void start(){
        System.out.println("\n\nWarmup part 2:\n");
        Scanner scan=new Scanner(System.in);
        System.out.println("Input dimension X");int xin=scan.nextInt();
        System.out.println("Input dimension Y");int yin=scan.nextInt();
        String[][] nums=new String[yin][xin];
        System.out.println("Input phrase");String pin=new Scanner(System.in).nextLine();
        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                if(count<=pin.length()){
                    int po=(int)(Math.random()*pin.length());
                    nums[i][j]=pin.substring(po,po+1);
                }else{nums[i][j]=null;}
                count++;
            }
        }
        for(String[] ar:nums){
            for(String arr:ar){
                System.out.print(arr+" ");
            }
            System.out.println();
        }
    }
}
