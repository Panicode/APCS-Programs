class MySong{
    String name;
    int rating;
    public MySong(String name,int ye){
        this.name=name;
        this.rating=ye;
    }
    public String toString(){
        return "The song's name is: "+name+"\n"+"the song's rating is: "+rating;
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
    public String toString(){
        String prnt="";
        for(int i=0;i<songList.length;i++){
            for(int j=0;j<songList[0].length;j++){
                prnt+="The name of the song is: "+songList[i][j].name+"\n"+"The rating is: "+songList[i][j].rating+"\n";
            }
        }
        return prnt;
    }
    public static void main(String args[]){
        Jukebox obj1= new Jukebox();
        System.out.println(obj1);
    }
}
