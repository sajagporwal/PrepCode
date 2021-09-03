public class BitLogicSales {
  public static void main(String[] args){

    int lo = 2;
    int hi = 4;
    int k = 8;

    int mx = 0;

    for(int i=lo;i<hi;i++){
      for(int j=lo+1;j<=hi;j++){
        int sum = i^j;
        if(sum<=k)
          mx=Math.max(sum,mx);
        if(mx==k)
          break;
      }
    }

    System.out.println(mx);
  }
}
