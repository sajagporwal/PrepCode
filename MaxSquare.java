import java.util.Arrays;

public class MaxSquare {
  public static void main(String[] args){
    int a = 10;
    int b = 2;

    int sum = a+b;

    int sqposs = (a+b)/4;

    for(int i=sqposs;i>=1;i--){
      int ct=0;
      ct+=a/i;
      ct+=b/i;
      if(ct>=4){
        System.out.println(i);
        return;
      }
    }
  }
}
