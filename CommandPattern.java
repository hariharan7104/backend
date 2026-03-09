import java.util.*;
interface Command{
    public void execute();
}
class Light{
    void turnOn(){
        System.out.println("light is on");
    }
}
class Fan{
    void turnOn(){
        System.out.println("Fan is on");
    }
}
class Ac{
    void turnOn(){
        System.out.println("Ac is on");
    }
}
class LightOn implements Command{
    Light l;
    LightOn(Light l){
        this.l=l;
    }
    public void execute(){
        l.turnOn();
    }
}
class FanOn implements Command{
    Fan f;
    FanOn(Fan f){
        this.f=f;
    }
    public void execute(){
        f.turnOn();
    }
}
class AcOn implements Command{
    Ac a;
    AcOn(Ac a){
        this.a=a;
    }
    public void execute(){
        a.turnOn();
    }
}
class Remote{
    Command command;
    void SetCommand(Command command){
        this.command=command;
    }
    void pressButton(){
        command.execute();
    }
}
class CommandPattern{
    public static void main(String args[]){
        Light l=new Light();
        Fan f=new Fan();
        Ac a=new Ac();
        Command LightCommand=new LightOn(l);
        Command FanCommand=new FanOn(f);
        Command AcCommand=new AcOn(a);
        Remote r=new Remote();
        r.SetCommand(FanCommand);
        r.pressButton();
    }
}