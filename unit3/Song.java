import java.util.Scanner;
class SongLogin{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        String username="user";
        int password=1234;
        System.out.println("Please enter your username.");
        System.out.print("username:");
        String inuser=input.nextLine();
        System.out.println("Please enter your password.");
        System.out.print("password:");
        int inpass=input.nextInt();
        if(inuser.contains(username)&&inpass==password){
            System.out.println();
            System.out.print("Login Successful");
            for(int i=0;i<3;i++){
                try{
                Thread.sleep(400);
                System.out.print(".");
                }catch(InterruptedException e){}
            }
            System.out.println();
            System.out.println(2010);
            System.out.println(1999);
            System.out.println(2004);
        }else{System.out.println("Login Failed.");}
    }
}
class Song{
    String name;
    int yearReleased;
    String artist;
    //getter
    public String convertToMinSec(int secv){
        int sec=secv%60;
        int min=secv-sec;
        return "The length of the song is: "+min+" minutes and "+sec+" seconds.";
    }
    public int getYearReleased(){
       return yearReleased;
    }
    public void setYearReleased(int ye){
        yearReleased=ye;
    }
    //setter
    public Song(){
        name="The good life";
        yearReleased=1996;
        artist="Weezer";
    }
    public Song(String name,int year,String artist){
        this.name=name;
        this.yearReleased=year;
        this.artist=artist;
    }
    public String toString(){
        return "The song's name is: "+name+"\n"+"the song's date is: "+yearReleased+"\n"+"the song's artist is: "+artist;
    }
}
public class SongDriver{
    public boolean yesorno(){
        Scanner input=new Scanner(System.in);
        String ans=input.nextLine();
        if((ans.contains("y")&&ans.contains("n"))||(!ans.contains("y")&&!ans.contains("n"))){
            System.out.println("Invalid response! try again!");
            yesorno();
        }else if(ans.contains("y")){return true;}
        else if(ans.contains("n")){return false;}
        return false;
    }
    public static void main(String[] args){
        System.out.println("Here's the standard instance variables for three songs:");
        Song[] arr={new Song("Despacito",2010,"cool guy"),new Song("cool song",1999,"guy"),new Song("burger king",2004,"the song guy")};
        for(Song so:arr){
            System.out.println(so);
        }
        System.out.println("Do you wish to see all of the years released? y/n (You need a password!!)");
        SongDriver find=new SongDriver();
        boolean answer=find.yesorno();
        if(answer){
            new SongLogin().main(args);
        }
    }
}
