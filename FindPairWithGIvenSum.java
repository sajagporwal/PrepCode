import java.util.HashMap;

public class FindPairWithGIvenSum {

  public static void main(String[] args){

    int[] nums1 = new int[]{20, 50, 40, 25, 30, 10};
//    int[] nums2 = new int[]?
    int target = 90;

    int[] res = findPair(nums1,target);
    System.out.println("x= "+res[0]+" "+"y= "+res[1]);
  }

  public static int[] findPair(int[] nums, int target){

    int[] res = new int[2];
    HashMap<Integer,Integer> hm = new HashMap();
    for(int i=0;i<nums.length;i++){
      int t = target-30;
      if(hm.containsKey(t-nums[i])){
        res[0]=hm.get(t-nums[i]);
        res[1]=i;
      }
      hm.put(nums[i],i);
    }
    return res;
  }

}
