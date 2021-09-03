public class AmazonNewBabyQuestionOppositeSelectionProfit {

  public static void main(String[] args){

    int k = 2;
    int[] profit = new int[]{1,5,1,3,7,-3};

    //
    long sm1=0;

    //
    int i1=0;
    //
    int j1=k-1;

    //
    for(int i=i1;i<=j1;i++)
      sm1+=profit[i];

    int half = profit.length/2;

    int remainingPart = half-k;

    int i2 = j1+remainingPart+1;
    int j2 = i2+k-1;

    long sm2=0;

    for(int i=i2;i<=j2;i++){
      sm2+=profit[i];
    }

    long mx=sm1+sm2;

    if(i2==j1+1) {
      System.out.println(mx);
      return;
    }

    int n = profit.length;

    while(i2!=0){
      sm1-=profit[i1];
      i1++;
      i1%=n;

      j1++;
      j1%=n;
      sm1+=profit[j1];

      sm2-=profit[i2];
      i2++;
      i2%=n;

      j2++;
      j2%=n;
      sm2+=profit[j2];
      mx=Math.max(mx,sm1+sm2);
    }

    System.out.println(mx);

  }
}
