public class AmazonFlask {
  public static void main(String[] args){
    int numOrders = 4;
    int[] requirements = new int[]{4,6,6,7};
    int flaskTypes = 3;
    int totalMarks = 9;
    int[][] markings = new int[][]{{0,3},{0,5},{0,7},{1,6},{1,8}, {1,9}, {2,3}, {2,5}, {2,6}};

    int ptr=0;

    int minWaste = Integer.MAX_VALUE;
    int flaskFinal = -1;

    for(int i=0;i<flaskTypes;i++){

      int waste=0;

      for(int j=0;j<requirements.length;j++){

        while(ptr<markings.length && requirements[j]>markings[ptr][1]){
            ptr++;
        }

        if(ptr>=markings.length || markings[ptr][0]!=i){
          break;
        }

        waste+=markings[ptr][1]-requirements[j];
      }

      if(waste<minWaste){
        minWaste = waste;
        flaskFinal = i;
      }

      while(ptr<markings.length && markings[ptr][0]==i)
        ptr++;
    }

    System.out.println(flaskFinal);
  }
}
