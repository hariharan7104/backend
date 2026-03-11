import java.util.*;
class TextEditor{
    public String text;
    TextEditor(String text){
        this.text=text;
    }
    void undo(Memento m){
        this.text=m.getText();
    }
    Memento save(){
        return new Memento(text);
    }
}
class Memento{
    private String text;
    Memento(String text){
        this.text=text;
    }
    String getText(){
        return text;
    }
}
class HistoryManager{
    Stack<Memento>s=new Stack<>();
    void push(Memento m){
        s.push(m);
    }
    Memento pop(){
        return s.pop();
    }
}
class Backup{
    public static void main(String args[]){
        String text="Hello World";

        TextEditor t=new TextEditor(text);
        HistoryManager m=new HistoryManager();

        m.push(t.save());

        System.out.println(t.text);

        t.text="Samuel";

        m.push(t.save());

        t.undo(m.pop());

        System.out.println(t.text);
    }
}