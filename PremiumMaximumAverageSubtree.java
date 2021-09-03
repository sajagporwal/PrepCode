public class PremiumMaximumAverageSubtree {

  static double res = 0;

  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { this.val = val; }
  }

  public static void main(String[] args){

    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(6);
    root.right = new TreeNode(1);

    traverse(root);

    System.out.println(res);
  }

  public static int[] traverse(TreeNode root){
    if(root==null)
      return new int[]{0,0};

    int sm = root.val;
    int num = 1;

    int[] left = traverse(root.left);
    int[] right = traverse(root.right);

    sm+=left[1]+right[1];
    num+=left[0]+right[0];

    res = Math.max(res,(double)sm/(double)num);

    return new int[]{sm,num};
  }
}
