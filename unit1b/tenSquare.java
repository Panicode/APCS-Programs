//For APCS 1.3
public class tenSquare{
     public static void main(String []args){
        for(int i=1;i<=10;i++){
            double ic=Math.pow(i,2);
            long icr=Math.round(ic);
            double randch=icr-ic;
            int rand=(int)(Math.random()*randch+1);
            System.out.println(i+"\t"+icr+"\t"+rand);
        }
}}
