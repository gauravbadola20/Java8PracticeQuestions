package DsaQuestions.Collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapQ {


    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>();

        map.put(3, "Rahul");
        map.put(1, "Gaurav");
        map.put(2, "Amit");


      for( Map.Entry<Integer,String> it : map.entrySet()){

//          System.out.println(it.getKey() + "  "+ it.getValue());

        }

//        2. Remove Duplicate Characters while Preserving Order

//        String str = "programming";

//      Map<Character,Boolean> linkedMap = new LinkedHashMap<>();
//
//      for (char ch : str.toCharArray()){
//
//          linkedMap.put(ch, true);
//      }
//
//      for (Map.Entry<Character,Boolean> it : linkedMap.entrySet()){
//
////          System.out.print(it.getKey());
//      }

//        3. First Non-Repeated Character
        String str = "swiss";

      Map<Character,Integer> linkedMap = new HashMap<>();

      for (char ch : str.toCharArray()){

          if (!linkedMap.containsKey(ch)){

              linkedMap.put(ch,1);
          }else{

           int count =    linkedMap.get(ch);
           count++;
           linkedMap.put(ch,count);
          }
      }

      for (Map.Entry<Character,Integer> it : linkedMap.entrySet()){

          if (it.getValue() == 1){

//              System.out.println(it.getKey());
              break;
          }
      }

      //implement the lru cache
    Map<Integer,String> map1 = new LinkedHashMap<>(16,0.75F,true);

      map1.put(1, "A");
        map1.put(2, "B");
        map1.put(3, "C");

  ;
        map1.put(4,"D");
        map1.put(5,"E");

//        System.out.println(map1);



        LRUCache<Integer, String> cache =
                new LRUCache<>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");


        cache.put(4,"D");

//        System.out.println(cache);

//        6. Find Last Inserted Element

        Map<Integer,String> newMap = new HashMap<>();

        newMap.put(1, "A");
        newMap.put(2, "B");
        newMap.put(3, "C");

        Integer lastKey = null;

        for (Map.Entry<Integer,String> it : newMap.entrySet()){

            lastKey = it.getKey();

        }
//System.out.println(lastKey);


    }





}

class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(
            Map.Entry<K, V> eldest) {

        return size() > capacity;
    }
}
