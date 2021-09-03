public class MaximumAverageSubtree {

  static class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
      this.val = val;
    }
  }

  public static void setUpTree(TreeNode root){
    root.left = new TreeNode(12);
    root.right = new TreeNode(18);
    root.left.left = new TreeNode(11);
    root.left.right = new TreeNode(3);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(8);

  }

  public static int res = Integer.MIN_VALUE;
  public static double maxAvg = Integer.MIN_VALUE;

  public static void main(String[] args){

    TreeNode root = new TreeNode(20);
    setUpTree(root);
    dfs(root);
    System.out.print(res);
  }

  private static int[] dfs(TreeNode root) {

    if(root==null){
      return new int[]{0,0};
    }
    int[] l = dfs(root.left);
    int[] r = dfs(root.right);
    int sm = l[0]+r[0]+root.val;
    int count = l[1]+r[1]+1;
    double ans = (sm*1.0/count);
    if(count>1) {
      if (ans > maxAvg) {
        maxAvg = ans;
        res = root.val;
      }
    }
    return new int[]{sm,count};
  }
}
