package JavaMedium;

import java.util.HashMap;
import java.util.Map;

public class FindMjorityElememnt {

    public static int majorityElement(int arr[], int n){

        for(int i = 0; i < n; i++){

            int count = 0;

            for (int j = i; j < n; j ++){

                if (arr[j] == arr[i]){
                    count++;
                }

                if (count > (n/2)){
                    return arr[i];
                }
            }
        }
        return -1;
    }



    // using hashing approach
    public static int majorityElementUsingHashing(int arr[], int n){

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++){

            if (!map.containsKey(arr[i])){

                map.put(arr[i],1);

            }else{

                int count = map.get(arr[i]);

                count++;

                map.put(arr[i],count);
            }

        }

        for( Map.Entry<Integer,Integer> it : map.entrySet()){

            System.out.println(it.getKey() +" "+ it.getValue());
        }

        // chek the occureence of element form map

       for( Map.Entry<Integer,Integer> it : map.entrySet()){



           if (it.getValue() > (n/2)){
               return it.getKey();
           }

        }





       return -1;

    }


    public static void main(String[] args)
    {

        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int n = arr.length;
        int ans = majorityElementUsingHashing(arr,n);
        System.out.println("The majority element is: " + ans);

    }
}
