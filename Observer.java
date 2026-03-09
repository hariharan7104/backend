import java.util.*;
interface Subscribe{
    public void update(String message);
}
class YoutubeSubscriber implements Subscribe{
    String name;
    YoutubeSubscriber(String name){
        this.name=name;
    }
    public void update(String message){
        System.out.println(message);
    }
}
class EmailSubscriber implements Subscribe{
    String name;
    EmailSubscriber(String name){
        this.name=name;
    }
    public void update(String message){
        System.out.println(message);
    }
}
class channel{
    String video;
    String message;
    List<Subscribe>sub=new ArrayList<>();
    void subscribe(Subscribe s){
        sub.add(s);
    }
    void remove(Subscribe s){
        sub.remove(s);
    }
    void notification( String message){
        this.message=message;
        for(Subscribe t:sub){
            t.update(message);
        }
    }
    void upload(String video){
        this.video=video;
        notification(video);
    }
}
class Observer{
    public static void main(String args[]){
        Subscribe s1=new YoutubeSubscriber("hari");
        Subscribe s2=new EmailSubscriber("elakkiyan");
        channel c=new channel();
        c.subscribe(s1);
        c.subscribe(s2);
        c.upload("chess video");
    }
}