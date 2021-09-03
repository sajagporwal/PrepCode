public class AddTwoNumbers {
  public static void main(String[] args){
    String a = "11";
    String b = "9";
    char[] num1 = a.toCharArray();
    char[] num2 = b.toCharArray();

    int i = num1.length - 1;
    int j = num2.length - 1;

    StringBuilder sumString = new StringBuilder();
    int carry = 0;

    while(i >= 0 || j >= 0){
      int d1 = 0;
      int d2 = 0;

      if (i >= 0) d1 = num1[i--] - '0';
      if (j >= 0) d2 = num2[j--] - '0';

      int sum = d1 + d2;

      sumString.insert(0, sum);
    }

    System.out.println(sumString.toString());
  }
}
