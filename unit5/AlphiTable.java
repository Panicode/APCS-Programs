//5.4
public class AlphiTable{
    public static void main(String args[]){
        String arr[][]=new String[16][3];
        char che='a';
        boolean check=true;
        for(int k=0;k<arr.length;k++){
            for(int l=0;l<arr[0].length;l++){
                arr[k][l]=""; //defining variable so it isn't null
                arr[k][l]+=che;
                if(check){
                    System.out.print(arr[k][l]+" ");
                }else{
                    System.out.print(" "+arr[k][l]);
                    if(l>=arr[0].length-2)l++;
                }
                if(che=='z'){
                    che='a';
                }else{che++;}
            }
            check = !check;
            System.out.println();
        }
    }
}
