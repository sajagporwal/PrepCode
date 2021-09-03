import java.util.HashSet;

public class DrwHour {
  public static void main(String[] args){

    String S="15:15:00";
    String T="15:15:12";

    String[] s1 = S.split(":");
    String[] t1 = T.split(":");

    int hDiff = Integer.parseInt(s1[0])-Integer.parseInt(t1[0]);
    int mDiff = Integer.parseInt(s1[1])-Integer.parseInt(t1[1]);
    int sDiff = Integer.parseInt(s1[2])-Integer.parseInt(t1[2]);

    HashSet hs = new HashSet();
    for(int i=0;i<=hDiff;i++){
      Integer.parseInt(s1[0]);
      for(int j=0;j<=mDiff;j++){
        for(int k=0;k<=sDiff;k++){

        }
      }
    }
  }
}
