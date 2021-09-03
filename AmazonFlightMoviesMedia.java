import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmazonFlightMoviesMedia {
  public static void main(String[] args){

    int[] result = new int[2];

    List<Integer> movies = new ArrayList();
    movies.add(90);
    movies.add(85);
    movies.add(75);
    movies.add(60);
    movies.add(120);
    movies.add(150);
    movies.add(125);

    int d = 250;



    Map<Integer,Integer> indexMap = new HashMap();

    for(int i=0;i<movies.size();i++){
      indexMap.put(movies.get(i),i);
    }

    int l=0,r=movies.size()-1;

    int mxSum=Integer.MIN_VALUE;

    while(l<r){
      int sum = movies.get(l)+movies.get(r);
      if(sum<=(d-30)){
        if(sum>mxSum){
          mxSum=sum;
          result[0]=indexMap.get(movies.get(l));
          result[1]=indexMap.get(movies.get(r));
        }
      }
      if(sum>(d-30))
        r--;
      else
        l++;
    }

    System.out.println(result[0]+" "+result[1]);
  }
}
