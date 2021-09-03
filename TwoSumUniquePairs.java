import java.util.HashSet;

public class TwoSumUniquePairs {

  public static void main(String[] args){

    int[] nums = new int[]{1, 5, 1, 5};
    int[] nums1 = new int[]{1, 1, 2, 45, 46, 46};
    System.out.println(count(nums,6));
    System.out.println(count(nums1,47));
  }

  public static int count(int[] nums,int target){
    int ct=0;
    HashSet<Integer> hs = new HashSet();
    for(int i:nums){
      if(hs.contains(target-i)){
        ct++;
        hs.remove(target-i);
      }
      else{
        hs.add(i);
      }
    }
    return ct;
  }
}
