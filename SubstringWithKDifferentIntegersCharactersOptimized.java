import java.util.HashMap;

public class SubstringWithKDifferentIntegersCharactersOptimized {

  public static int atMostK(int[] arr, int k){
    int i = 0;
    int count = 0;
    HashMap<Integer,Integer> hm = new HashMap();
    for(int j=0;j<arr.length;j++){
      if(hm.getOrDefault(arr[j],0)==0){
        k--;
      }
      hm.put(arr[j],hm.getOrDefault(arr[j],0)+1);
      while(k<0){
        hm.put(arr[i],hm.get(arr[i])-1);
        if(hm.get(arr[i])==0){
          k++;
          hm.remove(arr[i]);
        }
        i++;
      }
      count+=j-i+1;
    }

    return count;
  }

  public static void main(String[] args){
    int[] arr = new int[]{1,2,1,2,3};
    int k = 2;
    System.out.println(atMostK(arr,k)-atMostK(arr,k-1));
  }
}
