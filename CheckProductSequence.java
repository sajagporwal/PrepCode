import java.util.HashMap;
import java.util.Map;

public class CheckProductSequence {
  public static void main(String[] args){
//    String[] products = new String[]{"biotin","biotrue","amazfit","nulo","canidae","nulo"};
//    String[] sequence = new String[]{"nulo","biotin","canidae"};

    String[] products = new String[]{"biotrue","nulo","amazfit","nulo","biotin","canidae"};
    String[] sequence = new String[]{"nulo","biotin","canidae"};

    Map<String,Integer> originalMap = new HashMap();

    for(int i=0;i<sequence.length;i++)
      originalMap.put(sequence[i],i+1);

    int ct=1;

    int min=Integer.MAX_VALUE;
    int starti=-1;
    int resi=-1;
    int resj=-1;

    for(int i=0;i<products.length;i++){
      String p = products[i];
      if(originalMap.containsKey(p)){
        if(originalMap.get(p)==1){
          ct=1;
          starti=i;
          ct++;
        } else if(originalMap.get(p)==originalMap.size() && ct==originalMap.size()) {

          if(i-starti+1<min) {
            min = i - starti + 1;
            resi = starti;
            resj = i;
          }
          ct = 1;
        } else if(ct==originalMap.get(p)){
          ct++;
        }
      }
    }

    if(resi==-1 && resj==-1)
      System.out.println("-1");

    System.out.println(resi+" "+resj);
  }
}
