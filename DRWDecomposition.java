import java.util.ArrayList;
import java.util.List;

public class DRWDecomposition {

  public static void main(String[] args){
    int m=11;

    int[] arr = new int[m+1];

    int sum = 0;
    int count = 0;

    for (int i = 1; (sum + i) < m; i+= 2) {
      arr[count++] = i;
      sum += i;
    }

    int start = 0;
    int r = m - sum;
    if (r % 2 == 0) {
      arr[count - 1] += r;
    } else if (r > arr[count - 1]) {
      arr[count++] = r;
    } else {
      start = 1;
      arr[count - 1] += r + 1;
    }

    System.out.println(arr);


  }
}
