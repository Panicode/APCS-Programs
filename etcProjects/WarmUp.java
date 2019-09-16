//for all you pesky cheaters ;3

public class WarmUp{
    public static void main(String []args){
        int arr[]=new int[20];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*20)+51;
        }
        boolean iffound=false;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==55){
                System.out.println("The number 55 was found at the index of: "+i);
                iffound=true;
            }
        }
        if(iffound==false){
        System.out.println("The number 55 was not found");
        }
    }
}
