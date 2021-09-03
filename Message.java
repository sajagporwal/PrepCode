import java.util.ArrayList;
import java.util.List;

public class Message {

  public static void main(String[] args){
    String message = "njdksjfn jdfnds kjfdklsjf jsdofjsd f jdslkjfgdslkngdslkjg fljksdjflsfdsjfdslkfjdslkfmdsklmfgn ljsdglkdsfg d lkjgdslkgjdsljgdslkjgdsfjngds lkjsdlkgjdsgkldsjgsdlkg lkjdslkgjdslkgjdslgmnds glkjgdslkjgdslkjfgodsjfds g,mdsgkjdsngdlsknfgldsjfglkdsjfglkdsjglkdsjglkdsgjdsklgjdslk lkgjdslkgfjdslkgjdslkgjdsljfgdslkgjmdslkg kljghjdslkjgdslkjfg";
    List<String> arr = getSplits(message);
    for(String s:arr)
      System.out.println(s);
  }

  public static List<String> getSplits(String message){
    List<String> result = new ArrayList<>();
    if (message.length() < 160) {
      result.add(message);
      return result;
    }

    int maxlen = 154;
    int s = 0, e = s + maxlen;
    while (e < message.length()) {
      if (message.charAt(e) != ' ') {
        while (e >= s && message.charAt(e) != ' ' && message.charAt(e + 1) != ' ') {
          e--;
        }
      }
      result.add(message.substring(s, e+ 1));
      s = e + 1;
      e = s + maxlen;
    }
    result.add(message.substring(s, message.length()));

    for (int i = 0; i < result.size(); i++) {
      result.set(i, result.get(i)+"(" + (i + 1) + "/" + (result.size()) + ")");
    }
    return result;
  }
}
