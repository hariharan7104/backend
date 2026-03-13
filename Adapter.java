import java.util.*;
interface SmartDevice{
    public void turnOn();
    public void turnOff();
}
class AirConditioner{
    void connectBluetooth(){
        System.out.println("Connected to Bluetooth");
    }
    void TurnOnAc(){
        System.out.println("Temperature reduced");
    }
    void disconnect(){
        System.out.println("Bluetooth Disconnected");
    }
    void ShutdownAc(){
        System.out.println("Ac Turned Off");
    }
}
class CoffeMachine{
    void TurnOnMachine(){
        System.out.println("Machine turned On");
    }
    void connectZigbee(){
        System.out.println("Connected To Zigbee");
    }
    void DisconnectZigbee(){
        System.out.println("Disconnected Zigbee and turned it off");
    }
    void TurnOfMachine(){
        System.out.println("Coffe Machine Turned Off");
    }
}
class AirConditionerAdapter implements SmartDevice{
    AirConditioner a;
    AirConditionerAdapter(AirConditioner a){
        this.a=a;
    }
    public void turnOn(){
        a.connectBluetooth();
        a.TurnOnAc();
    }
    public void turnOff(){
        a.disconnect();
        a.ShutdownAc();
    }
}
class CoffeeAdapter implements SmartDevice{
    CoffeMachine c;
    CoffeeAdapter(CoffeMachine c){
        this.c=c;
    }
    public void turnOn(){
        c.TurnOfMachine();
        c.connectZigbee();
    }
    public void turnOff(){
        c.DisconnectZigbee();
        c.TurnOfMachine();
    }
}
class Adapter{
    public static void main(String args[]){
        CoffeeAdapter sam=new CoffeeAdapter(new CoffeMachine());
        sam.turnOn();
    }
}