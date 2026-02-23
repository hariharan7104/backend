import java.util.*;
interface notification{
   public void message();
}
class Sms implements notification{
   public void message(){
        System.out.print("sms");
    }
}
class Email implements notification{
    public void message(){
        System.out.print("email");
    }
}
class Push implements notification{
    public void message(){
        System.out.print("push");
    }
}
class Sfactory{
    public static notification sample(String type){
        if(type.equalsIgnoreCase("sms")){
            return new Sms();
        }
        else if(type.equalsIgnoreCase("email")){
            return new Email();
        }
        else if(type.equalsIgnoreCase("push")){
            return new Push();
        }
        else{
            throw new IllegalArgumentException("Invalid service");
        }
    }
}
class factory{
    public static void main(String args[]){
        Scanner inp=new Scanner(System.in);
        String type=inp.nextLine();
        notification n=Sfactory.sample(type);
        n.message();
    }
}