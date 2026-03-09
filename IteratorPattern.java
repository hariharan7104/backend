import java.util.*;
class Book{
    String name,author,year;
    Book(String name,String author,String year){
        this.name=name;
        this.year=year;
        this.author=author;
    }

}
class Library{
    List<Book>lib=new ArrayList<>();
    void addBook(Book s){
        lib.add(s);
    }
    void removeBook(Book s){
        lib.remove(s);
    }
    public List<Book> getBook(){
        return lib;
    }
}
interface Iterator{
    public boolean hasNext();
    public String Next();
}
class Names implements Iterator{
    List<Book>lib;
    Names(List<Book>lib){
        this.lib=lib;
    }
    int index=0;
    public boolean hasNext(){
        if(index<lib.size()){
        return true;
      }
      return false;
    }
    public String Next(){
        return  lib.get(index++).name;
    }

}
class Authors implements Iterator{
    List<Book>lib;
    Authors(List<Book>lib){
        this.lib=lib;
    }
    int index=0;
    public boolean hasNext(){
        if(index<lib.size()){
        return true;
      }
      return false;
    }
    public String Next(){
        return  lib.get(index++).author;
    }

}
class Year implements Iterator{
    List<Book>lib;
    Year(List<Book>lib){
        this.lib=lib;
    }
    int index=0;
    public boolean hasNext(){
        if(index<lib.size()){
        return true;
      }
      return false;
    }
    public String Next(){
        return  lib.get(index++).year;
    }
}
class IteratorPattern{
    public static void main(String args[]){
        Book b1=new Book("money","2002","Stephen");
        Book b2=new Book("money2","2003","Stephen");
        Book b3=new Book("Mindset","2005","Rouslette");
        Library l1=new Library();
          l1.addBook(b1);
          l1.addBook(b2);
          l1.addBook(b3);
        Year y =new Year(l1.getBook());
        while(y.hasNext()){
            System.out.println(y.Next());
        }
        Authors a=new Authors(l1.getBook());
        while(a.hasNext()){
            System.out.println(a.Next());
        }
        Names n=new Names(l1.getBook());
        while(n.hasNext()){
            System.out.println(n.Next());
        }
    }
}
