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
        length=0;
        width=0;
    }
    String ToString(){
        return name+"'s variables:\n"+"\ncolor: "+color+"\nlength: "+length+"\nwidth: "+width;
    }
    int getArea(){
        return length*width;
    }
    int getPerimeter(){
        return (length+width)*2;
    }
}
class MyTrapezoid extends MyShape{
    int base1=0;
    int base2=0;
    int leg1=0;
    int leg2=0;
    int height=0;
    MyTrapezoid(String na, String co,int b1,int b2, int l1, int l2,int he){
        super(na, co);
        base1=b1;
        base2=b2;
        leg1=l1;
        leg2=l2;
        height=he;
    }
    String ToString(){
        return name+"'s variables:\n"+"\ncolor: "+color+"\nfirst base: "+base1+"\nsecond base: "+base2
        +"\nfirst leg: "+leg1+"\nsecond leg: "+leg2;
    }
    int getArea(){
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
    int height=0;
    MyTriangle(String na, String co, int ba, int le1, int le2, int he){
        super(na, co);
        base=ba;
        leg1=le1;
        leg2=le2;
        height=he;
    }
    String ToString(){
        return name+"'s variables:\n"+"\ncolor: "+color;
    }
    int getArea(){
        return (base*height)/2;
    }
    int getPerimeter(){
        return leg1+leg2+base;
    }
}
public class MyShapeDriver{
    public static void main(String args[]){
        MyShape shapes[]=new MyShape[0];
        shapes[0]=new MyRectangle();
        shapes[1]=new MyTrapezoid();
        shapes[2]=new MyTriangle();
    }
}





