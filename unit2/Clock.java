class Clock{
    int seconds;
    int minutes;
    int hours;
    public Clock(){
        seconds=0;
        minutes=0;
        hours=0;
    }
    public Clock(int s,int m,int h){
        this.seconds=s;
        this.minutes=m;
        this.hours=h;
    }
    public String toString(){
       return hours+":"+minutes+":"+seconds;
    }
    public static void main(String args[]){
        Clock obj=new Clock(1,1,1);
        System.out.println(obj);
    }
}
class ClockDriver{
    public static void main(String args[]){
        Clock kitchenClock=new Clock(2,2,2);
        System.out.println(kitchenClock);
        Clock bedroomClock=new Clock(3,3,3);
        System.out.println(bedroomClock);
    }
}
