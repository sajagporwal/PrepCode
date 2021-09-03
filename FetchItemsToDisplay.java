import java.util.Arrays;

public class FetchItemsToDisplay {
  public static void main(String[] args){

    String[][] items = new String[][]{{"item1","10","15"},{"item2","3","4"},{"item3","17","8"}};

    customSorter(items,1,0);

    int itemsPerPage = 2;
    int pageNumber = 1;

    int startIndex = itemsPerPage*pageNumber;

    for(int i=startIndex;i<items.length;i++){
      System.out.println(items[i][0]+" "+items[i][1]+" "+items[i][2]);
    }
  }

  public static void customSorter(String[][] items, int sortParameter, int sortOrder){

    if(sortOrder==0){
      Arrays.sort(items,(i1,i2)->{
        if(sortParameter==0){
          return i1[sortParameter].compareTo(i2[sortParameter]);
        } else{
          return Integer.parseInt(i1[sortParameter])-Integer.parseInt(i2[sortParameter]);
        }
      });
    } else{
      Arrays.sort(items,(i1,i2)->{
        if(sortParameter==0){
          return i2[sortParameter].compareTo(i1[sortParameter]);
        } else{
          return Integer.parseInt(i2[sortParameter])-Integer.parseInt(i1[sortParameter]);
        }
      });
    }
  }
}
