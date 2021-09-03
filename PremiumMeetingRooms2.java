import java.util.Arrays;
import java.util.PriorityQueue;

public class PremiumMeetingRooms2 {
  public static void main(String[] args){

    int[][] meetings = new int[][]{{0,30},{5,10},{15,20}};

    Arrays.sort(meetings,(m1,m2)->(m1[0]-m2[0]));

    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b)->(a[1]-b[1]));

    pq.add(meetings[0]);

    for(int i=1;i<meetings.length;i++){

      int[] current = meetings[i];
      int[] earliest = pq.poll();

      if(current[0]>=earliest[1]){
        earliest[1]=current[1];
      } else{
        pq.add(current);
      }

      pq.add(earliest);
    }

    System.out.println(pq.size());
  }
}
