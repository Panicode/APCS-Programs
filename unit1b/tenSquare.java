public class tenSquare{
     public static void main(String []args){
        for(int i=1;i<=10;i++){
            double ic=Math.pow(i,2);
            long icr=Math.round(ic);
            int rand=(int)(Math.random()*ic+1);
            System.out.println(i+"\t"+icr+"\t"+rand);
        }
}}
