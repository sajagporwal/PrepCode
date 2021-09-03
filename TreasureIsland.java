import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland {

  public static void main(String[] args){

    char[][] arr = new char[][]{{'O', 'O', 'O', 'O'},
            {'D', 'O', 'D', 'O'},
            {'O', 'O', 'O', 'O'},
            {'X', 'D', 'D', 'O'}};
    System.out.println(findTreasure(arr));
  }

  public static int findTreasure(char[][] arr){

    Queue<int[]> queue = new LinkedList<>();
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    int level = 0;

    queue.add(new int[]{0,0});

    while(!queue.isEmpty()) {

      int ct = queue.size();
      while(ct-->0){
        int[] cur = queue.poll();
      for (int[] dir : dirs) {
        int curx = cur[0] + dir[0];
        int cury = cur[1] + dir[1];
        if (curx >= 0 && cury >= 0 && curx < arr.length && cury < arr[0].length && arr[curx][cury] != 'D') {
          if (arr[curx][cury] == 'X')
            return level+1;
          queue.add(new int[]{curx, cury});
          arr[curx][cury] = 'D';
        }
      }
    }
      level++;
    }

    return -1;
  }
}
