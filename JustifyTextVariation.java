import java.util.ArrayList;
import java.util.List;

public class JustifyTextVariation {

  public static void main(String[] args){
    String[] res = solve();
    for(String s:res){
      System.out.println(s);
    }
  }

  public static String[] solve() {
    String[][] lines = new String[][]{{"hello","world"},{"How","areYou","doing"},{"Please look","and align","to right"}};
    String[] align = new String[]{"LEFT","RIGHT","RIGHT"};
    int maxWidth=16;
    List<String> al = new ArrayList();
    StringBuilder sb = new StringBuilder("");
    for(int i=0;i<maxWidth;i++)
      sb.append("*");
    al.add(sb.toString());
    sb.setLength(0);
    int curAlign=0;
    for(String[] line :lines){
      String currentLine="";
      for(int i=0;i<line.length;i++){
        sb.append("*");
        String word = "";
        String temp="";
        while(temp.length()<=maxWidth && i<line.length){
          if(i!=0)
            temp=temp+" "+line[i];
          else
            temp=temp+line[i];
          if(temp.length()<=maxWidth)
            word=temp;
          else
            break;
          i++;
        }
        if(temp.length()<=maxWidth)
          word=temp;
        i--;
        if(align[curAlign].equals("RIGHT")){
          if(word.length()<maxWidth){
            int gap = maxWidth-word.length();
            while(gap-->0){
              sb.append(" ");
            }
          }
          sb.append(word);
        }else {
          sb.append(word);
          if (word.length() < maxWidth) {
            int gap = maxWidth - word.length();
            while (gap-- > 0) {
              sb.append(" ");
            }
          }
        }
        sb.append("*");
        al.add(sb.toString());
        sb.setLength(0);
      }
      curAlign++;
    }
    for(int i=0;i<maxWidth;i++)
      sb.append("*");
    al.add(sb.toString());
    sb.setLength(0);
    String[] st = new String[al.size()];
    int start=0;
    for(String s:al)
      st[start++]=s;
    return st;
  }
}
