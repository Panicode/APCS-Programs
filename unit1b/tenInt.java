//for classwork 1.5
public class tenInt{
    public static void main(String []args){
        int values[]=new int[10];
        for(int i=0;i<values.length;i++){
            values[i]=(int)(Math.random()*100+1);
            int chance=(int)(Math.random()*2+1);
            if(chance==1){values[i]=values[i]*-1;}
        }
        int ye=0;
        while(ye<values.length){System.out.println(values[ye]);ye++;}
        int valofneg=0;
        for(int i=0;i<values.length;i++){
           if(values[i]<0){valofneg++;}
        }
        System.out.println("The amount of negative numbers are: "+valofneg);
    }
}
