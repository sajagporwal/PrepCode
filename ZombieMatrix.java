import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// rotten oranges
public class ZombieMatrix {

  public static void main(String[] args){

    int[][] arr = new int[][]{{0, 1, 1, 0, 1},
                   {0, 1, 0, 1, 0},
                   {0, 0, 0, 0, 1},
                   {0, 1, 0, 0, 0}};

    // null array
    if(arr == null){
      return;
    }

    // empty array
    if(arr[0].length==0){
      return;
    }

    int countOnes = 0;
    int countZeros = 0;

    Queue<int[]> queue = new LinkedList();

    for(int i=0;i<arr.length;i++){
      for(int j=0;j<arr[0].length;j++){
        if(arr[i][j]==0){
          countZeros++;
        }
        if(arr[i][j]==1){
          countOnes++;
          queue.add(new int[]{i,j});
        }
      }
    }

    if(countOnes == arr.length * arr[0].length || countZeros == arr.length * arr[0].length)
      return;

    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    int ct = countOnes;

    int level = 0;

    while(!queue.isEmpty()){

      int size = queue.size();

      if(ct == arr.length*arr[0].length){
        System.out.println(level);
        return;
      }

      while(size-->0){

        int[] cur = queue.poll();
        int x = cur[0];
        int y = cur[1];

        for(int[] dir : dirs){

          int curx = x+dir[0];
          int cury = y+dir[1];
          if(curx>=0 && curx<arr.length && cury>=0 && cury<arr[0].length && arr[curx][cury]==0){
            ct++;
            arr[curx][cury]=1;
            queue.add(new int[]{curx,cury});
          }
        }
      }

      level++;
    }

    return;
  }
}
