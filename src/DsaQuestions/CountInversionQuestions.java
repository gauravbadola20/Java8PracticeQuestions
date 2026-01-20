package DsaQuestions;

import java.util.HashMap;
import java.util.Map;

public class CountInversionQuestions {


// count frequemcy of an array

    // arr {10,5,10,15,10,5}

    public static void countFreq(int arr[], int n){

        boolean visited [] = new boolean[n];

        int maxFreq = 0;
        int maxElement = 0;



        for (int i = 0; i < n; i++){
            // skip this elements if already processed

            if (visited[i] == true){
                continue;
            }

            // count frequency

            int count = 1;
            for(int j = i+1; j < n; j++){
                if (arr[i] == arr[j]){
                    visited[j] = true;
                    count++;

                }
            }

            if (maxFreq < count){
                maxFreq = count;
                maxElement = arr[i];
            }





        }
        System.out.println(maxElement + " "+maxFreq);
    }


    // using map to find the frequency

    public static void frequency(int arr[], int n){

        int maxFreq = 0, maxElement = 0;


        Map<Integer,Integer> map = new HashMap<>();

        for (int  i =0; i < n; i++){

            if (!map.containsKey(arr[i])){

                map.put(arr[i],1);

            }else{
              int count =    map.get(arr[i]);
              count++;
              map.put(arr[i], count);
            }
        }

        //traverse through map and print the frequency

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){

            int element = entry.getKey();

            int count = entry.getValue();

            if (maxFreq < count){

                maxFreq = count;
                maxElement = element;

            }



        }

        System.out.println(maxFreq + " " + maxElement );

    }



    public static void main(String[] args) {

        int arr [] ={10,5,10,15,10,5};

        int n = arr.length;

        countFreq(arr,n);

//        frequency(arr, n);



    }
}
