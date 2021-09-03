public class ClosestFibonacciNumber {
  public static void main(String[] args){
    int a=0;
    int b=1;
    int c=1;

    int fib=34;
    int min=fib;

    while(c<fib){
      c=a+b;
      min=Math.min(c,min);
    }

    int up = Math.abs(c-fib);
    int l = Math.abs(fib-min);

    if(up<l){
      System.out.println(c);
    }
    System.out.println(min);
  }
}
