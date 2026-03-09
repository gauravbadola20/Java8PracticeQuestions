package SlidingWindow;

import java.util.*;

public class LongestMaxSubarray {


    // longest subarray with sum <= k;

    public  static int longestSubArraySum(int arr[], int n, int k){


        int maxLen = 0;

        for (int i = 0; i < n; i++){


            int sum = 0;


            for (int j = i; j < n; j++){

                sum = sum + arr[j];


                if(sum <= k){


                    maxLen = Math.max(maxLen,j-i+1);




                } else if (sum > k) {
                    break;

                }
            }
        }

        return maxLen;
    }



    // optimla approach using sliding window

    public static int longestSubArrySumK(int arr[], int n, int k){

        int l = 0, r = 0, maxLen = 0;

        int sum = 0;

        while (r < n){

             sum = sum + arr[r];


             //
            while (sum > k){

                sum = sum - arr[l];
                l++;
            }



             if (sum <= k){

                 maxLen = Math.max(maxLen,r-l+1);
             }


             r++;


        }

        return maxLen;


    }




    // count number of subarrays with k = 3

    public static int  noOfSubArraysWithSumK(int arr[], int n, int k){


        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int  presum = 0;

        int count = 0;

        for (int i = 0; i < n; i ++){

            // prefixsum

            presum = presum + arr[i];

            int remove = presum - k;

            if (map.containsKey(remove)){

                count += map.get(remove);

                System.out.println("This is the count of presum: "+ count);
            }


            map.put(presum,map.getOrDefault(presum,0)+1);


        }

        for (Map.Entry i : map.entrySet()){

            System.out.println(i);
        }

        return count;
    }


    // longest substring without repeating character
    public static int longestSubStringWithoutrepeatingcharacters(String s){



        int n = s.length();
        int maxLen = 0;

        // traverse through all possible starting points

        for (int i  = 0; i < n; i++){

            int [] hash = new int[256];

            for (int j = i; j < n; j++){


                //checking the repeating char
                if (hash[s.charAt(j)] == 1) break; // found repeating character

                hash[s.charAt(j)] = 1;



                maxLen = Math.max(maxLen,j-i+1);
            }
        }
        return maxLen;

    }


    // longest substring without repeating charcaters

    public static int longestSubStringWithoutRepeatingCharcter(String s){

        int n = s.length();

        int [] hash = new int[256];

        int  l =0, r = 0;

        int maxLen = 0;

        Arrays.fill(hash,-1);


        while (r < n){

            // if elements already in the window

            if (hash[s.charAt(r)] >= l){

                l = hash[s.charAt(r)]+1;
            }

            maxLen = Math.max(maxLen,r-l+1);

            hash[s.charAt(r)] = r;
            r++;



        }

        return maxLen;
    }


    // now using the hashet
    public static int longestSubstring(String s){

        Set<Character> set = new HashSet<>();

        int n = s.length();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < n; right++){

            //check if already present
            while (set.contains(s.charAt(right))){

                set.remove(s.charAt(left));
                left++;

            }


            set.add(s.charAt(right));

            maxLen = Math.max(maxLen, right-left+1);



        }
        return maxLen;
    }


    // how to solev it using the hashmap

    public static int longestSubStringWithHashMap(String s){


        HashMap<Character,Integer> map = new HashMap<>();

        int n = s.length();

        int left = 0; int maxLen = 0;

        for (int right = 0; right < n; right++){

            char ch = s.charAt(right);

            if (map.containsKey(ch) && map.get(ch) >= left){

                left = map.get(ch)+1;
            }

            map.put(ch,right);

            maxLen = Math.max(maxLen,right-left+1);

        }
        return maxLen;
    }

    public static void main(String[] args) {

        int arr[] = {1,2,3};
        int n = arr.length;

        int k = 3;


        int i = noOfSubArraysWithSumK(arr, n, k);
        System.out.println(i);

        String input = "cadbzabcd";


        int length = longestSubStringWithHashMap(input);

//        System.out.println("Length of longest substring using hashmap without repeating characters: " + length);


    }




}
