abstract class MyShape{ //main class, all subclasses draw from this.
    String name="";
    String color="";
    public MyShape(String na, String co){
        name=na;
        color=co;
    }
    String ToString(){
        final String s = name + "'s variables:\n" + "\ncolor: " + color;
        return s;
    }
    abstract int getPerimeter();
    abstract double getArea();
}
class MyRectangle extends MyShape{
    private int length=0;
    private int width=0;
    MyRectangle(String na, String co, int len, int wid){
        super(na, co);
        length=len;
        width=wid;
    }
    double getArea(){
        return length*width;
    }
    int getPerimeter(){
        return (length+width)*2;
    }
    String ToString(){
        return name+"'s variables:\n"+"\ncolor: "+color+"\nlength: "+length+"\nwidth: "+width;
    }
}
class MyTrapezoid extends MyShape{
    private int base1=0;
    private int base2=0;
    private int leg1=0;
    private int leg2=0;
    private double height=0;
    MyTrapezoid(String na, String co,int b1,int b2, int l1, int l2,double he){
        super(na, co);
        base1=b1;
        base2=b2;
        leg1=l1;
        leg2=l2;
        height=he;
    }
    String ToString(){
        return name+"'s variables:\n"+"\ncolor: "+color+"\nfirst base: "+base1+"\nsecond base: "+base2
                +"\nfirst leg: "+leg1+"\nsecond leg: "+leg2+"\nheight: "+height;
    }
    double getArea(){
        return ((base1+base2)/2)*height;
    }
    int getPerimeter(){
        return base1+base2+leg1+leg2;
    }
}
class MyTriangle extends MyShape{
    private int base=0;
    private int leg1=0;
    private int leg2=0;
    private double height=0;
    MyTriangle(String na, String co, int ba, int le1, int le2, double he){
        super(na, co);
        base=ba;
        leg1=le1;
        leg2=le2;
        height=he;
    }
    double getArea(){
        return (base*height)/2;
    }
    int getPerimeter(){
        return leg1+leg2+base;
    }
    String ToString(){
        return name+"'s variables:\n"+"\ncolor: "+color+"\nfirst leg: "+leg1+"\nsecond leg: "
                +leg2+"\nbase length: "+base+"\nheight: "+height;
    }
}
class MyCircle extends MyShape{
    private int radius=0;
    double height=0;
    MyCircle(String na, String co, int rad){
        super(na, co);
        radius=rad;
    }
    int getPerimeter(){
        return (int) (Math.PI*2*radius);
    }
    double getArea(){
        return Math.pow(Math.PI*radius,2);
    }
    String ToString(){
        return name+"'s variables:\n"+"\ncolor: "+color+"\nradius: "+radius;
    }
}
public class MyShapeDriver{
    public static void main(String[] args){
        MyShape[] shapes =new MyShape[4];
        shapes[0]=new MyRectangle("Rectangle","green",10,15);
        shapes[1]=new MyTrapezoid("Trapezoid","blue",10,15,7,7,6.54);
        shapes[2]=new MyTriangle("Triangle","purple",5,5,5,4.33);
        shapes[3]=new MyCircle("Circle","black",5);
        for (MyShape shape : shapes) {
            System.out.println(shape.ToString() + "\n");
            System.out.println("Perimeter: "+shape.getPerimeter()+"\n");
            System.out.println("Area: "+shape.getArea()+"\n");
            //If a MyCircle subclass doesn't have a getArea() method, it doesn't work.
        }
    }
}
