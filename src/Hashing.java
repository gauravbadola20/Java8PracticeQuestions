import java.util.HashMap;
import java.util.Map;

public class Hashing {

    public static void countFrequency(int arr[], int n){

        boolean visited[]  = new boolean[n];


        // skip this element if already processed
        for (int i = 0; i < n;  i++){

            if (visited[i] ==  true){
                continue;
            }


            int count = 1;
            for (int j = i+1; j < n; j++){



                if (arr[i] == arr[j]){
                    visited[j] = true;
                    count++;
                }

            }
            System.out.println(arr[i] + " " + count);
        }

    }



    // count freqency using map of an array
    public static void frequencyCountByMap(int arr[], int n){

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++){

            if (!map.containsKey(arr[i])){

                map.put(arr[i],1);
            }else {
              int count =   map.get(arr[i]);
              count++;

              map.put(arr[i],count);
            }
        }

        // traverse  throght the map and print the frequency

        for (Map.Entry<Integer,Integer> entry : map.entrySet()){

            System.out.println(entry.getKey()+" ->    "+ entry.getValue());
        }
    }



    public static void main(String[] args) {

        int arr[] = {10,5,10,15,10,5};

        int n = arr.length;

        frequencyCountByMap(arr,n);


    }
}
