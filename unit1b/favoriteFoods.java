public class favoriteFoods{
    public static void main(String[] args){
        String foods[]={"Ice Cream","Italian Ice","Pretzels","Ramen","Sushi"};
        for(int i=0;i<foods.length;i++){System.out.println(foods[i]);}
        int rand=(int)(Math.random()*5);
        foods[rand]="Vegetables";
        int wh=0;
        while(wh<foods.length){
            if(wh<4){System.out.print(foods[wh]+", ");}
            else{System.out.print(foods[wh]);}wh++;
        }
    }
}
