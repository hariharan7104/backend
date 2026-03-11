import java.util.*;
abstract class Approver{
    protected Approver approver;
    void setApprover(Approver approver){
        this.approver=approver;
    }
    abstract void processRequest(int days);
}
class Supervisor extends Approver{
    void processRequest(int days){
        if(days<4){
            System.out.println("Leave Granted by Supervisor");
        }
        else if(approver!=null){
            approver.processRequest(days);
        }

    }
}
class Manager extends Approver{
    void processRequest(int days){
        if(days<7){
            System.out.println("Leave Granted by Manager");
        }
        else if(approver!=null){
            approver.processRequest(days);
        }
    }
}
class Director extends Approver{
    void processRequest(int days){
        if(days<10){
            System.out.println("Leave Granted by Director");
        }
        // else if(approver!=null){
        //     approver.processRequest(days);
        // }
        else{
            System.out.println("Leave Denied");
        }
    }
}
class ChainOfResponsiblity{
    public static void main(String args[]){
        Approver manager=new Manager();
        Approver supervisor=new Supervisor();
        Approver director=new Director();
        manager.setApprover(director);
        supervisor.setApprover(manager);
        supervisor.processRequest(10);
    }
}