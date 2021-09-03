import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PairItemsS {

  public static class PairString {
    String first;
    String second;

    public PairString(String first, String second) {
      this.first = first;
      this.second = second;
    }
  }

  public static List<String> largestItemAssociation(List<PairString> itemAssociation) {
    Map<String, List<String>> assocmap = new HashMap<>();
    //Map with all items and child association of every item 1->2, 2-> , 3->4, 4->5 ,5->
    for (PairString p : itemAssociation) {
      if (!assocmap.containsKey(p.first)) {
        assocmap.put(p.first, new ArrayList<>());
      }
      assocmap.get(p.first).add(p.second);
      if (!assocmap.containsKey(p.second)) {
        assocmap.put(p.second, new ArrayList<>());
      }
    }
    //DFS for every item: Resultant map 1->{5},{2} 2->{1,2},{4,5} 3->{3,4,5}
    Map<Integer, List<List<String>>> sizemap = new HashMap<>();
    int maxassoc = Integer.MIN_VALUE;
    for (String key : assocmap.keySet()) {
      Queue<String> q = new LinkedList<>();
      TreeSet<String> temp = new TreeSet<>();
      q.offer(key);
      while (!q.isEmpty()) {
        String head = q.poll();
        temp.add(head);
        List<String> tail = assocmap.get(head);
        for (String t : tail) {
          q.offer(t);
        }
      }
      int size = temp.size();
      maxassoc = Math.max(maxassoc, size);
      if (!sizemap.containsKey(size)) {
        sizemap.put(size, new ArrayList<>());
      }
      sizemap.get(size).add(new ArrayList<>(temp));
    }

    // Retrieve the maximum size lists and sort them lexiographically
    List<List<String>> maxassoclist = sizemap.get(maxassoc);

    Collections.sort(maxassoclist, new Comparator<List<String>>() {
      @Override
      public int compare(List<String> o1, List<String> o2) {
        int result = 0;
        for (int i = 0; i < o1.size() && result == 0; i++) {
          result = o1.get(i).compareTo(o2.get(i));
        }
        return result;
      }
    });

    return maxassoclist.get(0);
  }

  public static void main(String[] args) {

    List<PairString> itemAssociation = new ArrayList();
    itemAssociation.add(new PairString("item3","item4"));
    itemAssociation.add(new PairString("item4","item5"));
    itemAssociation.add(new PairString("item0","item1"));
    itemAssociation.add(new PairString("item1","item2"));

    List<String> res = largestItemAssociation(itemAssociation);
    for(String s:res)
      System.out.println(s);
  }
}
