import java.util.*;
class ParticleType{
    String color;
    String sprite;
    ParticleType(String color,String sprite){
        this.color=color;
        this.sprite=sprite;
    }
    void render(int x,int y){
        System.out.println("Rendering " + color + " sprite " + sprite + " at (" + x + "," + y + ")");
    }
}
class ParticleFactory{
    Map<String,ParticleType>sam=new HashMap<>();
    ParticleType getParticle(String color,String sprite){
        String key = color + "_" + sprite;
        return sam.computeIfAbsent(key,k->new ParticleType(color,sprite));
    }
}
class Particle{
    int x;
    int y;
    ParticleType type;
    int  velocity;
    Particle(int x,int y,ParticleType type,int velocity){
        this.x=x;
        this.y=y;
        this.type=type;
        this.velocity=velocity;
    }
    public void update(){
        x+=velocity;
        type.render(x,y);
    }
}
class FlyWeight{
    public static void main(String args[]){
        ParticleFactory fact=new ParticleFactory();
        List<Particle>particles=new ArrayList<>();
        ParticleType p=fact.getParticle("green","witch");
        for(int i=0;i<10;i++){
            int x=(int)(Math.random()*100);
            int y=(int)(Math.random()*100);
            particles.add(new Particle(x,y,p,20));
        }
        for(Particle iter:particles){
            iter.update();
        }
        
    }
}
