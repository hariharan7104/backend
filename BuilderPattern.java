import java.util.*;
class Order{
    private String id, name, phone, email, 
             address, giftWrap, 
             coupon, instructions;
    Order(Builder b){
        this.id=b.id;
        this.name=b.name;
        this.address=b.address;
        this.giftWrap=b.giftWrap;
        this.coupon=b.coupon;
        this.instructions=b.instructions;
        this.email=b.email;
        this.phone=b.phone;
    }
    void print(){
        System.out.println("THe Customer is "+ this.name);
    }
   
    public static class Builder{
        private String id, name, phone, email, 
             address, giftWrap, 
             coupon, instructions;
        public Builder SetInfo(String Name,String Id){
            this.name=Name;
            this.id=Id;
            return this;
        }
        public Builder SetContact(String phone,String email){
            this.phone=phone;
            this.email=email;
            return this;
        }
        public Builder giftInfo(String coupon,String giftwrap,String instructions){
            this.giftWrap=giftwrap;
            this.instructions=instructions;
            this.coupon=coupon;
            return this;

        }
        public Order build(){
            return new Order(this);
        }
    }

}
class BuilderPattern{
    public static void main(String args[]){
        Order s=new Order.Builder().SetInfo("sam","123").build();
        s.print();
    }
}
