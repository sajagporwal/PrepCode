public class AmazonNewConnections {
  public static void main(String[] args){
    int[][] grid = new int[][]{{1,1,1},{0,1,0},{0,0,0},{1,1,0}};

    int ct=0;

    int i=0;

    // loop through the grid to find the first row with ones
    for(i=0;i<grid.length;i++){
      for(int j=0;j<grid[0].length;j++) {
        if (grid[i][j] == 1) {
          ct++;
        }
      }
      // if ones are found in the row
      if(ct>0) {
        i++;
        break;
      }
    }

    // count of ones in the first row with ones
    int previous = ct;

    // final result count
    int result = 0;

    // loop though the grid to find other rows with ones and calculate the connections
    for(int j=i;j<grid.length;j++){
      ct=0;
      for(int k=0;k<grid[0].length;k++){
        if(grid[j][k]==1) {
          ct++;
        }
      }

      // if row has ones
      if(ct>0){
        // add the multiplication of adjacent rows with ones
        result+=(ct*previous);
        // change the current row to previous
        previous = ct;
      }
    }

    System.out.println(result);
  }
}
