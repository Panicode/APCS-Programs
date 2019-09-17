//4.6

import java.util.ArrayList;
public class MyPod2{ //Must have the "Song" Class!
    String color;
    int capGB;
    ArrayList<Song>songLibrary;                      // Here!
    public MyPod(){
        color="";
        capGB=0;
    }
    public MyPod(String co, int cap, Song sng[]){
        this.color=co;
        this.capGB=cap;
        for(int i=0;i<sng.length;i++){
            songLibrary.add(sng[i]);
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
