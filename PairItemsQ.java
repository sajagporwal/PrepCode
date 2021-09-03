import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class PairItemsQ {

  public static void main(String[] args) {

//    List<String[]> items= Arrays.asList(new String[]{"itemD", "itemE"}, new String[]{"itemI", "itemF"}, new String[]{"itemF", "itemO"},new String[]{"itemA", "itemB"}, new String[]{"itemB", "itemC"});
//    List<String[]> items= Arrays.asList(new String[]{"item1", "item2"}, new String[]{"item3", "item4"}, new String[]{"item4", "item5"});
    List<String[]> items= Arrays.asList(new String[]{"item1", "item2"}, new String[]{"item2", "item3"},new String[]{"item4", "item5"}, new String[]{"item5", "item6"});

    List<String> output=findAssociation(items);
    for(String s:output)
      System.out.print(s+", ");
  }
  public static List<String> findAssociation(List<String[]> items) {

    Map<String, ArrayList<String>> map=new HashMap<>();

    for(String[] itemAss: items){

      boolean item1=map.containsKey(itemAss[0]);
      boolean item2=map.containsKey(itemAss[1]);


      if(item1==true && item2==false){ //add to existing
        ArrayList<String> existingAss=map.get(itemAss[0]);
        existingAss.add(itemAss[1]);
        map.put(itemAss[0],existingAss);
        map.put(itemAss[1],existingAss);
      } else if(item1==false && item2==true){//add to existing
        ArrayList<String> existingAss=map.get(itemAss[1]);
        existingAss.add(itemAss[0]);
        map.put(itemAss[0],existingAss);
        map.put(itemAss[1],existingAss);
      }else if(item1==false && item2==false){ //all new entries
        ArrayList<String> newList=new ArrayList<>();
        newList.add(itemAss[0]);
        newList.add(itemAss[1]);
        map.put(itemAss[0],newList);
        map.put(itemAss[1],newList);
      }else{ //both of these items list already exists
        ArrayList<String> existingAss=map.get(itemAss[0]);
        existingAss.addAll(map.get(itemAss[1]));
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(existingAss);
        ArrayList<String> union=new ArrayList<>(hashSet);
        for(String eachUnion: union){
          map.put(eachUnion,union);
        }
      }
    }
    ArrayList<ArrayList<String>> values= new ArrayList<>(map.values());
    ArrayList<String> maxList=new ArrayList<>();
    int maxCount=0;
    for(ArrayList<String> s: values){
      if(s.size()>maxCount){ // found new set
        maxCount=s.size();
        maxList=s;
      }else if(s.size()==maxCount){ // found other set, check the lexi
        Collections.sort(maxList);
        Collections.sort(s);
        if(s.get(0).compareTo(maxList.get(0))<0){
          maxCount=s.size();
          maxList=s;
        }
      }
    }
    return maxList;
  }
}
