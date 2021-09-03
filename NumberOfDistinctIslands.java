import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
  public static void main(String[] args){

    int[][] grid = new int[][]{{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
    Set<String> hs = new HashSet();

    for(int i=0;i<grid.length;i++){
      for(int j=0;j<grid[0].length;j++){
        if(grid[i][j]==1){
          StringBuilder sb = new StringBuilder("");
          dfs(grid,i,j,sb,"s");
          hs.add(sb.toString());
        }
      }
    }
    System.out.println(hs.size());
  }

  private static void dfs(int[][] grid, int i, int j, StringBuilder sb, String path) {
    if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0)
      return;
    grid[i][j]=0;
    sb.append(path);
    dfs(grid,i-1,j,sb,"u");
    dfs(grid,i+1,j,sb,"d");
    dfs(grid,i,j-1,sb,"l");
    dfs(grid,i,j+1,sb,"r");
    sb.append("e");
  }
}
