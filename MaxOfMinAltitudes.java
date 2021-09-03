public class MaxOfMinAltitudes {

  public static void main(String[] args){

    int[][] nums = new int[][]{{1, 2, 3},{4, 5, 1}};

    System.out.println(compute(nums));

  }

  public static int compute(int[][] nums){

    int[][] dp = new int[nums.length][nums[0].length];

    dp[0][0]=Integer.MAX_VALUE;

    for(int i=1;i<nums.length;i++){
      dp[i][0]=Math.min(dp[i-1][0],nums[i][0]);
    }

    for(int j=1;j<nums[0].length;j++){
      dp[0][j]=Math.min(dp[0][j-1],nums[0][j]);
    }

    for(int i=1;i<nums.length;i++){
      for(int j=1;j<nums[0].length;j++){
        if(i==nums.length-1 && j==nums[0].length-1){
          return Math.max(dp[i-1][j],dp[i][j-1]);
        }
        else{
          int score1 = Math.min(nums[i][j],dp[i][j-1]);
          int score2 = Math.min(nums[i][j],dp[i-1][j]);
          dp[i][j]= Math.max(score1,score2);
        }
      }
    }

    return 0;
  }
}
