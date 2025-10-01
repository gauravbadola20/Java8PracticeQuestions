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


    public static void sortZerosOnesTwos(int arr[], int n){
        int count1 = 0, count2 = 0, count3 = 0;

        for (int i = 0; i  < n; i++){

            if (arr[i] == 0){
                count1++;

            }else if (arr[i]==1){
                count2++;
            }else {
                count3++;
            }
        }

        int index = 0;
        for (int i =0; i < count1; i++){
            arr[index++] = 0;
        }

        for (int i = 0; i < count2; i++){
            arr[index++] = 1;
        }
        for (int i = 0; i < count3; i++){
            arr[index++] = 2;
        }
    }


    // optimal approach
    public static void sortArrays012s(int arr[], int n){

        int low = 0; int mid  = 0;
        int high = n-1;

        while (mid <= high){

            if (arr[mid] == 0){

                //swap mid with low
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;

            }else {
                //swap with mid with high

                int temp  = arr[mid];
                arr[mid]  = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {0, 2, 1, 2, 0, 1, 2, 0};
        int n = arr.length;
        sortArrays012s(arr,n);

        System.out.print("Sorted Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
