import java.util.ArrayList;
import java.util.List;

public class KnapSack {
  public static void main(String[] args){
    int val[] = new int[] { 4,8,5,9 };
    List<Integer> weights = new ArrayList();
    weights.add(4);
    weights.add(8);
    weights.add(5);
    weights.add(9);
    List<Integer> value = new ArrayList();
    for(int i:weights)
      value.add(i);

    int maxCapacity = 20;
    int n = weights.size();

    int i, w;
    int K[][] = new int[n + 1][maxCapacity + 1];

    for (i = 0; i<= n; i++) {
      for (w = 0; w<= maxCapacity; w++) {
        if (i == 0 || w == 0)
          K[i][w] = 0;
        else if (weights.get(i - 1)<= w)
          K[i][w] = Math.max(value.get(i - 1) + K[i - 1][w - weights.get(i - 1)], K[i - 1][w]);
        else
          K[i][w] = K[i - 1][w];
      }
    }

    System.out.println(K[n][maxCapacity]);

  }
}
