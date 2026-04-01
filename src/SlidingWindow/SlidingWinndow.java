package SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SlidingWinndow {

// 1...>>find longest max subarray whose sum is less than equal to k;
    public static int longestMaxSubArray(int arr[], int n, int k){


        int maxLen = 0;

        for (int i = 0; i < n; i++){

            int sum = 0;

            for (int j  = i; j < n; j++){

                sum  = sum + arr[j];

                if (sum <= k){


                    maxLen = Math.max(maxLen,j-i+1);


                }else if (sum > k){
                    break;
                }


            }
        }

        return maxLen;
    }


    // optimal solution using the sliding window

    public static int longestMaxSubArrayUsingSlidingWindow(int arr[], int n, int k){

     int l = 0, r = 0, maxLen = 0;

     int sum = 0;

     while (r < n){

         sum  = sum + arr[r];

         while (sum > k){

             sum = sum - arr[l];
             l++;
         }

         if (sum <= k) {

             maxLen = Math.max(maxLen, r - l + 1);
         }
         r++;

     }

     return maxLen;



    }


    // 2....>> find the number of subarray with sum k

    public static int countSubarrayOfSumK(int arr[], int n, int k){


        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int presum = 0;

        int count =  0;

        for (int i = 0; i < n; i++){

            presum = presum  + arr[i];

            int remove = presum - k;


            if (map.containsKey(remove)){

                count += map.get(remove);


            }

            map.put(presum, map.getOrDefault(presum,0)+1);


        }

        for (Map.Entry i : map.entrySet()){
            System.out.println(i);
        }

        return count;

    }



    // 3.....> find the longestSubStringWithoutRepeatingCharacters

    public static int longestSubStringWithoutReaptingCharcaters(String s){

        int n = s.length();

        int maxLen = 0;


        for (int  i =0; i < n;  i++){


            int hash[] = new int[256];

            for (int j = i; j < n; j ++){

                if (hash[s.charAt(j)] == 1) break;

               hash[s.charAt(j)] = 1;

               maxLen = Math.max(maxLen, j-i+1);

            }
        }
        return maxLen;

    }


    // optimal approiach using the sliding window

    public static int longestSubStringWithoutReaptingCharcatersOptimql(String s){

        int n = s.length();
        int  l =0, r = 0, maxLen = 0;

        int hash []= new int[256];
        Arrays.fill(hash,-1);

        while (r < n){


            if (hash[s.charAt(r)] >= l){

                l = hash[s.charAt(r)]+1;

            }



            maxLen = Math.max(maxLen,r-l+1);

            hash[s.charAt(r)] = r;
            r++;

        }

        return maxLen;
    }


    //3....>> find maximum points you can obtain from a card
    public static int maximumPoints(int nums[], int n, int k){

        int lSum = 0, rSum = 0, maxSum = 0;

        for (int  i =0; i < k; i++){

            lSum= lSum + nums[i];



        }
        maxSum = lSum;


        int rIndx = n-1;

        for (int i = k-1; i>=0; i--){
            lSum = lSum - nums[i];

            rSum = rSum + nums[rIndx];
            rIndx--;

            maxSum = Math.max(maxSum, lSum+rSum);
        }
        return maxSum;
    }



    public static void main(String[] args) {


        int arr[] = {1,2,3};

        int n = arr.length;

        int nums[] = {6,2,3,4,7,2,1,7,1};

        int k = 4;
        int size = nums.length;

        int i1 = maximumPoints(nums, size, k);
        System.out.println("This is the max points: "+ i1);


//        int i = countSubarrayOfSumK(arr, n, k);

//        System.out.println(i);

        String input = "cadbzabcd";


//        int length = longestSubStringWithoutReaptingCharcatersOptimql(input);

//        System.out.println("Length of longest substring using hashmap without repeating characters: " + length);


    }
}
