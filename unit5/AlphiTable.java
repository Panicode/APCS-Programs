//5.4
public class AlphiTable{
    public static void main(String args[]){
        String arr[][]=new String[8][8];
        char che='a';
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=""; //defining variable so it isn't null
                arr[i][j]+=che;
                if(che=='z'){
                    che='a';
                }else{che++;}
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
