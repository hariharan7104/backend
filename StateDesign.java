import java.util.*;
interface State{
    public void edit(Document d);
    public void review(Document d);
    public void publish(Document d);
}
class DraftState implements State{
    public void edit(Document d){
        System.out.println("Submitted the draft");
    }
    public void review(Document d){
        System.out.println("Submitted for review");
        d.changeState(new ReviewState());

    } 
    public void publish(Document d){
        System.out.println("Cannot be published without reviewing");
    }

}
class ReviewState implements State{
    public void edit(Document d){
        System.out.println("Cannot be edited after submitting");
    }
    public void review(Document d){
        System.out.println("Already Submitted for review");
    }
    public void publish(Document d){
        System.out.println("published");
        d.changeState(new PublishState());
    }

}
class PublishState implements State{
    public void edit(Document d){
        System.out.println("Cannot be edited once published");
    }
    public void review(Document d){
        System.out.println("Already viewed ");
    }
    public void publish(Document d){
        System.out.println("Published already");
    }
}
class Document{
    State s=new DraftState();
    Document(){
        State state=new DraftState();
    }
    void changeState(State s){
        this.s=s;
    }
    void edit(){
        s.edit(this);
    }
    void review(){
        s.review(this);
    }
    void publish(){
        s.publish(this);
    }
}
class StateDesign{
    public static void main(String args[]){
        Document d=new Document();
        d.edit();
        d.review();
        d.publish();
        d.edit();
    }
}