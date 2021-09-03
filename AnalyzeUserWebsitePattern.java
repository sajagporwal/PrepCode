import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnalyzeUserWebsitePattern {

  static class Pair{
    int timestamp;
    String website;
    Pair(int timestamp, String website){
      this.timestamp = timestamp;
      this.website = website;
    }
  }

  public static void main(String[] args){

    String[] username = new String[]{"joe","joe","joe","james","james","james","james","mary",
            "mary","mary"};
    int[] timestamp = new int[]{1,2,3,4,5,6,7,8,9,10};
    String[] website = new String[]{"home","about","career","home","cart","maps","home","home",
            "about","career"};

    Map<String, List<Pair>> map = new HashMap();
    int n = username.length;

    for(int i=0;i<username.length;i++){
      map.putIfAbsent(username[i],new ArrayList());
      map.get(username[i]).add(new Pair(timestamp[i],website[i]));
    }

    String res=null;

    Map<String,Integer> count = new HashMap();

    for(String key:map.keySet()){

      Set<String> hs = new HashSet();
      List<Pair> values = map.get(key);

      Collections.sort(values,(a,b)->(a.timestamp-b.timestamp));

      for(int i=0;i<values.size();i++){
        for(int j=i+1;j<values.size();j++){
          for(int k=j+1;k<values.size();k++){

            String current = values.get(i).website+" "+values.get(j).website+" "+values.get(k).website;

            if(!hs.contains(current)){
              hs.add(current);
              count.put(current,count.getOrDefault(current,0)+1);
            }
            if((res==null) || (count.get(res)<count.get(current)) || ( count.get(res)==count.get(current) && res.compareTo(current)>0)){
              res = current;
            }
          }
        }
      }
    }

    System.out.println(res);

  }
}
