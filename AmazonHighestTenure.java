import java.util.ArrayList;
import java.util.List;

public class AmazonHighestTenure {

  static class TreeNode{
    List<TreeNode> children;
    int val;
    TreeNode(int val){
      this.val = val;
      children = new ArrayList();
    }
  }

  static double res=0;
  static int manager=0;

  public static void main(String[] args){

    TreeNode t1 = new TreeNode(20);
    TreeNode t2 = new TreeNode(12);
    TreeNode t3 = new TreeNode(18);
    TreeNode t4 = new TreeNode(11);
    TreeNode t5 = new TreeNode(2);
    TreeNode t6 = new TreeNode(3);
    TreeNode t7 = new TreeNode(15);
    TreeNode t8 = new TreeNode(8);

    t1.children.add(t2);
    t1.children.add(t3);

    t2.children.add(t4);
    t2.children.add(t5);
    t2.children.add(t6);

    t3.children.add(t7);
    t3.children.add(t8);

    traverse(t1);

    System.out.println(manager);
  }

  public static int[] traverse(TreeNode t){
    if(t==null)
      return new int[]{0,0};

    int sum = t.val;
    int num = 1;

    for(TreeNode cur:t.children) {
      int[] child = traverse(cur);
      sum+=child[0];
      num+=child[1];
    }

    if(t.children.size()!=0){
      double curAverage = (double)sum/(double)num;
      if(curAverage>res){
        res=curAverage;
        manager=t.val;
      }
    }

    return new int[]{sum,num};
  }
}
