public class DrwCode {
  public static void main(String[] args){

//    String S = "cdeo";
//
//    int[] A = new int[]{3,2,0,1};

//    String S = "cdeenetpi";
//
//    int[] A = new int[]{5,2,0,1,6,4,8,3,7};

    String S = "bytdag";

    int[] A = new int[]{4,3,0,1,2,5};



    StringBuilder sb = new StringBuilder("");

    sb.append(S.charAt(0));

    int index = A[0];

    while(index!=0){
      sb.append(S.charAt(index));
      index=A[index];
    }

    System.out.println(sb.toString());
  }
}
