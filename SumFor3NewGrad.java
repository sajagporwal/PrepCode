import java.util.Arrays;

public class SumFor3NewGrad {
  public static void main(String[] args){

    int[] nums = new int[]{1,2,3,4,5};
    int target = 8;

    Arrays.sort(nums);
    int min = Integer.MAX_VALUE;

    for(int i=nums.length-1;i>=2;i--){
      int left = 0;
      int right = i-1;

      while(left<right){
        int sum = nums[i]+nums[left]+nums[right];

        if(sum>=target){
          for(int k=left;k<right;k++)
            System.out.println("left: "+nums[k]+" right: "+nums[right]+" i: "+nums[i]);
          right--;
        } else{
          left++;
        }
      }
    }

  }
}
