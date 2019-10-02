class MyVehicle{
    String make="";
    String model="";
    int value=0;
    MyVehicle(String ma, String mo, int va){
        make=ma;
        model=mo;
        value=va;
    }
    String ToString(){
        return "\nmake: "+make+"\nmodel: "+model+"\nvalue: "+value;
    }
}
class MyCar extends MyVehicle{
    int numDoors=0;
    MyCar(String ma, String mo, int va, int nD){
        super(ma, mo, va);
        numDoors=nD;
    }
    String ToString(){
        return "\nmake: "+make+"\nmodel: "+model+"\nvalue: "+value+
        "\nnumber of doors: "+numDoors;
    }
}
class MyTruck extends MyVehicle{
    boolean fourWheelDrive=false;
    int cargoTons=0;
    MyTruck(String ma, String mo, int va,int cargo, boolean fwd){
        super(ma, mo, va);
        int cargoTons=cargo;
        fourWheelDrive=fwd;
    }
    public int cargoTons(int cargo){
        return cargo;
    }
    String ToString(){
        return "\nmake: "+make+"\nmodel: "+model+"\nvalue: "+value+
        "\nAmount of cargo: "+cargoTons+"\nfour wheel drive status: "+fourWheelDrive;
    }
}
class MyCycle extends MyVehicle{
    int CCs=0;
    MyCycle(String ma, String mo, int va,int cc){
        super(ma, mo, va);
        CCs=cc;
    }
    String ToString(){
        return "\nmake: "+make+"\nmodel: "+model+"\nvalue: "+value+
        "\nCCs: "+CCs;
    }
}
public class Driver{
    public static void main(String args[]){
        MyVehicle Vehicles[]=new MyVehicle[5];
        Vehicles[0]=new MyCar("ObamaCar","2012 election edition",1488,4);
        Vehicles[1]=new MyCar("Honda","Civic",5000,4);
        Vehicles[2]=new MyTruck("Ford","Ford cool awesome",1337,4,false);
        Vehicles[3]=new MyTruck("apple car","cool version",549973,8,true);
        Vehicles[4]=new MyCycle("thanos bike","thanos",100,1500);
        for(int i=0;i<Vehicles.length;i++){
            System.out.println("The next vehicle is:");
            System.out.println(Vehicles[i].ToString());
        }
    }
}
