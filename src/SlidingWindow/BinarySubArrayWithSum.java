package SlidingWindow;

import java.util.HashMap;

public class BinarySubArrayWithSum {


    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));
    }

    private static int numSubarraysWithSum(int[] nums, int goal) {


        HashMap<Integer,Integer> prefixSum = new HashMap<>();

        prefixSum.put(0,1);

        int sum = 0;
        int count = 0;

        for (int i =0 ; i  <nums.length; i++){


            sum += nums[i];


            int rem = sum - goal;

            if (prefixSum.containsKey(rem)){

                count +=  prefixSum.get(rem);
            }

            prefixSum.put(sum, prefixSum.getOrDefault(sum,0) + 1);

        }

        return count;
    }
}
