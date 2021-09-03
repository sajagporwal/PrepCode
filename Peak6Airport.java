import java.util.ArrayList;
import java.util.List;

public class Peak6Airport {
  public static void main(String[] args){

    List<Integer> landingTimes = new ArrayList<>();
    landingTimes.add(630);
    landingTimes.add(645);
    landingTimes.add(730);
    landingTimes.add(1100);
//    landingTimes.add(630);
//    landingTimes.add(645);
//    landingTimes.add(730);
//    landingTimes.add(830);
//    landingTimes.add(1100);



    List<Integer> takeOffTimes = new ArrayList();
//    takeOffTimes.add(700);
//    takeOffTimes.add(900);
//    takeOffTimes.add(1015);
//    takeOffTimes.add(1130);
//    takeOffTimes.add(1200);
    takeOffTimes.add(700);
    takeOffTimes.add(845);
    takeOffTimes.add(1015);
    takeOffTimes.add(1130);



//    int initialPlanes = 6;
//    int maxWaitTime = 10;
    int initialPlanes = 1;
    int maxWaitTime = 20;

    int result = initialPlanes;
    int i = 0, j = 0;
    int n=landingTimes.size();

    // run a nested  loop to find overlap
    while (i < landingTimes.size() && j < takeOffTimes.size()) {
      if (landingTimes.get(i) < takeOffTimes.get(j)) {
        if(takeOffTimes.get(j)-landingTimes.get(i)>maxWaitTime) {
          initialPlanes++;
        }//platform added
        else{
          j++;
        }
        i++;
        if (initialPlanes > result)    //if platform value is greater, update minPlatform
          result = initialPlanes;
      } else {
        if(initialPlanes>0)
          initialPlanes--;      //delete platform
        j++;
      }
    }
    System.out.println("result"+result);
    while(i<landingTimes.size()){
      result++;
      i++;
    }

    System.out.println(result);
  }
}
