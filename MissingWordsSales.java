import java.util.ArrayList;
import java.util.List;

public class MissingWordsSales {
  public static void main(String[] args){

    String s = "I am using HackerRank to improve programming";
    String t = "am HackerRank to improve";

    List<String> res = new ArrayList<String>();

    String[] first = s.split(" ");
    String[] second = t.split(" ");

    int i=0,j=0;

    while(i<first.length && j<second.length){
      if(!first[i].equals(second[j])){
        res.add(first[i]);
        i++;
      } else{
        i++;
        j++;
      }
    }

    while(i<first.length)
      res.add(first[i++]);

    for(String p:res)
      System.out.println(p);
  }
}
