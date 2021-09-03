import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PremiumTheMaze {
  public static void main(String[] args){
    int[][] maze = new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};

    int[] start = new int[]{0,4};
    int[] destination = new int[]{3,2};

    Queue<int[]> queue = new LinkedList();
    queue.add(new int[]{start[0],start[1]});

    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    boolean[][] visited = new boolean[maze.length][maze[0].length];

    int level=0;

    while(!queue.isEmpty()){

      int size = queue.size();

      while(size-->0){
        int[] cur = queue.poll();

        if(destination[0]==cur[0] && destination[1]==cur[1]){
          System.out.println(true);
          return;
        }

        for(int[] dir:dirs){
          int x = cur[0] + dir[0];
          int y = cur[1] + dir[1];

          while(x>=0 && x<maze.length && y>=0 && y<maze[0].length && maze[x][y]==0){
            x+=dir[0];
            y+=dir[1];
          }

          if(!visited[x-dir[0]][y-dir[1]]){

            queue.add(new int[]{x-dir[0],y-dir[1]});
            visited[x-dir[0]][y-dir[1]]=true;
          }
        }
      }
      level++;
    }

    System.out.println(false);
  }
}
