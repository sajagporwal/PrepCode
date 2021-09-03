public class AmazonCutoffRank {
  public static void main(String[] args){

    int[] scores = new int[]{10,10,10,10,10};
    int cutOffRank = 4;
    int numberOfScores = scores.length;

    if(cutOffRank == 0){
      System.out.println(0);
      return;
    }
    int[] cache = new int[101];
    for (int n : scores){
      cache[n]++;
    }
    int  res = 0;
    for (int i = 100; i > 0; i--){
      if (cutOffRank <= 0) break;
      cutOffRank -= cache[i];
      res += cache[i];
    }

    System.out.println(res);
  }
}
