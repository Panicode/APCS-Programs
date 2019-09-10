//Unit 2 1.6
public class BaseBallAverages{
    public static void main(String args[]){
        double bbv[]=new double[9];
        for(int i=0;i<bbv.length;i++){
            bbv[i]=(double)(Math.random()*0.5);
        }
        for(int i=0;i<bbv.length;i++){
            System.out.println(bbv[i]);
        }
        double max=bbv[0];
        for(int i=0;i<bbv.length;i++){
            if(i!=0){
                if(bbv[i]>max){
                    max=bbv[i];
                }
            }
        }
        System.out.println("The maximum value is: "+max+".");
    }
}
