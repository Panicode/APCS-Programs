public class MyPod{ //Must have the "Song" Class!
    String color;
    int capGB;
    Song songLibrary[]= new Song[3];
    public MyPod(){
        color="";
        capGB=0;
    }
    public MyPod(String co, int cap, Song sng[]){
        this.color=co;
        this.capGB=cap;
        for(int i=0;i<sng.length;i++){
            this.songLibrary[i]=sng[i];
        }
    }
    public String toString(){
        String sp="";
        for(Song item:songLibrary){ //"Use a for-each loop instead of the typical for loop."
            sp=sp+item+"\n";
        }
        return "The MyPod's color is: "+color+", The Capacity is: "+capGB+"GB, and the songs are:"+"\n"+sp;
    }
}

public class MyPodDriver{ //Seperate file!
    public static void main(String []args){
        Song songd[]=new Song[3];
        songd[0]=new Song("The good life",1996,"Weezer");
        songd[1]=new Song("Dancin",2005,"Aaron Smith");
        songd[2]=new Song("It's raining tacos",2013,"Parry Gripp");
        MyPod carPod=new MyPod("Red",64,songd);
        System.out.println(carPod);
    }
}
