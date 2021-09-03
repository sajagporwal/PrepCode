import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmazonPrimeRoute {
  public static void main(String[] args){

    List<int[]> a = new ArrayList();
    a.add(new int[]{1,2});
    a.add(new int[]{2,4});
    a.add(new int[]{3,6});

    List<int[]> b = new ArrayList();
    b.add(new int[]{1,2});

    int target = 7;

    Collections.sort(a, (i, j) -> i[1] - j[1]);
    Collections.sort(b, (i,j) -> i[1] - j[1]);
    List<int[]> result = new ArrayList<>();
    int max = Integer.MIN_VALUE;
    int m = a.size();
    int n = b.size();
    int i =0;
    int j =n-1;
    while(i<m && j >= 0) {
      int sum = a.get(i)[1] + b.get(j)[1];
      if(sum > target) {
        --j;
      } else {
        if(max <= sum) {
          if(max < sum) {
            max = sum;
            result.clear();
          }
          result.add(new int[]{a.get(i)[0], b.get(j)[0]});
          int index = j-1;
          while(index >=0 && b.get(index)[1] == b.get(index+1)[1]) {
            result.add(new int[]{a.get(i)[0], b.get(index--)[0]});
          }
        }
        ++i;
      }
    }

    for(int[] p:result)
      System.out.println(p[0]+" "+p[1]);
  }
}
