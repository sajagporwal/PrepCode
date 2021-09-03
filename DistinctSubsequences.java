public class DistinctSubsequences {
  public static void main(String[] args){

    String a = "cbabacbacab";
    String b = "abb";

    int lLen = a.length();
    int sLen = b.length();

    int[][] dp = new int[lLen+1][sLen+1];

    for(int j=0;j<=lLen;j++)
      dp[j][0]=1;

    for(int i=0;i<dp.length;i++){
      for(int j=0;j<dp[0].length;j++){
        System.out.print(dp[i][j]);
      }
      System.out.println();
    }


  }
}
