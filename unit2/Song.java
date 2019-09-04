//2.1
public class Song{
    String name;
    int year;
    String artist;
    public Song(){
        name="The good life";
        year=1996;
        artist="Weezer";
    }
    public Song(String name,int year,String artist){
        this.name=name;
        this.year=year;
        this.artist=artist;
    }
    public String toString(){
        return "The song's name is: "+name+", and the song's date is: "+year+", and the song's artist is: "+artist;
    }
    public static void main(String args[]){
        Song obj=new Song();
        System.out.println(obj);
    }
}



public class SongDriver{ //This is a new class that was needed for 2.1
    String name;
    int year;
    String artist;
    public SongDriver(){
        name="Megalovania";
        year=2015;
        artist="Toby Fox";
    }
    public SongDriver(String name,int year,String artist){
        this.name=name;
        this.year=year;
        this.artist=artist;
    }
    public String toString(){
        return "The song's name is: "+name+", and the song's date is: "+year+", and the song's artist is: "+artist;
    }
    public static void main(String args[]){
        SongDriver song1=new SongDriver();
        SongDriver song2=new SongDriver("Feel Good Inc.",2005,"Gorillaz");
        System.out.println("Song1:");
        System.out.println(song1);
        System.out.println("Song2:");
        System.out.println(song2);
    }
}
