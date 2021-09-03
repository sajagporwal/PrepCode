import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinElectricityUsage {
  public static void main(String[] args){

    int N = 10;
    int M = 1;
    int P = 2;

    List<List<Integer>> relationships = new ArrayList<List<Integer>>();

    relationships.add(new ArrayList());
    relationships.get(0).add(1);
    relationships.get(0).add(2);

    relationships.add(new ArrayList());
    relationships.get(1).add(1);
    relationships.get(1).add(3);

    Set<String> contradict = new HashSet();

    int[] res = new int[N];

    for(int i=0;i<res.length;i++)
      res[i] = M;

    Collections.sort(relationships,(a,b)->(a.get(0)-b.get(0)));

    for(List<Integer> al : relationships){
      if(contradict.contains(al.get(0) + " " + al.get(1)) || contradict.contains(al.get(1) + " " + al.get(0))){
        System.out.println(-1);
        return;
      }
      contradict.add(al.get(0) + " " + al.get(1));
      contradict.add(al.get(1) + " " + al.get(0));
      res[al.get(1)-1] = res[al.get(0)-1]+1;
    }

    int sm=0;

    for(int i:res)
      sm+=i;

    System.out.println(sm);

  }
}
