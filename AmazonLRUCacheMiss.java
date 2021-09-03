import java.util.LinkedHashSet;

public class AmazonLRUCacheMiss {
  public static void main(String[] args){

    int[] nums = new int[]{1,2,1,3,1,2};

    int capacity = 2;

    LinkedHashSet<Integer> hs = new LinkedHashSet();

    int count=0;

    for(int i:nums){

      if(hs.contains(i)){
        hs.remove(i);
      } else{
        if(hs.size()==capacity)
          hs.remove(hs.iterator().next());
        count++;
      }

      hs.add(i);
    }

    System.out.println(count);
  }
}
