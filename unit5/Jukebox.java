class MySong{
    String name;
    int yearReleased;
    String artist;
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
    public MySong(){
        name="The good life";
        yearReleased=1996;
        artist="Weezer";
    }
    public MySong(String name,int year,String artist){
        this.name=name;
        this.yearReleased=year;
        this.artist=artist;
    }
    public MySong(String name,int year){
        this.name=name;
        this.yearReleased=year;
    }
    public String toString(){
        return "The song's name is: "+name+"\n"+"the song's date is: "+yearReleased+"\n"+"the song's artist is: "+artist;
    }
}
public class Jukebox{
    MySong songList[][]=new MySong[3][4];
    public Jukebox(){
        songList[0][0] = new MySong( "Jet Airliner", 5 ); 
        songList[0][1] = new MySong( "Slide",  4 ); 
        songList[0][2] = new MySong( "Tom Sawyer", 3 ); 
        songList[0][3] = new MySong( "Purple Rain", 2 ); 
        songList[1][0] = new MySong( "Sing a Song", 1 ); 
        songList[1][1] = new MySong( "Baba O'Riley", 5 );
        songList[1][2] = new MySong( "Jumper", 4 );   
        songList[1][3] = new MySong( "Car Wash", 3 ); 
        songList[2][0] = new MySong( "Kung Fu Fighting", 2 ); 
        songList[2][1] = new MySong( "Right as Rain", 4 ); 
        songList[2][2] = new MySong( "Beat It", 5 ); 
        songList[2][3] = new MySong( "Bust a Move", 4 );   
        
    }
}
