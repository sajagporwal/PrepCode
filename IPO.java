import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class IPO {
  public static void main(String[] args){
    List<List<Integer>> bids = new ArrayList<List<Integer>>();

    bids.add(new ArrayList());
    bids.get(0).add(1);
    bids.get(0).add(3);
    bids.get(0).add(1);
    bids.get(0).add(9866);
    bids.add(new ArrayList());
    bids.get(1).add(2);
    bids.get(1).add(1);
    bids.get(1).add(2);
    bids.get(1).add(5258);
    bids.add(new ArrayList());
    bids.get(2).add(3);
    bids.get(2).add(2);
    bids.get(2).add(4);
    bids.get(2).add(5778);
    bids.add(new ArrayList());
    bids.get(3).add(4);
    bids.get(3).add(2);
    bids.get(3).add(4);
    bids.get(3).add(6536);

    int totalShares=2;

    PriorityQueue<List<Integer>> pq = new PriorityQueue<List<Integer>>(
            (a,b) -> ((a.get(2)==b.get(2)) ? (a.get(3)-b.get(3)) : (b.get(2)-a.get(2))));

    for(int i=0;i<bids.size();i++){
      pq.add(bids.get(i));
    }
    while(!pq.isEmpty() && totalShares>0){
      List<Integer> temp = pq.poll();
      totalShares = totalShares - temp.get(2);

    }
    List<Integer> ans = new ArrayList<>();
    while(!pq.isEmpty()){
      List<Integer> temp = pq.poll();
      ans.add(temp.get(0));
    }
    System.out.println(ans);
  }
}
