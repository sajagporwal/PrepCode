import java.util.HashMap;
import java.util.Map;

public class SubstringWithKDifferentIntegersCharactersBrute {

  public static void main(String[] args){
    Map<Integer,Integer> hm = new HashMap();
    int[] arr = new int[]{1,2,1,2,3};

    int first = 0;
    int second = 0;
    int count = 0;
    int K = 2;

    while(second<arr.length){

      hm.put(arr[second],hm.getOrDefault(arr[second],0)+1);

      if(hm.size()>K){
        first++;
        second = first;
        hm.clear();
        continue;
      }

      if(hm.size()==K){
        count++;
        second++;
        if(second==arr.length){
          first++;
          second=first;
          hm.clear();
        }
        continue;
      }
      second++;
    }

    System.out.println(count);
  }
}
