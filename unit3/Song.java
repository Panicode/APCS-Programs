public class Song{
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
    public static void main(String args[]){
        Song obj=new Song();
        System.out.println(obj);
    }
}
