import java.util.Stack;

public class StackPreorder {
  public static void main(String[] args){
    int[] pre = new int[]{2,4,1};
    System.out.println(stack(pre));
  }

  public static boolean stack(int[] pre){
    Stack<Integer> st = new Stack();
    int root = Integer.MIN_VALUE;

    for(int i:pre){
      if(i<root){
        return false;
      }
      while(!st.isEmpty() && (int)st.peek()<i){
        root=st.pop();
      }
      st.push(i);
    }

    return true;
  }
}
