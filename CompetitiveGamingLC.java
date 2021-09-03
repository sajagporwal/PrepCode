import java.util.Arrays;

public class CompetitiveGamingLC {
  public static void main(String[] args){
    int n = 5;
    int k=4;
    int[] arr = new int[]{20,40,60,80,100};

    Arrays.sort(arr);

    int r = 1;

    int ct=0;

    for(int i=arr.length-1;i>=0;i--){
      r=arr.length-i;
      if(r>k || arr[i]==0)
        break;
      if(r<=k)
        ct++;
      while(i>=1 && arr[i]==arr[i-1]) {
        if (r <= k) {
          ct++;
        }
        i--;
      }
    }

    System.out.println(ct);
  }
}
