public class AmazonNewBabyQuestionOppositeSelectionProfit {

  public static void main(String[] args){

    int k = 2;
    int[] profit = new int[]{1,5,1,3,7,-3};

    // first k length segment sum
    long sm1=0;

    // first k length segment start index
    int i1=0;
    //first k length segment end index
    int j1=k-1;

    // add all the segments of k length
    for(int i=i1;i<=j1;i++)
      sm1+=profit[i];

    // half length of product list
    int half = profit.length/2;

    // distance between the two k segments
    int remainingPart = half-k;

    // second k length segment start index
    int i2 = j1+remainingPart+1;
    // second k length segment end index
    int j2 = i2+k-1;

    // second k length segment sum
    long sm2=0;

    // add all the segments of k length
    for(int i=i2;i<=j2;i++){
      sm2+=profit[i];
    }

    // add the two k segment length profits
    long mx=sm1+sm2;

    // if k segments are adjacent
    if(i2==j1+1) {
      // then return the max profit till now
      System.out.println(mx);
      return;
    }

    // profit array length
    int n = profit.length;

    // using the sliding window approach we will find profits by different k segments
    while(i2!=0){
      // remove the first index profit of first segment
      sm1-=profit[i1];
      i1++;
      i1%=n;

      j1++;
      j1%=n;
      // add the last index profit of new incremented index
      sm1+=profit[j1];

      // repeat the same procedure for other k segment

      // remove the first index profit of second segment
      sm2-=profit[i2];
      i2++;
      i2%=n;

      j2++;
      j2%=n;
      // add the last index profit of new incremented index
      sm2+=profit[j2];

      // check for max value
      mx=Math.max(mx,sm1+sm2);
    }

    // return the maximum profit achievable
    System.out.println(mx);

  }
}
