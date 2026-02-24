import java.util.*;
interface Soldier{
    public void Attack();
}
interface Mage{
    public void CasteSpell();
}
interface Vehicle{
    public void Drive();
}
class DesertSoldier implements Soldier{
    public void Attack(){
        System.out.println("Attacked by desert soldier");
    }
}
class DesertMage implements Mage{
    public void CasteSpell(){
        System.out.print("DesertSpell");
    }
}
class DesertVehicle implements Vehicle{
    public void Drive(){
        System.out.println("You are driving in Desert");
    }
}
class SnowSoldier implements Soldier{
    public void Attack(){
        System.out.println("Attacked by Snow soilder");
    }
}
class SnowMage implements Mage{
    public void CasteSpell(){
        System.out.print("SnowSpell");
    }
}
class SnowVehicle implements Vehicle{
    public void Drive(){
        System.out.println("You are driving in Snow");
    }
}
interface AbstractFact{
    public Soldier CreateSoldier();
    public Mage CreateMage();
    public Vehicle Driving();
}
class DesertFactory implements AbstractFact{
     public Soldier CreateSoldier(){
        return new DesertSoldier();
    }
   public Mage CreateMage(){
        return new DesertMage();
    }
    public Vehicle Driving(){
        return new DesertVehicle();
    }

}
class SnowFactory implements AbstractFact{
     public Soldier CreateSoldier(){
        return new SnowSoldier();
    }
   public Mage CreateMage(){
        return new SnowMage();
    }
    public Vehicle Driving(){
        return new SnowVehicle();
    }

}

class AbstractFactory{
   public static AbstractFact Decide(String s){
        if (s.equalsIgnoreCase("Desert")){
            return new DesertFactory();
        }
        else if(s.equalsIgnoreCase("Snow")){
            return new SnowFactory();
        }
        else{
            throw new IllegalArgumentException("Enter Valid Arguement");
        }
    }
    public static void main(String args[]){
        String req;
        Scanner inp=new Scanner(System.in);
        req=inp.nextLine();
        AbstractFact sam=Decide(req);
        sam.CreateSoldier().Attack();
        sam.CreateMage().CasteSpell();
        sam.Driving().Drive();

    }
}
