import java.util.*;
interface App{
    public void play(String type,String video);
}
class VideoService implements App{
    public void play(String type,String video){
        System.out.println("Streaming the application");
    }
}
class ProxyService implements App{
    VideoService v;
    ProxyService(VideoService v){
        this.v=v;
    }
    Map<String,String>cache=new HashMap<>();
    Map<String,Integer>rate=new HashMap<>();
    public void play(String type,String video){
        if(video.contains("premium")&&!type.equals("premium")){
            System.out.println("Require premium sub");
            return;        
        }
        rate.put(video,rate.getOrDefault(video,0)+1);
        if(rate.get(video)>10){
            System.out.println("Access Denied");
            return;
        }
        if(cache.containsKey(video)){
            System.out.println("Streaming Cache video"+video);
        }
        else{
            v.play(type,video);
            cache.put(video,"cached");
        }
    }

}
class Proxypattern{
    public static void main(String args[]){
        VideoService vid=new VideoService();
        ProxyService proxy=new ProxyService(vid);
        proxy.play("free","premium movie");
    }
}