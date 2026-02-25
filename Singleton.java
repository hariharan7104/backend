import java.util.*;
class Logger{
    private static  volatile Logger instance;
    private Logger(){};
    public static Logger connect(){
        if(instance==null){
            synchronized(Logger.class){
                if(instance==null){
                    instance=new Logger();
                }
            }
        }
        System.out.println("Connected");
        return instance;
    }
}
class Singleton{
    public static void main(String args[]){
        Logger log=Logger.connect();

    }
}