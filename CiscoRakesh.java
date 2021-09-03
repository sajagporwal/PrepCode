import java.util.ArrayList;
import java.util.List;

public class CiscoRakesh {

  public static int[] REG_YEAR = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  public static int[] LEAP_YEAR = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  private List<Integer> a;

  {
    a = new ArrayList();
    a.add(2);
  }

  public static boolean isLeapYear(int year) {
    
    boolean result = false;
    if (year % 4 == 0)
      result = true;
    if (year % 100 == 0)
      result = false;
    if (year % 400 == 0)
      result = true;
    return result;
  }

  public static int[] getDaysInYear(int year) {
    return isLeapYear(year)? LEAP_YEAR : REG_YEAR;
  }

  public static void main(String[] args) {

    int x_year = 1920;

    int sundayCounter = 0;
    int currentDay = 1 + (isLeapYear(1900) ? 366 : 365);

    for (int i = 1901; i <= x_year; i++) {
      int[] days = getDaysInYear(i);

        for(int d:days){
          currentDay += d;
          currentDay = currentDay % 7;
          if (currentDay == 0 && i==x_year) sundayCounter += 1;
        }
    }

    System.out.println(sundayCounter);
  }

}
