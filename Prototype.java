import java.util.*;
class Character{
    private String name,color,height;
    Character(String color,String height){
        this.color=color;
        this.height=height;
    }
    public void setName(String name){
        this.name=name;
    }
    Character(Character c){
        this.color=c.color;
        this.height=c.height;
    }
    public void print(){
        System.out.print("the color of character is:"+this.color);
    }
    public Character clone(){
        return new Character(this);
    }
}
class Prototype{
    public static void main(String args[]){
    Character c1=new Character("blue","158");
    c1.setName("sam");
    Character c2=c1.clone();
    c2.setName("Hari");
    c1.print();
    c2.print();
    }
}