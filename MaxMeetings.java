import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxMeetings {

  static class Interval{
    int start;
    int end;
    Interval(int start, int end){
      this.start = start;
      this.end = end;
    }
  }

  public static void main(String[] args){

    int[] s = new int[]{1,3,3,5,7};
    int[] t = new int[]{2,2,1,2,1};

    List<Interval> al = new ArrayList();

    for(int i=0;i<s.length;i++){
      al.add(new Interval(s[i],s[i]+t[i]));
    }

    Collections.sort(al,(o1,o2)->(o1.end-o2.end));

    int prevEnd=0;
    int res=0;

    for(Interval interval:al){
      if(interval.start>=prevEnd){
        System.out.println(interval.start+" "+interval.end);
        res++;
        prevEnd=interval.end;
      }
    }

    System.out.println(res);
  }
}
