package DsaQuestions.Arrays;

import javax.swing.*;
import java.util.*;

public class MediumArray {


    public static int[] twoSum(int arr1[], int n, int target){

        for (int i = 0; i <   n; i++){

            for (int  j = i+1; j < n; j++){

                if ( arr1[i]+arr1[j] == target){
                    return new int[]{i,j};

                }
            }
        }
        return new int[]{-1,-1};
    }

    // twosum using hashmap

    public static int[]  twoSumUsingHashMap(int arr1[], int n, int target){

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i =0 ; i < n; i++){

            int num = arr1[i];
            System.out.println("This is num: "+num);

            int rem = target-num;

            if (map.containsKey(rem)){

                System.out.println("There us teh rem: "+rem);

                return new int[]{i,map.get(rem)};
            }else {
                map.put(arr1[i],i);
            }
        }

        return new int[]{-1,-1};

    }



    // sort array in 0,1,2

    //input: 2,0,2,1,1,0
    //output : 0,0,1,1,2,2
    public static void sortArray(int arr1[], int n){


        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < n; i++){

            if (arr1[i] == 0){
                count0++;

            }else if (arr1[i] == 1){


                count1++;

            }else {
                count2++;
            }
        }

        // add the elements  i array in sorted mannner
        int index = 0;

        for (int i  =0 ; i < count0; i++){

            arr1[index] = 0;
            index++;
        }

        for (int i  =count0 ; i < count0+count1; i++){

            arr1[index] = 1;
            index++;
        }

        for (int i  =count0+count1 ; i < n; i++){

            arr1[index] = 2;
            index++;
        }



    }


    // optimal approach
    public static  void sortArrayOptimalApproach(int arr1[], int n){

        int low = 0, mid = 0, high = n-1;

        while (mid <= high){

            if (arr1[mid] == 0){
                 int temp = arr1[mid];
                 arr1[mid] = arr1[low];
                 arr1[low] = temp;

                 mid++;
                 low++;
            }else if (arr1[mid] == 1){
                mid++;

            }else{

                int temp = arr1[mid];
                arr1[mid] = arr1[high];
                arr1[high] = temp;

                mid++;
                high--;


            }
        }
    }

    // find the majority elements that occurs more than n/2 times
    // input: 3, 2, 3

    public static int majorityElement(int arr1[], int n){

        for (int i =0 ; i < n; i++){

            int count = 0;

            for (int j = 0; j < n;  j++){

                if (arr1[i] == arr1[j]){
                    count++;
                }
            }
            if (count > n/2){
                return  arr1[i];
            }

        }
        return -1;
    }

    // find majorit using the hashmap
    public static int majorityElementUsingHashMap(int arr1[], int n){

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i =0; i < n; i++){

            if (!map.containsKey(arr1[i])){

                map.put(arr1[i],1);

            }else{

            int count =     map.get(arr1[i]);
            count++;
            map.put(arr1[i],count);
            }
        }

        for (Map.Entry<Integer,Integer> it : map.entrySet()){
            if (it.getValue() > (n/2)){
                return it.getKey();
            }
        }
        return -1;


    }


    // kadna algorithm
    //input: {-2, 1, -3, 4, -1, 2, 1}

    public static int maxSubArraySum(int arr1[], int n){

        int maxSum = Integer.MIN_VALUE;

        int sum = 0;

        for (int i = 0; i < n; i++){

            sum += arr1[i];

            if (sum > maxSum){
                maxSum = sum;
            }

            if (sum < 0){
                sum = 0;
            }
        }
        return maxSum;


    }


    //brute force approach

    public static int maxSubArray(int arr1[], int n){

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){

            int sum = 0;

            for (int j = i; j < n; j++){

                sum += arr1[j];

                if (sum > maxSum){
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }


    // print the max subarray elements

    public static void maxSubArraysumPrintSubArray(int arr1[], int n){

        int maxSum = Integer.MIN_VALUE;

        int sum = 0;
        int start = 0;

        int ansStart = -1, ansEnd = -1;

        for (int i = 0; i < n; i++){

            if (sum == 0){
                start = i;
            }

            sum += arr1[i];

            if (sum > maxSum){

                ansStart = start;
                ansEnd = i;
                maxSum = sum;


            }


            if (sum < 0){
                sum = 0;
            }
        }

        // printing the subarray

        for (int i = ansStart; i <= ansEnd; i++){

            System.out.print(arr1[i] + "  ");
        }
    }


    //stock Buy and Sell
    // prices = {7, 1, 5, 3, 6, 4}

    public static int maxProfitBuySellStock(int prices[], int n){

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < n; i++){

            if (minPrice > prices[i] ){

                minPrice = prices[i];

            }else {

                int profit = prices[i] - minPrice;

                if (profit > maxProfit){
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    // leaders in an array

    // input: {4, 7,2,3, 1, 0}
    // output: {0, 1, 7}

    public static ArrayList<Integer> findLeadersArray(int arr1[], int n){

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++ ){

            boolean leader = true;

            for (int j = i+1; j < n; j++){

                if (arr1[i] < arr1[j]){


                   leader = false;
                   break;

                }
            }

            if (leader){
                ans.add(arr1[i]);
            }

        }
        return ans;


    }

// print leaders using optimal approach
    public static ArrayList<Integer> findLeadersArrayOp(int arr[], int n){

        ArrayList<Integer> ans = new ArrayList<>();



        int max = arr[n-1];
        ans.add(max);

        for (int i = n-2; i >= 0; i--){
             if (arr[i] > max){
                 ans.add(arr[i]);
                 max = arr[i];

             }
        }

        return ans;


    }


    /// Longest consecutive sequence in an array
    // {100, 200, 1, 3, 2, 4}
    // output: 4

//    first we will find the value  using the linear search

    public static boolean linearchSearch(int arr1[], int n, int x){

        for (int i = 0; i < n; i++){

            if (arr1[i] == x){
                return true;
            }
        }

        return false;
    }

    // now we find the longestSuccessive elements
    public static int longestSuccessiveElements(int arr1[], int n){

        int longest = 1;

        for (int i = 0; i < n; i++){

            int x = arr1[i];
            int count = 1;

            while (linearchSearch(arr1, n, x+1)){

                x += 1;
                count += 1;
            }

            longest =   Math.max(longest,count);
        }
        return longest;
    }

    // better approach

    public static int longestSuccssiveElementsOptimalApproach(int arr1[], int n){

        if (n == 0) return 0;

        Arrays.sort(arr1);

        int count = 0;
        int longest = 1;

        int lastSmaller = Integer.MAX_VALUE;

//        100, 200, 1, 3, 2, 4
        for (int i = 0; i < n; i ++){

            if (arr1[i]-1 == lastSmaller ){
                count +=1;
                lastSmaller = arr1[i];
            }else if (arr1[i] != lastSmaller){

                count = 1;
                lastSmaller = arr1[i];
            }
            longest = Math.max(longest,count);
        }
        return longest;
    }

    //optial approach
    public static int longestSuccessiveElementss(int arr1[], int n){
         if (n == 0) return 0;

        Set<Integer> set = new HashSet<>();

        int longest = 1;

        // put all elements in the set

        for (int i = 0; i < n; i++){
            set.add(arr1[i]);
        }

        // find the longest sequence
//        100, 200, 1, 3, 2, 4
        for (int it : set){

            // if it is a starting number

            if (!set.contains(it-1)){
                 int count = 1;
                 int x = it;

                 while (set.contains(x+1)){
                     x = x+1;
                     count++;

                 }

                 longest = Math.max(longest,count);
            }


        }
        return longest;
    }



    // count SubArrays with equal sum k
    // input: 3, 1, 2, 4 k = 6

    public static int countSubArraySumK(int arr1[], int n, int k){

        int count = 0;

        for (int i =- 0; i < n; i++){

            int sum = 0;

            for (int j = i; j < n; j++){

                sum += arr1[j];

                if (sum == k){
                    count++;
                }
            }
        }
        return count;
    }

// optimal sum ising the refix sum

    public static int findSubbArraysEqualsK(int arr1[], int n, int k){

        Map<Integer,Integer> map = new HashMap<>();

        int presum = 0;
        int count = 0;
        map.put(0,1);


        for (int i = 0; i < n; i++){

            presum += arr1[i];

            int remove = presum - k;

            count +=  map.getOrDefault(remove,0);

            map.put(presum, map.getOrDefault(presum,0)+1);

        }
        return count;
    }


    public static void main(String[] args) {
        int arr1[] =  {3, 1, 2, 4};
        int n = arr1.length;
        int  k = 6;

        int target = 14;

        int longest = findSubbArraysEqualsK(arr1, n, k);

        System.out.println("This max subAray count: "+longest);


    }


}
