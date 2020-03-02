import java.util.Scanner;
public class WarmUpU5{
    public static void main(String[] args){
        new WarmUpU5().start();
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
        System.out.println("The amount of a's are: "+countChar(nums,'a'));
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
