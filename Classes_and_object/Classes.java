package Classes_and_object;

public class Classes {  //class 
    
 public static void main(String args[]){
      
   int a = 5  ;   // data type 
   System.out.println("Value of a: " + a);
   func();   //  use with the static keyword
 

   //object 
      Classes obj  = new  Classes() ; 
      obj.func1(); 
      
    


 }

   public static  void func(){  //Methods 
      System.out.println("hii i am function");
   }

   public void func1(){
     System.out.println("hii i am not a static function");
   }


}


