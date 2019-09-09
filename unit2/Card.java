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
public class CardDriver{
    public static void main(String []args){
        Card crd1=new Card("Clubs",5);
        Card crd2=new Card("hearts",10,"King");
        Card crd3=new Card("Spades",1);
        Card crdar[]={crd1,crd2,crd3};
        for(int i=0;i<crdar.length;i++){
            System.out.println(crdar[i]);
        }
    }
}
