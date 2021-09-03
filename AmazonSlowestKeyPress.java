import java.util.ArrayList;
import java.util.List;

public class AmazonSlowestKeyPress {
  public static void main(String[] args){
    List<List<Integer>> al = new ArrayList<List<Integer>>();
//    al.add(new ArrayList());
//    al.get(0).add(0);
//    al.get(0).add(2);
//    al.add(new ArrayList());
//    al.get(1).add(1);
//    al.get(1).add(3);
//    al.add(new ArrayList());
//    al.get(2).add(0);
//    al.get(2).add(7);

    al.add(new ArrayList());
    al.get(0).add(0);
    al.get(0).add(2);
    al.add(new ArrayList());
    al.get(1).add(1);
    al.get(1).add(5);
    al.add(new ArrayList());
    al.get(2).add(0);
    al.get(2).add(9);
    al.add(new ArrayList());
    al.get(3).add(2);
    al.get(3).add(15);


    int prev=0;
    int mx=0;
    int val=0;

    for(int i=0;i<al.size();i++){
      List<Integer> cur = al.get(i);
      int curDiff = cur.get(1)-prev;
      prev = cur.get(1);
      if(curDiff>mx){
            mx=curDiff;
            val=cur.get(0);
      }
    }

    System.out.println((char)(val+97));
  }
}
