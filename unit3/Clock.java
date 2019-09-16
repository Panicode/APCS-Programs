public class Clock{
    int seconds;
    int minutes;
    int hours;
    public void setTime(int sec,int min,int hour){ //setter
        seconds=sec;
        minutes=min;
        hours=hour;
    }
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
    public void convertDaylightSaving(int hour){ //daylight savings
        hours+=hour;
    }
    public int totalSeconds(int h,int m,int s){
        return (h*3600)+(m*60)+s;
    }
    public String toString(){
       int tot=totalSeconds(hours,minutes,seconds);
       return "The time is: "+hours+":"+minutes+":"+seconds+"\n"+"The total seconds of this is: "+tot;
    }
    public static void main(String args[]){
        Clock obj=new Clock(1,1,1);
        System.out.println(obj);
    }
}

public class ClockDriver{ //Seperate file!
    public static void main(String []args){
        Clock obj1=new Clock();
        System.out.println(obj1);
        obj1.setTime(1,1,1);
        System.out.println("The hours are: "+"\n"+obj1);
        obj1.convertDaylightSaving(1);
        System.out.println("The hours including daylight savings is: "+"\n"+obj1);
    }
}
