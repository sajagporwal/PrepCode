import java.util.HashSet;
import java.util.Set;

public class CharsUnique {

  public static void main(String[] args){
    System.out.println(solution(null));
    System.out.println(solution(""));
    System.out.println(solution("acax"));
    System.out.println(solution("codility"));

  }

  public static int solution(String s){

    if(s==null || s.length()==0)
      return 0;

    int countOfCharacters = 0;

    for(int i=0;i<s.length();i++){

      Set<Character> currentCharacters = new HashSet();

      StringBuilder current = new StringBuilder("");

      for(int j=i;j<s.length();j++){

        current.append(s.charAt(j));
        System.out.println(current+" "+currentCharacters.size());
        currentCharacters.add(s.charAt(j));

        countOfCharacters = countOfCharacters+currentCharacters.size();
      }
    }

    int modulo = (int)(1e9+7);

    return (int)(countOfCharacters)%(modulo);
  }

}
