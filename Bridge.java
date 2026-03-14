interface render{
    public void renderCircle(int r);
    public void renderRectangle(int l,int b);
}

class rasterRender implements render{
    public void renderCircle(int r){
        System.out.println("Raster rendering of circle");
    }

    public void renderRectangle(int l,int b){
        System.out.println("Raster rendering of Rectangle");
    }
}

class vectorRender implements render{
    public void renderCircle(int r){
        System.out.println("Vector rendering of circle");
    }

    public void renderRectangle(int l,int b){
        System.out.println("Vector rendering of Rectangle");
    }
}
abstract class Shape{
    render r;
    Shape(render r){
        this.r=r;
    }
    abstract public void draw();
}
class Circle extends Shape{
     int rad;
    Circle(render r,int rad){
        super(r);
        this.rad=rad;
    }
    public void draw(){
        r.renderCircle(rad);
    }
}
class Rectangle extends Shape{
    int length,breadth;
    Rectangle(render r,int length,int breadth){
        super(r);
        this.length=length;
        this.breadth=breadth;
    }
    public void draw(){
        r.renderRectangle(length,breadth);
    }
}
class Bridge{
    public static void main(String args[]){
        render r=new rasterRender();
        render v=new vectorRender();
        Shape c=new Circle(r,5);
        c.draw();
        Shape rect=new Rectangle(v,2,3);
        rect.draw();
    }
}
