import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountPairs {
  public static void main(String[] args){

    int[] numbers = new int[]{};

    Set<String> hs = new HashSet();

    int count = 0;
    Arrays.sort(numbers); // Sort array elements

    int n = numbers.length;

    int k=4414;

    int l = 0;
    int r = 0;
    while(r < n)
    {
      if(numbers[r] - numbers[l] == k)
      {
        if(!hs.contains(numbers[l]+" "+numbers[r])) {
          count++;
          hs.add(numbers[l]+" "+numbers[r]);
        }
        l++;
        r++;
      }
      else if(numbers[r] - numbers[l] > k)
        l++;
      else
        r++;
    }
    System.out.println(count);
  }
}
