import java.util.HashSet;
import java.util.PriorityQueue;

public class DROPK {
  public static void main(String[] args){
    int[] db = new int[]{1,5,3,2};
    int x=2;

    int i=0;
    int j=0;
    int min=Integer.MAX_VALUE;
    int mx=Integer.MIN_VALUE;
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    int x1=x;

    while(j<db.length && x-->0){
      pq.add(db[j]);
      j++;
    }

    mx=pq.peek();
    HashSet<Integer> removed = new HashSet();
    while(j<db.length){
      if(pq.peek()==db[i]){
        pq.poll();
      }else{
        removed.add(db[i]);
      }
      pq.add(db[j]);
      if(removed.contains(db[j])) {
        removed.remove(db[j]);
      }
      i++;
      while(!pq.isEmpty() && removed.contains(pq.peek())) {
        pq.poll();
      }
      mx=Math.max(mx,pq.peek());
      j++;
    }

    System.out.println(mx);
  }
}
