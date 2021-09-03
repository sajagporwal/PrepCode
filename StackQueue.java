import java.util.Stack;

public class StackQueue {

  public static int recurse(Stack<Integer> st){
    if(st.size()==1){
      return st.pop();
    }
    int val = st.pop();
    int res = recurse(st);
    st.push(val);
    return res;
  }

  public static void main(String[] args){
    Stack<Integer> st = new Stack();
    st.push(1);
    st.push(2);
    st.push(3);
    System.out.println(recurse(st));
  }
}
