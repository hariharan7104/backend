import java.util.*;
interface Coffee{
    public void Wrapper();
    public int Cost();
}
class PlainCoffee implements Coffee{
    public void Wrapper(){
        System.out.println("Plain Coffee");
    }
    public int Cost(){
        return 2;
    }
}
class SugarandCoffee implements Coffee{
     Coffee coffee;
    SugarandCoffee(Coffee coffee){
        this.coffee=coffee;
    }
    public void Wrapper(){
    coffee.Wrapper();
    System.out.println("Added Sugar");
}
    public int Cost(){
        return coffee.Cost()+1;
    }

}
class Decorator{
    public static void main(String args[]){
        Coffee s=new SugarandCoffee(new PlainCoffee());
        s.Wrapper();
        s.Cost();
    }
}