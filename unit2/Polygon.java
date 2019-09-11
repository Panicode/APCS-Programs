public class Polygon{
    String polyname="";
    int sidecount=0;
    int polylen[]=new int[0];
    boolean ifd=false;
    String printf="";
    public Polygon(){
        ifd=true;
    }
    public Polygon(String nam,int cou,int len[]){
        polyname=nam;
        sidecount=len.length;
        polylen=new int[sidecount];
        for(int i=0;i<len.length;i++){
            polylen[i]=len[i];
        }
    }
    public String toString(){
        if(ifd==true){
            return "Invalid input!";
        }else{
            for(int i=0;i<polylen.length;i++){
                printf=printf+"\n"+"Line "+(i+1)+" has a length of: "+polylen[i]+"cm!";
            }
            return "The polygon: "+polyname+" has "+sidecount+" sides!"+printf;
        }
    }
}



public class PolygonDriver{
    public static void main(String []args){
        Polygon quadrilateral=new Polygon();
        //tri
        int triv[]={5,5,5};
        int triva=0;
        Polygon triangle=new Polygon("Triangle",3,triv);
        System.out.println(triangle);
        for(int i=0;i<triv.length;i++){
            triva=triva+triv[i];
        }
        double trir=triv[0]/Math.sqrt(3);
        double tria=2*Math.PI*trir;
        double trica=tria/trir;
        System.out.println("The primeter is: "+triva);
        System.out.println("The central angle is: "+trica);
        //tri
        //pent
        int trivd[]={8,8,8,8,8};
        int trivda=0;
        Polygon pentagon001=new Polygon("Pentagon",5,trivd);
        System.out.println(pentagon001);
        //pent
    }
}
