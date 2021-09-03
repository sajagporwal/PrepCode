public class SubarrayLR {
  public static void main(String[] args){

    int[] arr = new int[]{10,4,-8,7};

    for(int i=1;i<arr.length;i++)
      arr[i]+=arr[i-1];

    int total = arr[arr.length-1];

    int ct=0;
    for(int i=0;i<arr.length-1;i++){
      if(arr[i]>total-arr[i])
        ct++;
    }

    System.out.println(ct);
  }
}
