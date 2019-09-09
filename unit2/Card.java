public class Card{
    String csuit="";
    int cval=0;
    String cface="";
    public Card(){
        csuit="Blank";
        cval=0;
    }
    public Card(String a,int b,String c){
        csuit=a;
        cval=b;
        cface=c;
    }
    public Card(String a,int b){
        csuit=a;
        cval=b;
    }
}
