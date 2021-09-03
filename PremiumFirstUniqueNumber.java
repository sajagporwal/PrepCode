import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PremiumFirstUniqueNumber {

  static int[] nums = new int[]{2,3,5};

  static Queue<Integer> queue = new LinkedList();
  static Map<Integer, Boolean> isUnique = new HashMap();

  public static void main(String[] args) {

    for (int i : nums)
      add(i);


  }

  public static int showFirstUnique() {
    while(!queue.isEmpty() && !isUnique.get(queue.peek()))
      queue.remove();
    if(!queue.isEmpty())
      return queue.peek();
    return -1;
  }

  public static void add(int value) {
    if(!isUnique.containsKey(value)){
      queue.add(value);
      isUnique.put(value,true);
    } else{
      isUnique.put(value,false);
    }
  }
}
