import java.util.LinkedList;
import java.util.Queue;

public class DemolitionRobot {
  public static void main(String[] args){

    int[][] lot = new int[][]{{1,0,0},{1,0,0},{1,9,1}};

    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    boolean[][] visited = new boolean[lot.length][lot[0].length];

    Queue<int[]> queue = new LinkedList();

    queue.add(new int[]{0,0});
    visited[0][0]=true;
    int level=0;

    while(!queue.isEmpty()){

      int size = queue.size();
      while(size-->0){
        int[] cur = queue.poll();

        if(lot[cur[0]][cur[1]]==9){
          System.out.println("found it steps : "+ level);
          return;
        }

        for(int[] d:dirs){
          int x = cur[0]+d[0];
          int y = cur[1]+d[1];

          if(x>=0 && x<lot.length && y>=0 && y<lot[0].length && (lot[x][y]==1 || lot[x][y]==9) && !visited[x][y]){
            visited[x][y]=true;
            queue.add(new int[]{x,y});
          }
        }
      }

      level++;
    }

    System.out.println("-1");
    return;
  }
}
