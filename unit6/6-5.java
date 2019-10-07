class MyPolygon{
    String name="";
    String color="";
    int leg1=0;
    int leg2=0;
    MyPolygon(String na, String co, int le1, int le2){
        name=na;
        color=co;
        leg1=le1;
        leg2=le2;
    }
    String ToString(){
        return name+"'s variables:"+"\ncolor: "+color+"\nleg1: "+leg1+"\nleg2: "+leg2;
    }
    String getFirstLeg(){
        return leg1;
    }
    String getSecondLeg(){
        return leg2;
    }
}
class MyRect extends MyPolygon{
    
}





public class Main(){
    public static void main(String[] args){
        
    }
}
