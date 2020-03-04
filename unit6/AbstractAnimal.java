abstract class Animal{
    protected String name;
    protected String sex;
    protected int age;
    protected String sound;
    public Animal(String name, String sex, int age,String sound){
        this.name=name;
        this.sex=sex;
        this.age=age;
        this.sound=sound;
    }   
    public String getName(){
        return name;
    }
    public String toString(){
        return "Name: "+name+"\nSex: "+sex+"\nage: "+age+"\n"+toStringSpecial();
    }
    abstract String toStringSpecial();
}
class Dogs extends Animal{
    private String breed;
    public Dogs(){
        super("Dog","None",0,"Woof!");
        this.breed="Breed";
    }
    public Dogs(String name, String sex, int age, String breed){
        super(name,sex,age,"Woof!");
        this.breed=breed;
    }
    public String toStringSpecial(){
        return "Breed: "+breed;
    }
}
class Cats extends Animal{
    private String favToy;
    public Cats(){
        super("Cat","None",0,"Meow!");
        this.favToy="Toy";
    }
    public Cats(String name, String sex, int age, String favToy){
        super(name,sex,age,"Meow!");
        this.favToy=favToy;
    }
    public String toStringSpecial(){
        return "Favorite toy: "+favToy;
    }
}
class Rabbits extends Animal{
    private boolean isFixed;
    public Rabbits(){
        super("Rabbit","None",0,"Purr!");
        this.isFixed=true;
    }
    public Rabbits(String name, String sex, int age, boolean isFixed){
        super(name,sex,age,"Purr!");
        this.isFixed=isFixed;
    }
    public String toStringSpecial(){
        return "Are they fixed? "+isFixed;
    }
}
public class AnimalDriver{
    public static void main(String[] args){
        Animal[] Pound={
            new Dogs(),
            new Dogs("Charles","male",6,"Poodle"),
            new Dogs("Doggie","male",1,"Shepard"),
            new Cats("Mittens","female",2,"string")};
    }
}
