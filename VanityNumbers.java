import java.util.*;

public class VanityNumbers {
  public static void main(String[] args) {
    List<String> codes = new ArrayList<>();
    codes.add("TWLO");
    codes.add("CODE");
    codes.add("HTCH");

    List<String> numbers = new ArrayList<>();
    numbers.add("+17474824380");
    numbers.add("+14157088956");
    numbers.add("+919810155555");
    numbers.add("+15109926333");
    numbers.add("+1415123456");

    List<String> op = vanity(codes, numbers);

    for (int i = 0; i < op.size(); i++) {
      System.out.println(op.get(i));
    }

  }

  /**
   * function to make a list of all numbers in  which the vanity codes are present
   *
   * @param codes the vanity codes
   * @param numbers the numbers which are given
   * @return
   */
  public static List<String> vanity(List<String> codes, List<String> numbers) {

    // setting up treeset to store numbers in sorted format without duplicates
    TreeSet<String> set = new TreeSet<>();

    // loop through vanity codes and check if numbers are present or not
    for (int i = 0 ; i < codes.size(); i++) {
      // get the number conversion of vanity code
      String vanityCode = getVanityNumber(codes.get(i));
      // check if vanity number is present in given numbers
      for (int j = 0;  j < numbers.size(); j++) {
        if (numbers.get(j).contains(vanityCode)) {
          // adding number to a set so that they dont duplicate themselves
          set.add(numbers.get(j));
        }
      }
    }

    List<String> list = new ArrayList<>();
    list.addAll(set);
    return list;
  }

  /**
   * function to calculate the string value of the vanity codes
   *
   * @param code the code which needs to be converted to number string
   * @return code which has been converted to number string
   */
  public static String getVanityNumber(String code) {

    // setting up the hashmap according to phonenumber mapping of characters and
    // corresponding numbers
    Map<Character, Integer> map = new HashMap<>();

    map.put('A',2);
    map.put('B',2);
    map.put('C',2);
    map.put('D',3);
    map.put('E',3);
    map.put('F',3);
    map.put('G',4);
    map.put('H',4);
    map.put('I',4);
    map.put('J',5);
    map.put('K',5);
    map.put('L',5);
    map.put('M',6);
    map.put('N',6);
    map.put('O',6);
    map.put('P',7);
    map.put('Q',7);
    map.put('R',7);
    map.put('S',7);
    map.put('T',8);
    map.put('U',8);
    map.put('V',8);
    map.put('W',9);
    map.put('X',9);
    map.put('Y',9);
    map.put('Z',9);


    String vanityCode = "";
    // loop to get number string version of vanity code
    for (int i = 0; i < code.length(); i++) {
      vanityCode = vanityCode + map.get(code.charAt(i));
    }
    return vanityCode;
  }
}
