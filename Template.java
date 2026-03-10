import java.util.*;
abstract class Order{
    void order(){
        selectItem();
        makePayment();
        DeliverOrder();
        sendConfirmation();
    }
    void selectItem(){
        System.out.println("The item selected");
    }
    void makePayment(){
        System.out.println("Pay via UPI");
    }
    void sendConfirmation(){
        System.out.println("Order Confirmed");
    }
    abstract void DeliverOrder();

}
class DigitalOrder extends Order{
    void DeliverOrder(){
        System.out.println("Online Delivery");
    }
}
class ShopOrder extends Order{
    void DeliverOrder(){
        System.out.println("Collect your order from bill counter");
    }
}
class Template{
    public static void main(String args[]){
        Order one=new DigitalOrder();
        Order two=new ShopOrder();
        one.order();
        two.order();
    }
}