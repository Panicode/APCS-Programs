//2.1
class Song{
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
public class SongDriver{
    public static void main(String args[]){
        Song song1=new Song();
        Song song2=new Song("Feel Good Inc.",2005,"Gorillaz");
        System.out.println("Song1:");
        System.out.println(song1);
        System.out.println("Song2:");
        System.out.println(song2);
    }
}
