import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PremiumAnalyzeUserWebsiteVisitPattern {

  static class Visit{
    String username;
    int timestamp;
    String website;
    Visit(String username, int timestamp, String website){
      this.username = username;
      this.timestamp = timestamp;
      this.website = website;
    }
  }

  public static void main(String[] args){

    String[] username = new String[]{"joe","joe","joe","james","james","james","james","mary","mary","mary"};
    int[] timestamp = new int[]{1,2,3,4,5,6,7,8,9,10};
    String[] website = new String[]{"home","about","career","home","cart","maps","home","home","about","career"};

    List<Visit> al = new ArrayList();

    for(int i=0;i<username.length;i++)
      al.add(new Visit(username[i],timestamp[i],website[i]));

    Collections.sort(al,(a,b)->(a.timestamp-b.timestamp));

    Map<String,List<String>> hm = new HashMap();

    for(Visit cur:al){
      if(!hm.containsKey(cur.username)){
        hm.put(cur.username,new ArrayList());
      }
      hm.get(cur.username).add(cur.website);
    }

    Map<List<String>,Integer> sequenceMap = new HashMap();

    int mx=0;
    List<String> finResult = new ArrayList();

    for(List<String> currentList:hm.values()){

      if(currentList.size()<3)
        continue;

      Set<List<String>> hs = generateSequence(currentList);

      for(List<String> list:hs) {
        sequenceMap.put(list,sequenceMap.getOrDefault(list,0)+1);
        if(sequenceMap.get(list)>mx){
          finResult = list;
          mx = sequenceMap.get(list);
        }
      }
    }

    for(String l:finResult)
      System.out.println(l);
  }

  private static Set<List<String>> generateSequence(List<String> currentList) {
    Set<List<String>> result = new HashSet();

    for(int i=0;i<currentList.size()-2;i++){
      for(int j=i+1;j<currentList.size()-1;j++){
        for(int k=j+1;k<currentList.size();k++){
          List<String> fin = new ArrayList();
          fin.add(currentList.get(i));
          fin.add(currentList.get(j));
          fin.add(currentList.get(k));
          result.add(fin);
        }
      }
    }

    return result;
  }
}
