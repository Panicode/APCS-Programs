public class Rand2D{
    public static void main(String args[]){
        int arr[][]=new int[3][4];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=(int)(Math.random()*9);
            }
        }
        for(int k=0;k<arr.length;k++){
            for(int l=0;l<arr[0].length;l++){
                System.out.print(arr[k][l]+" ");
            }
            System.out.println();
        }
    }
}
