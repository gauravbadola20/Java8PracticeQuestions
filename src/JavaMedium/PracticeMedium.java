package JavaMedium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PracticeMedium {


    // two sum question by brute force approach

    public static int[] checkTwoSum(int arr[], int n, int target){

        for (int i =0; i < n; i ++){

            for (int j = i; j < n; j++){

                System.out.println(arr[i]+ "  "+ arr[j]);

                if (arr[i] + arr[j] == target){
                  return new int [] {i,j};

                }
            }
        }
        return new int[]{-1,-1};
    }


    //check two sum using the hasing agpproach

    public static int[] checkTwoSumUsingHashing(int arr[], int n, int target){

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++){

            int num = arr[i];

            int rem =  target - num;

            if (map.containsKey(rem)){

                return new int[]{i, map.get(rem)};
            }else{
                map.put(arr[i],i);
            }

        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {

        int arr[] = {2,6,5,8,11};
        int n = arr.length;
        int target = 14;

        System.out.println(Arrays.toString(checkTwoSumUsingHashing(arr, n, target)));

    }
}
