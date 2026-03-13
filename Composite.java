import java.util.*;
interface CompanyComponent{
   public void showDetails();
    public void add(CompanyComponent c);
    public void remove(CompanyComponent c);
}
class Employee implements CompanyComponent{
    String name;
    String Designation;
    Employee(String name,String Designation){
        this.name=name;
        this.Designation=Designation;
    }
    public void showDetails(){
        System.out.println("Name :"+name+"-"+Designation);
    }
    public void add(CompanyComponent c){

    }
    public void remove(CompanyComponent c){

    }
}
class Department implements CompanyComponent{
    private List<CompanyComponent>detail=new ArrayList<>();
    public void showDetails(){
       for(CompanyComponent c:detail){
             c.showDetails();
       }
    }
    public void add(CompanyComponent c){
        detail.add(c);
    }
    public void remove(CompanyComponent c){
        detail.remove(c);
    }
}
class Compostie{
    public static void main(String args[]){
        Employee e=new Employee("Hari","Backend Engineer");
        Department hr=new Department();
        hr.add(e);
        hr.showDetails();
    }
}