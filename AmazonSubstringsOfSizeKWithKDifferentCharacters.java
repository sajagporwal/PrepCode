import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class AmazonSubstringsOfSizeKWithKDifferentCharacters {
  public static void main(String[] args){

    String s = "awaglknagawunagwkwagl";
    int k = 4;

    int i = 0;

    HashSet<Character> hs = new HashSet();

    LinkedHashSet<String> res = new LinkedHashSet();

    int j=0;

    while(j<s.length()){
      char ch = s.charAt(j);

      while(i<j && (hs.contains(ch) || j-i+1>k)){
        hs.remove(s.charAt(i++));
      }

      hs.add(ch);

      if(hs.size()==k && j-i+1==k){
        res.add(s.substring(i,j+1));
      }

      j++;
    }

    for(String st:res)
      System.out.println(st);

  }
}
