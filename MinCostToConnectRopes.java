import java.util.PriorityQueue;

public class MinCostToConnectRopes {

  public static void main(String[] args){
    int[] files1 = {8, 4, 6, 12};
    int[] files2 = {20, 4, 8, 2};
    int[] files3 = {1, 2, 5, 10, 35, 89};
    int[] files4 = {2, 2, 3, 3};
    System.out.println(mergeFiles(files1));
    System.out.println(mergeFiles(files2));
    System.out.println(mergeFiles(files3));
    System.out.println(mergeFiles(files4));
  }

  private static int mergeFiles(int[] files) {

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for(int f:files)
      pq.add(f);

    int ct = 0;

    while(pq.size()>1){
      int t1 = pq.remove();
      int t2 = pq.remove();
      int res = t1+t2;
      ct += res;
      pq.add(res);
    }

    return ct;
  }
}
