package SlidingWindow;

import java.util.HashMap;

public class BinarySubArrayWithNum {


    public static int binarySubarray(int arr[], int n, int k){


        int count = 0;

         for (int  i =0; i < n; i++){


             int sum = 0;

             for (int j = i; j < n; j++){

                 sum = sum + arr[j];


                 if (sum == k){

                     count++;
                 }


             }
         }

         return count;


    }


    // Binary sum with prefix
    public static int numsBinaryPrefixSum(int arr[], int n, int k){

        HashMap<Integer,Integer> map = new HashMap<>();

        int count = 0, sum = 0;

        map.put(0,1);

             for (int i = 0 ; i < n; i++){

            sum = sum + arr[i];

            int rem = sum - k;

            // if rem exist, add its count to result

            if (map.containsKey(rem)){
                count  += map.get(rem);
            }

            // update map prefix sum count

            map.put(sum, map.getOrDefault(sum,0)+1);
        }

        return count;
    }

    // sliding windo appraoch

    public static int numsBinaryPrefixSumUsingSlindingWindow(int arr[], int n, int k){

        if (k < 0) return 0;

        int l  = 0, r = 0;
        int count = 0;
        int sum = 0;

        while (r < n){

            sum = sum + arr[r];

            while (sum > k){
                sum = sum - arr[l];
                l++;
            }


            count += (r-l+1);
            r++;
        }

        return count;

    }


    public static void main(String[] args) {

        int[] nums = {1, 0, 1, 0, 1};

      int n = nums.length;

        int k = 2;

        int binarySum1 = numsBinaryPrefixSumUsingSlindingWindow(nums, n, k);
        System.out.println("This is the sum1: "+binarySum1);

        int binarySum2 = numsBinaryPrefixSumUsingSlindingWindow(nums, n, k - 1);
        System.out.println("This is the sum2: "+binarySum2);


        int result = binarySum1 - binarySum2;

        System.out.println("This is the binarysum with sliding window :  "+result);

    }
}
