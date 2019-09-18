public class Rand2D{
    public static void main(String[] args){
        int [][] arr = new int [3][4];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 4; j++){
                arr[i][j] =  (int) (Math.random()* 9) ;
            }
        }
        for(int k = 0; k < 3; k++){
            for(int l = 0; l < 4; l++){
                System.out.print(arr[k][l] + " ");
            }
            System.out.println();
        }
    }
}
