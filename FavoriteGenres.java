import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//   "David": ["song1", "song2", "song3", "song4", "song8"],
//           "Emma":  ["song5", "song6", "song7"]

// null in output problem. resolved by checking for null value in hashmap

public class FavoriteGenres {

  public static void main(String[] args){

    Map<String, List<String>> userSongs = new HashMap<>();

    Map<String, List<String>> songGenres = new HashMap<>();

//    setUp1(userSongs,songGenres);

    setUp2(userSongs,songGenres);

    Map<String,List<String>> result = compute(userSongs,songGenres);

    for(String user : result.keySet()){
      System.out.println("User: "+user);
      List<String> genres = result.get(user);
      for(String genre:genres)
        System.out.print(genre+" ");
    }

  }

  public static Map<String,List<String>> compute(Map<String,List<String>> userSongs, Map<String,List<String>> songGenres){

    Map<String,List<String>> result = new HashMap<>();
    Map<String,String> songToGenre = new HashMap<>();

    for(String genre : songGenres.keySet()){
      List<String> songs = songGenres.get(genre);

      for(String song:songs){
        songToGenre.put(song,genre);
      }
    }

    for(String user:userSongs.keySet()){

      List<String> songs = userSongs.get(user);
      Map<String,Integer> count = new HashMap<>();
      int mx = 0;

      for(String song:songs){
        if(songToGenre.get(song)!=null) {
          count.put(songToGenre.get(song), count.getOrDefault(songToGenre.get(song), 0) + 1);
          mx = Math.max(mx, count.get(songToGenre.get(song)));
        }
      }

      result.put(user,new ArrayList<>());

      for(String unit : count.keySet()){
        if(mx==count.get(unit)){
          result.get(user).add(unit);
        }
      }

    }

    return result;
  }

  public static void setUp1(Map<String,List<String>> userSongs, Map<String,List<String>> songGenres){
    userSongs.put("David",new ArrayList<>());
    userSongs.get("David").add("song1");
    userSongs.get("David").add("song2");
    userSongs.get("David").add("song3");
    userSongs.get("David").add("song4");
    userSongs.get("David").add("song8");

    userSongs.put("Emma",new ArrayList<>());
    userSongs.get("Emma").add("song5");
    userSongs.get("Emma").add("song6");
    userSongs.get("Emma").add("song7");

    songGenres.put("Rock", new ArrayList<>());
    songGenres.put("Dubstep", new ArrayList<>());
    songGenres.put("Techno", new ArrayList<>());
    songGenres.put("Pop", new ArrayList<>());
    songGenres.put("Jazz", new ArrayList<>());
    songGenres.get("Rock").add("song1");
    songGenres.get("Rock").add("song3");
    songGenres.get("Dubstep").add("song7");
    songGenres.get("Techno").add("song2");
    songGenres.get("Techno").add("song4");
    songGenres.get("Pop").add("song5");
    songGenres.get("Pop").add("song6");
    songGenres.get("Jazz").add("song8");
    songGenres.get("Jazz").add("song9");
  }

  public static void setUp2(Map<String,List<String>> userSongs, Map<String,List<String>> songGenres){
    userSongs.put("David",new ArrayList<>());
    userSongs.get("David").add("song1");
    userSongs.get("David").add("song2");

    userSongs.put("Emma",new ArrayList<>());
    userSongs.get("Emma").add("song3");
    userSongs.get("Emma").add("song4");
  }
}
