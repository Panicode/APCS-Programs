public class findingMichael{
    public static void main(String []args){
        String artists[]={"Soulja Boy","Obama","Jack Stauber"};
        for(int i=0;i<artists.length;i++){System.out.println(artists[i]);}
        System.out.println("");
        int rand=(int)(Math.random()*3);
        artists[rand]="Michael Jackson";
        for(int i=0;i<artists.length;i++){System.out.println(artists[i]);}
        System.out.println("Michael Jackson has arrived."+"\n");
        boolean foundMichael=false;
        for(int i=0;i<artists.length;i++){
            if(artists[i].contains("Michael Jackson")){
                System.out.println("We found Michael, He was in music("+i+")");foundMichael=true;
            }
            if(foundMichael==false){System.out.println("No Michael in music("+i+")");foundMichael=false;}
        }
    }
}
