@FunctionalInterface
interface IP{
  void print(String s);
}

public class Practice {
  public static void main(String[] args){
    IP i = new IP(){
      @Override
      public void print(String s){
        System.out.println(s);
      }
    };

    IP p = (s)->{
      System.out.println(s);
    };

    i.print("hello");

    p.print("john");
  }
}
