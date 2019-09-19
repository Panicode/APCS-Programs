//5.2
public class Fifteen2D{
    public static void main(String args[]){
        int arr[][]=new int[5][3];
        int ji=1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=ji;
                ji++;
            }
        }
        for(int u[]:arr){ //for each loop
            for(int jk:u){
                System.out.print(jk+"\t");
            }
            System.out.println();
        }
        int sum1=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                sum1+=arr[i][j];
            }
        }
        System.out.println("\n"+"The sum of all the numbers are: "+sum1);
        int sum2[]=new int[arr.length];
        int tempsum2=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                tempsum2+=arr[i][j];
            }
            sum2[i]=tempsum2;
            tempsum2=0;
        }
        System.out.println("\n"+"The sum of all the rows are:");
        for(int i=0;i<sum2.length;i++){
            System.out.print(sum2[i]+", ");
        }
        int sum3[]=new int[arr[0].length];
        int tempsum3=0;
        for(int i=0;i<arr[0].length;i++){
            for(int j=0;j<arr.length;j++){
                tempsum3+=arr[j][i];
            }
            sum3[i]=tempsum3;
            tempsum3=0;
        }
        System.out.println("\n"+"\n"+"The sum of all the columns are:");
        for(int i=0;i<sum3.length;i++){
            System.out.print(sum3[i]+", ");
        }
    }
}
