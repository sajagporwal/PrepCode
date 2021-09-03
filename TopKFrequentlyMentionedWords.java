import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentlyMentionedWords {

  public static boolean check(char ch){
    return (ch>='a' && ch<='z') || (ch>='A' && ch<='Z');
  }

  public static void main(String[] args){

    int k = 2;

    String[] keywords = new String[]{"anacell", "betacellular", "cetracular",
            "deltacellular", "eurocell"};

    String[] reviews = new String[]{
            "I love anacell Best services; Best services provided by anacell",
            "betacellular has great services",
            "deltacellular provides much better services than betacellular",
            "cetracular is worse than anacell",
            "Betacellular is better than deltacellular."
    };

    HashSet<String> hashedKeywords = new HashSet<>();
    for(String s: keywords){
      hashedKeywords.add(s);
    }

    HashMap<String,Integer> hm = new HashMap<>();

    for(String cur: reviews){
      HashSet<String> current = new HashSet();

      for(int i=0;i<cur.length();i++){
        char ch = cur.charAt(i);
        if(check(ch)){
          StringBuilder sb = new StringBuilder();
          while(i<cur.length() && check(cur.charAt(i))){
            sb.append(Character.toLowerCase(cur.charAt(i)));
            i++;
          }
          if(hashedKeywords.contains(sb.toString())) {
            if (!current.contains(sb.toString())) {
              hm.put(sb.toString(), hm.getOrDefault(sb.toString(), 0) + 1);
              current.add(sb.toString());
            }
          }
        }
      }

    }

    PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<Map.Entry<String,Integer>>((p,q)-> {
      int pv = p.getValue();
      int qv = q.getValue();

      if(pv>qv){
        return -1;
      }
      else if(pv<qv){
        return 1;
      }
      else{
        return p.getKey().compareTo(q.getKey());
      }
    });

    pq.addAll(hm.entrySet());

    System.out.println(pq.remove().getKey());
    System.out.println(pq.remove().getKey());
  }
}
