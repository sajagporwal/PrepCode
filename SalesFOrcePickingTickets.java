import java.util.HashMap;

public class SalesFOrcePickingTickets {

  public static void main(String[] args){

    int max_val = 0;

    int start = 0;

  int[] arr = new int[]{2,5,6,3,7,6,5,8};

    HashMap<Integer, Integer> map = new HashMap<>();


    for (int i = 0; i < arr.length; i++)

    {

      int temp = 0;

      if (map.containsKey(arr[i] - 1))

      {

        temp = map.get(arr[i] - 1);

      }



      if (map.containsKey(arr[i]))

      {

        temp = Math.max(temp, map.get(arr[i]));

      }



      if (map.containsKey(arr[i] + 1))

      {

        temp = Math.max(temp, map.get(arr[i] + 1));

      }

      temp++;

      if (temp > max_val)

      {

        max_val = temp;

      }

      map.put(arr[i], temp);

    }

    System.out.print(max_val);
  }

}
