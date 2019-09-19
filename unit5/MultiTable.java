//5.3
public class MultiTable{
    public static void main(String args[]){
        int arr[][]=new int[8][8];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=(i+1)*(j+1);
            }
        }
        for(int k=0;k<arr.length;k++){
            for(int l=0;l<arr[0].length;l++){
                System.out.print(arr[k][l]+" "); //Might wanna change the " " in this to "\t"
            }
            System.out.println();
        }
    }
}
