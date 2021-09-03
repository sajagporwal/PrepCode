public class TimesSubsequence {
  public static void main(String[] args){

    String largeString = "ABCBABC";
    String smallString = "ABC";

    int m = largeString.length();
    int n = smallString.length();

    // Create a table to store
    // results of sub-problems
    int lookup[][] = new int[m + 1][n + 1];

    // If first string is empty
    for (int i = 0; i <= n; ++i)
      lookup[0][i] = 0;

    // If second string is empty
    for (int i = 0; i <= m; ++i)
      lookup[i][0] = 1;

    // Fill lookup[][] in
    // bottom up manner
    for (int i = 1; i <= m; i++)
    {
      for (int j = 1; j <= n; j++)
      {
        // If last characters are
        // same, we have two options -
        // 1. consider last characters
        //    of both strings in solution
        // 2. ignore last character
        //    of first string
        if (largeString.charAt(i - 1) == smallString.charAt(j - 1))
          lookup[i][j] = lookup[i - 1][j - 1] +
                  lookup[i - 1][j];

        else
          // If last character are
          // different, ignore last
          // character of first string
          lookup[i][j] = lookup[i - 1][j];
      }
    }

    System.out.println(lookup[m][n]);
  }
}