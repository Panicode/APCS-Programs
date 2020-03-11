abstract class Shapes{
    protected String name,color;
    public Shapes(String name,String color){
        this.name=name;
        this.color=color;
    }
    abstract int getPerimeter();
    abstract int getArea();
    abstract String toStringSpecial();
    public String toString(){
        return "name: "+name+"\ncolor: "+color+"\n"+toStringSpecial()+"\nperimeter: "+getPerimeter()+"\narea: "+getArea();
    }
}
class Rectangle extends Shapes{
    int width,height;
    public Rectangle(String name,String color,int width,int height){
        super(name,color);
        this.width=width;this.height=height;
    }
    int getPerimeter(){
        return width*2+height*2;
    }
    int getArea(){
        return width*height;
    }
    String toStringSpecial(){
        return "width: "+width+"\nheight: "+height;
    }
}
class Triangle extends Shapes{
    int leg1,leg2,base,height;
    public Triangle(String name,String color,int base,int height,int leg1,int leg2){
        super(name,color);
        this.base=base;this.height=height;this.leg1=leg1;this.leg2=leg2;
    }
    int getPerimeter(){
        return base+leg1+leg2;
    }
    int getArea(){
        return (base*height)/2;
    }
    String toStringSpecial(){
        return "base: "+base+"\nheight: "+height+"\nleg 1: "+leg1+"\nleg2: "+leg2;
    }
}
class Trapezoid extends Shapes{
    int leg1,leg2,base1,base2,height;
    public Trapezoid(String name,String color,int base1,int base2,int height,int leg1,int leg2){
        super(name,color);
        this.base1=base1;this.base2=base2;this.height=height;this.leg1=leg1;this.leg2=leg2;
    }
    int getPerimeter(){
        return base1+base2+leg1+leg2;
    }
    int getArea(){
        return ((base1+base2)/2)*height;
    }
    String toStringSpecial(){
        return "base 1: "+base1+"\nbase 2: "+base2+"\nheight: "+height+"\nleg 1: "+leg1+"\nleg2: "+leg2;
    }
}
public class ShapeDriver{
    public static void main(String[] args){
        Shapes[] shapes={
        new Rectangle("rectangle","green",7,5),
        new Triangle("triangle","purple",10,7,4,4),
        new Trapezoid("trapezoid","yellow",10,7,4,3,3)
        };
        for(Shapes a:shapes){
            System.out.println(a+"\n");
        }
    }
}
