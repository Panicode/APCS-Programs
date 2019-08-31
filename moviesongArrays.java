public class moviesongArrays{
    public static void main(String []args){
        String movies[]={"Monty Python and the Holy grail","Superbad","Gravity"}; 
        String songs[]={"Despacito","Ram Ranch","Gandam Style"};
        for(int i=0;i<movies.length;i++){System.out.println(movies[i]);}
        System.out.println("\n");
        int y=0;
        while(y<songs.length){System.out.println(songs[y]);y++;}
    }
}
