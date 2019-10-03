class MyShape{
    String name="";
    String color="";
    MyShape(String na, String co){
        name=na;
        color=co;
    }
    String ToString(){
        return name+"'s variables:\n"+"\ncolor: "+color;
    }
}
class MyRectangle extends MyShape{
    int length=0;
    int width=0;
    MyRectangle(String na, String co, int len, int wid){
        super(na, co);
        length=len;
        width=wid;
    }
    int getArea(){
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
    int base1=0;
    int base2=0;
    int leg1=0;
    int leg2=0;
    double height=0;
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
    int base=0;
    int leg1=0;
    int leg2=0;
    double height=0;
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
public class MyShapeDriver{
    public static void main(String args[]){
        MyShape shapes[]=new MyShape[3];
        shapes[0]=new MyRectangle("Rectangle","green",10,15);
        shapes[1]=new MyTrapezoid("Trapezoid","blue",10,15,7,7,6.54);
        shapes[2]=new MyTriangle("Triangle","purple",5,5,5,4.33);
        for(int i=0;i<shapes.length;i++){
            System.out.println(shapes[i].ToString()+"\n");
        }
    }
}





