package SlidingWindow;

import com.sun.source.tree.BreakTree;

public class CountNiceSubArrays {


    public static void main(String[] args) {


        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(numberOfSubarrays(nums, k));
    }

    private static int numberOfSubarrays(int[] nums, int k) {


        int freq = 0;



        for ( int i = 0; i < nums.length; i++){

            int count = 0;

            for (int j = i; j < nums.length; j++){


                if (nums[j] % 2 != 0){
                    count++;
                }

                if (count > k){

                    break;
                }

                if (count == k){
                    freq++;
                }
            }
        }
        return freq;
    }



    // https://leetcode.com/problems/count-number-of-nice-subarrays/

}
