import java.util.LinkedList;
import java.util.Queue;

public class Turnstile {
  public static void main(String[] args){

    int[] t = new int[]{0,0,1,5};
    int[] d = new int[]{0,1,1,0};

    Queue<int[]> entry = new LinkedList();
    Queue<int[]> exit = new LinkedList();

    for(int i=0;i<t.length;i++){
      if(d[i]==1){
        exit.add(new int[]{t[i],i});
      } else{
        entry.add(new int[]{t[i],i});
      }
    }

    int lc=-1;
    int ct=0;

    while(!entry.isEmpty() || !exit.isEmpty()){

      if(!exit.isEmpty() && exit.peek()[0]<=ct && (lc==1 || lc==-1 || entry.isEmpty() || entry.peek()[0]>ct)){
        t[exit.peek()[1]]=ct;
        exit.poll();
        lc=1;
      } else if(!entry.isEmpty() && entry.peek()[0]<=ct){
        t[entry.peek()[1]]=ct;
        entry.poll();
        lc=-1;
      } else{
        lc=-1;
      }
      ct++;
    }

    for(int i:t)
      System.out.println(i);
  }
}
