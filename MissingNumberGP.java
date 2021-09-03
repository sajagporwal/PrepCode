public class MissingNumberGP {

  public static void main(String[] args){

    int[] nums = new int[]{1,2,8};

    int ratio = (int)(Math.pow(nums[nums.length-1]/nums[0],1.0/nums.length)) ;

    System.out.println(binarySearch(nums,0,nums.length-1,ratio));

  }

  private static int binarySearch(int[] nums, int l, int h, int ratio) {

    if(l>=h)
      return Integer.MAX_VALUE;

    int m = l + (h-l)/2;

    if(nums[m+1]/nums[m]!=ratio){
      return nums[m]*ratio;
    }
    if(m>0 && nums[m]/nums[m-1]!=ratio)
      return nums[m-1]*ratio;

    if(nums[m]==nums[0]*Math.pow(ratio,m))
      return binarySearch(nums,m+1,h,ratio);

    return binarySearch(nums,l,m-1,ratio);
  }
}
