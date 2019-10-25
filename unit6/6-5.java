abstract class MyPolygon{
    String name="";
    String color="";
    int leg1=0;
    int leg2=0;
    public MyPolygon(String na, String co, int le1, int le2){
        name=na;
        color=co;
        leg1=le1;
        leg2=le2;
    }
    public String toString(){
        return name+"'s variables:"+"\ncolor: "+color+"\nleg1: "+leg1+"\nleg2: "+leg2;
    }
    String getFirstLeg(){
        return Integer.toString(leg1);
    }
    String getSecondLeg(){
        return Integer.toString(leg2);
    }
    abstract int getPerimeter();
    abstract double getArea();
}
class MyRect extends MyPolygon{
    MyRect(String na, String co, int len, int wid){
        super(na,co,len,wid);
    }
    int getPerimeter(){
        return leg1*2+leg2*2;
    }
    double getArea(){
        return leg1*leg2;
    }
    public String toString(){
        return name+"'s variables:\n"+"\ncolor: "+color+"\nlength: "+leg1+"\nwidth: "+leg2;
    }
}
class MyTrap extends MyPolygon{
    private int base1;
    private int base2;
    private int height;
    MyTrap(String na, String co, int len, int wid,int b1, int b2, int he){
        super(na,co,len,wid);
        base1=b1;
        base2=b2;
        height=he;
    }
    int getPerimeter(){
        return leg1+leg2+base1+base2;
    }
    double getArea(){
        return (base1+base2)/2*height;
    }
    public String toString(){
        return name+"'s variables:\n"+"\ncolor: "+color+"\nfirst leg: "+leg1+"\nsecond leg: "+leg2
        +"\nbase 1: "+base1+"\nbase 2: "+base2+"\nheight: "+height;
    }
}
class MyRhom extends MyPolygon{
    private int diag1;
    private int diag2;
    MyRhom(String na, String co, int len, int wid,int da1, int da2){
        super(na,co,len,wid);
        diag1=da1;
        diag2=da2;
    }
    int getPerimeter(){
        return leg1*4;
    }
    double getArea(){
        return (diag1*diag2)/2;
    }
    public String toString(){
        return name+"'s variables:\n"+"\ncolor: "+color+"\nlength: "+leg1+"\nwidth: "+leg2
        +"\ndiagonal 1: "+diag1+"\ndiagonal 2: "+diag2;
    }
}
class MyCirc{
    private String name;
    private String color;
    private int radius;
    public MyCirc(String nam, String co, int rad){
        name=nam;
        color=co;
        radius=rad;
    }
    double getArea(){
        return Math.pow(Math.PI*radius,2);
    }
    double getPerimeter(){
        return 2*Math.PI*radius;
    }
}
public class Main{
    public static void main(String[] args){
        MyPolygon[] polys=new MyPolygon[4];
        polys[0]=new MyRect("rectangle","blue",3,5);
        polys[1]=new MyTrap("trapezoid","purple",4,4,3,5,6);
        polys[2]=new MyRhom("rhombus","green",5,5,4,6);
        for(MyPolygon poly:polys){
            if(poly!=null){
                System.out.println("\n"+poly);
            }
        }
    }
}
