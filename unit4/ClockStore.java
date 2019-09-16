public class ClockStore{ //Make sure to have the "Clock" class!
    private Clock clocksInStock[]=new Clock[3];
    public ClockStore(){
        clocksInStock[0]=new Clock(12,30,45);
        clocksInStock[1]=new Clock(10,20,55);
        clocksInStock[2]=new Clock(8,10,20);
    }
    int mostSeconds(){
        int most=0;
        int temp=0;
        for(int i=0;i<clocksInStock.length;i++){
            temp = clocksInStock[i].totalSeconds(clocksInStock[i].hours,clocksInStock[i].minutes,clocksInStock[i].seconds);
            if(temp > most){
                most = temp;
            }
        }
        return most;
    }
    public String toString(){
        String clockst="\n";
        for(int i=0;i<clocksInStock.length;i++){
            clockst=clockst+"\n"+clocksInStock[i];
        }
        return "The clocks' toString's are: "+clockst;
    }
}


public class ClockDriver{ //seperate file!
    public static void main(String []args){
        ClockStore obj1 = new ClockStore();
        System.out.println("The clocksInStock's mostseconds are: "+obj1.mostSeconds()+"\n");
        System.out.println(obj1);
    }
}
