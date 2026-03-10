import java.util.*;
interface Auctioner{
    public void addUser(Bidders b);
    public void placeBid(Bidders b,int amount);
}
class Bidders{
    String name;
    Auctioner mediator;
    Bidders(String name,Auctioner mediator){
        this.name=name;
        this.mediator=mediator;
    }
    void placeBid(int amount){
        mediator.placeBid(this,amount);
    }
    void recieveBid(Bidders b,int amount){
        System.out.printf("The bid is placed by %s an amount of %d",b.name,amount);
    }
}
class Auction implements Auctioner {
    List<Bidders>u=new ArrayList<>();
    public void addUser(Bidders b){
        u.add(b);
    }
    public void placeBid(Bidders b,int amount){
        System.out.printf("The bid is of %d by %s",amount,b.name);
        System.out.println();

        for(Bidders s:u){
            if(s!=b)
                s.recieveBid(b,amount);
        }
    }
}
class Mediator{
    public static void main(String args[]){
        Auction a1=new Auction();
        Bidders b1=new Bidders("Hari",a1);
        Bidders b2=new Bidders("Sam",a1);
        a1.addUser(b1);
        a1.addUser(b2);
        b1.placeBid(200);

    }
}