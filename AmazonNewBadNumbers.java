import java.util.Arrays;

public class AmazonNewBadNumbers {
  public static void main(String[] args){

    int[] badNumbers = new int[]{37,7,22,15,49,60};
    int lower = 3;
    int upper = 48;

    // sort the bad numbers to make it easier to find ranges of good numbers
    Arrays.sort(badNumbers);

    int i=0;
    // move forward till we skip bad numbers which are smaller than the lower bound
    while(badNumbers[i]<lower){
      i++;
    }

    int j=badNumbers.length-1;
    // move backward till we skip bad numbers which are greater than the upper bound
    while(badNumbers[j]>upper)
      j--;

    // first range of good numbers including the lower bound
    int mxRange = badNumbers[i]-lower;

    // loop through and keep checking for the ranges
    for(int k=i+1;k<=j;k++)
      mxRange=Math.max(mxRange,badNumbers[k]-badNumbers[k-1]-1);

    // last range of good numbers is also considered
    mxRange=Math.max(mxRange,upper-badNumbers[j]);

    // return the maximum range
    System.out.println(mxRange);
  }
}
