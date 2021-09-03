import java.util.PriorityQueue;

public class PremiumMinimumCostToConnectSticks {
  public static void main(String[] args){

    int[] sticks = new int[]{1,8,3,5};

    PriorityQueue<Integer> pq = new PriorityQueue();

    for(int i:sticks)
      pq.add(i);

    int sm = 0;

    while(pq.size()>1){
      int stick1 = pq.poll();
      int stick2 = pq.poll();

      sm+=(stick1+stick2);
      pq.add(stick1+stick2);
    }

    System.out.println(sm);
  }
}
