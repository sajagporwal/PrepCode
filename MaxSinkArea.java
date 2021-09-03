public class MaxSinkArea {

  static boolean[][] visited;
  static int ct=0;

  public static boolean checkBoundary(int[][] grid, int i, int j){
    if(i>=grid.length-1 || i<=0 || j>=grid[0].length-1 || j<=0)
      return true;
    return false;
  }

  public static boolean dfs(int[][] grid, int i, int j, int previ, int prevj){
    boolean qualified = true;

    visited[i][j]=true;

    if(previ!=i+1 && !checkBoundary(grid,i+1,j) ){
      if(!visited[i+1][j]) {
        if (grid[i][j] > grid[i + 1][j]) {
          boolean store = dfs(grid, i + 1, j, i, j);
          if (!store)
            qualified = false;
        }
//        else {
//          dfs(grid, i + 1, j, i, j);
//        }
      }
    }

    if(previ!=i-1 && !checkBoundary(grid,i-1,j) ){
      if(!visited[i-1][j]) {
        if (grid[i][j] > grid[i - 1][j]) {
          boolean store = dfs(grid, i - 1, j, i, j);
          if (!store)
            qualified = false;
        }
//        else {
//          dfs(grid, i - 1, j, i, j);
//        }
      }
    }

    if(prevj!=j+1 && !checkBoundary(grid,i,j+1) ){
      if(!visited[i][j+1]) {
        if (grid[i][j] > grid[i][j + 1]) {
          boolean store = dfs(grid, i, j + 1, i, j);
          if (!store)
            qualified = false;
        }
//        else {
//          dfs(grid, i, j + 1, i, j);
//        }
      }
    }

    if(prevj!=j-1 && !checkBoundary(grid,i,j-1) ){
      if(!visited[i][j-1]) {
        if (grid[i][j] > grid[i][j - 1]) {
          boolean store = dfs(grid, i, j - 1, i, j);
          if (!store)
            qualified = false;
        }
//        else {
//          dfs(grid, i, j - 1, i, j);
//        }
      }
    }

    if(qualified)
      System.out.println(i+" "+j);

    if(qualified) {
      ct++;
    }
    return qualified;
  }

  public static void main(String[] args){
    int[][] grid = new int[][]{{1,32,3,14,15,1,22,21,12,6},{10,2,15,5,9,12,9,5,9,18},{8,2,6,3,7,15,4,17,30,3},
            {12,1,6,11,22,5,1,9,10,11},{5,14,7,1,1,20,11,21,17,4}};
    visited = new boolean[grid.length][grid[0].length];
    int mx=0;

//    for(int i=1;i<grid.length-1;i++) {
//      for (int j = 1; j < grid[0].length-1; j++) {
//        ct = 0;
        visited[1][6]=true;
        dfs(grid, 1, 6, -1, -1);
        mx = Math.max(mx, ct);
//      }
//    }

    System.out.println(mx);
  }
}
