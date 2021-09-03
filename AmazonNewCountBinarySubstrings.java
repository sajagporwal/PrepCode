public class AmazonNewCountBinarySubstrings {
  public static void main(String[] args){

    String s = "0110011";

    int i = 1;
    int count = 0;
    int prev = 0;
    int cur = 1;

    while(i<s.length()){
      if(s.charAt(i)!=s.charAt(i-1)){
        count += Math.min(cur,prev);
        prev = cur;
        cur = 1;
      } else{
        cur++;
      }

      i++;
    }

    count+=Math.min(cur,prev);

    System.out.println(count);

  }
}
