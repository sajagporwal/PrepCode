import java.util.HashMap;
import java.util.Map;

public class DifferentShoppingPattern {
  public static void main(String[] args){

    int[] A = new int[]{2,3};
    int[] B = new int[]{4};
    int[] C = new int[]{2,3};
    int[] D = new int[]{1,2};

    int target = 10;

    Map<Integer, Integer> map = new HashMap<>();

    for(int i=0; i<C.length; i++) {
      for(int j=0; j<D.length; j++) {
        int sum = C[i] + D[j];
        map.put(sum, map.getOrDefault(sum, 0) + 1);
      }
    }

    int res=0;
    for(int i=0; i<A.length; i++) {
      for(int j=0; j<B.length; j++) {
        res += map.getOrDefault(target- (A[i]+B[j]), 0);
      }
    }

    System.out.println(res);
  }
}
