public class MaxSumSubMatrix
{

  public static int findMaxSumSubMatrix(int grid[][], int k, int maxSum, int[][] sum)
  {
    int M = grid.length;
    int N = grid[0].length;
    
    int total, max = Integer.MIN_VALUE;

    for (int i = k - 1; i < M; i++)
    {
      for (int j = k - 1; j < N; j++)
      {

        total = sum[i][j];
        if (i - k >= 0) {
          total = total - sum[i - k][j];
        }

        if (j - k >= 0) {
          total = total - sum[i][j - k];
        }

        if (i - k >= 0 && j - k >= 0) {
          total = total + sum[i - k][j - k];
        }

        if (total > max && total<=maxSum) {
          max = total;
        }
      }
    }

    return max;
  }

  public static void main(String[] args)
  {
    // 5 x 5 matrix
    int[][] grid =
            {
                    {4,5},
                    {6,7}
            };

    int maxSum=2;

    int mx=Integer.MIN_VALUE;
    int k=0;

    int M = grid.length;
    int N = grid[0].length;

    int[][] sum = new int[M][N];
    sum[0][0] = grid[0][0];

    for (int j = 1; j < N; j++) {
      sum[0][j] = grid[0][j] + sum[0][j - 1];
    }

    for (int i = 1; i < M; i++) {
      sum[i][0] = grid[i][0] + sum[i - 1][0];
    }

    for (int i = 1; i < M; i++) {
      for (int j = 1; j < N; j++) {
        sum[i][j] = grid[i][j] + sum[i - 1][j] + sum[i][j - 1]
                - sum[i - 1][j - 1];
      }
    }

    // p contains bottom right corner coordinates of sub-matrix
    for(int i=1;i<=grid.length;i++){
      int curMax = findMaxSumSubMatrix(grid, i,maxSum,sum);
      if(curMax>mx) {
        mx = curMax;
        k = i;
      }
    }

    System.out.println(k);
  }
}
