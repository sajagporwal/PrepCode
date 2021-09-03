import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSuggestions {

  static class Trie {
    Trie[] chars = new Trie[26];
    List<String> suggestions = new ArrayList();
  }

  public static void main(String[] args) {

    String[] products = new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"};
    String searchWord = "mouse";

    Trie root = new Trie();

    Arrays.sort(products);

    for (String product : products) {
      Trie temp = root;
      for (char ch : product.toCharArray()) {
        if (temp.chars[ch - 'a'] == null) {
          temp.chars[ch - 'a'] = new Trie();
        }
        temp = temp.chars[ch - 'a'];
        if (temp.suggestions.size() < 3) {
          temp.suggestions.add(product);
        }
      }
    }

    List<List<String>> ans = new ArrayList<>();

    for (char ch : searchWord.toCharArray()) {
      if(root!=null) {
        root = root.chars[ch - 'a'];
      }
      if(root!=null) {
        ans.add(root.suggestions);
      }
      else{
        ans.add(new ArrayList<>());
      }
    }

    for(int i=0;i<ans.size();i++){
      for(int j=0;j<ans.get(i).size();j++){
        System.out.println(ans.get(i).get(j));
      }
    }

  }
}
