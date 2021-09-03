import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class AmazonDiskSpace {
  public static void main(String[] args){

    int[] hdd = new int[]{62, 64, 77, 75, 71, 60, 79, 75};

    int k = 4;

    List<Integer> res = findMax(hdd, k);

    for(int i:res)
      System.out.println(i);

  }

  public static List<Integer> findMax(int[] hdd, int k){

    int n = hdd.length;

    if (n * k == 0)
      return new ArrayList();

    if (k > n)
      return new ArrayList();

    Deque deq = new LinkedList();

    List<Integer> res = new ArrayList();

    int i = 0;

    int mx=0;

    while(i < n) {
      if (!deq.isEmpty() && (int)deq.getFirst() == i - k){
        deq.removeLast();
      }
      while(!deq.isEmpty() && hdd[(int)deq.getLast()] > hdd[i]) {
        deq.pop();
      }
      deq.offer(i);

      if(i >= k - 1) {
        mx=Math.max(mx,hdd[(int)deq.getFirst()]);
        res.add(hdd[(int)deq.getFirst()]);
      }
      i += 1;
    }

    System.out.println("max: "+mx);

    return res;
  }
}
