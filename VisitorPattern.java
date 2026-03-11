import java.util.*;
interface Visitor{
    public void visit(Adult a);
    public void visit(Kid k);
    public void visit(Old o);
}
interface Patient{
    public void action(Visitor v);
}
class Adult implements Patient{
    public void action(Visitor v){
        v.visit(this);
    }
}
class Kid implements Patient{
    public void action(Visitor v){
        v.visit(this);
    }
}
class Old implements Patient{
    public void action(Visitor v){
        v.visit(this);
    }
}
class DiagonsisVisitor implements Visitor{
    public void visit(Adult a){
        System.out.println("Diagnosis for visitor");
    }
    public void visit(Kid k){
        System.out.println("Diagnosis for kid");
    }
    public void visit(Old o){
        System.out.println("Diagnosis for Old");
    }
}
class BillingVisitor implements Visitor{
    public void visit(Adult a){
        System.out.println("biling for adult");
    }
    public void visit(Kid k){
        System.out.println("Billing for kid");
    }
    public void visit(Old o){
        System.out.println("Billing for Old");
    }
}
class VisitorPattern{
public static void main(String args[]){
    Patient p1=new Adult();
    Patient p2=new Kid();
    ArrayList<Patient>p=new ArrayList<>();
    p.add(p1);
    p.add(p2);
    for(Patient iter:p){
        iter.action(new BillingVisitor ());
        iter.action(new DiagonsisVisitor ());
    }
}
}