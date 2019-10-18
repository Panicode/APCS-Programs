class Restaurant{
    String name;
    String cuisine;
    int ratingStar;
    int capacity;
    public Restaurant(){
        name="name";
        cuisine="cuisine";
        ratingStar=0;
        capacity=0;
    }
    public Restaurant(String nam,String cui,int star,int cap){
        this.name=nam;
        this.cuisine=cui;
        this.ratingStar=star;
        this.capacity=cap;
    }
    public String toString(){
        return name+"'s cuisine:\nDish: "+cuisine+"\nStar rating: "+ratingStar+
        "\nSeating capacity:"+ratingStar;
    }
}
public class RestaurantDriver{
    public static void main(String[] args){
        Restaurant[] restaurants={new Restaurant(),
        new Restaurant("Chef Boyardee's","spaghetti-os",2,1),
        new Restaurant("Gusteau's","Ratatouille",5,35),
        new Restaurant("diner","cool food",5,600),
        new Restaurant("sandwich place","sandwich",4,10)};
        for(int i=0;i<restaurants.length;i++){
            System.out.println(restaurants[i].toString()+"\n");
        }
        System.out.println("\nJoe has been added.\n");
        restaurants[(int)(Math.random()*5)]=new Restaurant("Joe's Sloop House","grub",1,5);
        for(int i=0;i<restaurants.length;i++){
            System.out.println(restaurants[i].toString()+"\n");
        }
    }
}
