import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlidingWindowK {
  public static void main(String[] args){
    String s = "awaglk";
    int k=4;
    if(s==null || s.length()==0)
    {
//      return new ArrayList();
    }
    List<String> res = new ArrayList();
    int i=0,j=0;
    Map<Character,Integer> hm = new HashMap();
    while(j<s.length()){
      char ch=s.charAt(j);
      hm.put(ch,hm.getOrDefault(ch,0)+1);
      while(hm.size()>(k-1)){
        ch=s.charAt(i);
        hm.put(ch,hm.get(ch)-1);
        if(hm.get(ch)==0)
          hm.remove(ch);
        i++;
      }
      if( j-i+1==k && hm.size()==(k-1))
        res.add(s.substring(i,j+1));
      j++;
    }
    System.out.println(res.get(0));
  }
}
