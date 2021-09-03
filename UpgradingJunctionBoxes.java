import java.util.Arrays;

public class UpgradingJunctionBoxes {
  public static void main(String[] args){

    String[] boxList = new String[]{"ykc 82 01","eo first qpx","09z cat hamster","06f 12 25 6","azo first qpx","236 cat dog rabbit snake"};

    Arrays.sort(boxList,(b1, b2)->{
      String[] a = b1.split(" ",2);
      String[] b = b2.split(" ",2);

      boolean digit1 = Character.isDigit(a[1].charAt(0));
      boolean digit2 = Character.isDigit(b[1].charAt(0));

      if(!digit1 && !digit2){
        int cmp = a[1].compareTo(b[1]);
        if(cmp==0){
          return a[0].compareTo(b[0]);
        }
        return cmp;
      } else if(!digit1 && digit2){
        return -1;
      } else if(digit1 && !digit2){
        return 1;
      }

      return 0;
    });

    for(String p:boxList){
      System.out.println(p);
    }
  }
}
