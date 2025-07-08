package Classes_and_object;

public class Class_with_3_fields {

public static void main(String[] args) {
    Class_with_3_fields obj = new Class_with_3_fields(); 
    obj.Book("Ramayana");
    obj.title("the God of peace ")  ; 
    obj.author("Valmiki ji");
}

     
public  void Book(String args) {
    System.out.println("Book name " + args);
}

public  void title(String args) {
    System.out.println("title name " + args);
}
public  void  author(String args) {
    System.out.println("author name " + args);
}


}
