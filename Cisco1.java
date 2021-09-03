public class Cisco1 {
  public static void main(String[] args){
//    int[] arr = new int[]{2,3,10,6,4,8,1};
//    int[] arr = new int[]{5,4,3,8,9,10};
    int[] arr = new int[]{6,3,1,2,27,5,7,8,2};

    int diffMax = arr[1] - arr[0];
    int min = arr[0];
    for (int i = 1; i < arr.length; i++)
    {
      if (arr[i] - min > diffMax)
        diffMax = arr[i] - min;
      if (arr[i] < min)
        min = arr[i];
    }
    System.out.println(diffMax);
  }
}
