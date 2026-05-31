package DsaQuestions.Arrays;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

public class ArraysQ {


    public static int findLargestElement(int arr[], int n){

        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){

            if (largest < arr[i]){
                largest = arr[i];
            }
        }
        return largest;
    }

    // find the second largest element
    public static int secondLargestElement(int arr[], int n){

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;


        for (int i = 0; i < n; i++){

            if (largest < arr[i]){

                secondLargest = largest;
                largest = arr[i];
            }else if (secondLargest < arr[i] && largest > arr[i]){
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }

    //check if array is sorted or not
    public static boolean isSorted(int arr[], int n){

        for (int i = 0; i < n; i++){

            if (arr[i] > arr[i+1]){
                return false;

            }
        }
        return true;
    }

    // remove duplicates

    public static int[] removeDuplicates(int arr[], int n){

        int j = 0;

        for (int i = 1; i < n; i++){

            if (arr[i] != arr[j]){
                j++;
                arr[j] = arr[i];
            }
        }

        int result[] = new int[j+1];

        for (int i = 0; i <= j; i++){
            result[i] = arr[i];
        }

        return result;
    }

    // left rotate array by one

    public static void leftRotateByOne(int arr[], int n){

        int temp = arr[0];

        for (int i = 1; i < n; i++){

            arr[i-1]= arr[i];
        }

        arr[n-1] = temp;

        for (int i = 0; i < n; i++){

            System.out.print(arr[i] + " ");
        }

    }

    // rotated by n elements

    public static void leftRotateByKtimes(int arr[], int k, int n){

        k = k % n;

        reverseArray(arr,0, k-1);

        reverseArray(arr,k,n-1);

        reverseArray(arr,0,n-1);


        for (int i = 0; i < n; i ++){

            System.out.print(arr[i] + " ");
        }



    }
    //reverse the array
    public static void reverseArray(int arr[], int left, int n){

       int right = n;

       while (left < right){

           int temp = arr[left];
           arr[left] = arr[right];
           arr[right] = temp;

           left++;
           right--;
       }
    }

    // right rotation
//    intput 1,2,3,4,5
//    output:4,5,1,2,3
    // reverse the whole array
    // 5,4,3,2,1
    // 5,4,1,2,3
    // 4,5,1,2,3


    public static void rightRotationByKtimes(int arr[], int k, int n){

        k = k % n;

        reverseArray(arr,0,n-1);
        reverseArray(arr,k, n-1);
        reverseArray(arr,0,k-1);



        for (int  i =0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }



    }

    // move all zeros to the end of the array
    public static void moveZerosToEnd(int arr[], int n){
         int j = 0;// it will track the non-zeros

         for (int i = 0; i < n; i++){

             if (arr[i] != 0){


                if (i != j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;


                }
                 j++;

             }
         }



    }


    // Linear search
    public static boolean linearSearch(int arr[], int n, int key){


        for (int i = 0; i < n; i++){

            if (arr[i] == key){

                return true;
            }
        }
        return false;
    }

    //unio of two sorted arrays

    public static ArrayList<Integer> findUnion(int arr1[], int n, int arr2[], int m){

        HashMap<Integer,Integer> map = new HashMap<>();

        ArrayList<Integer> union = new ArrayList<>();


        for (int i = 0; i < n; i ++){


            if (!map.containsKey(arr1[i])) {

                map.put(arr1[i], 1);
            }else {

              int count =   map.get(arr1[i]);
              count++;
              map.put(arr1[i],count);
            }


        }

        for (int i = 0; i < m; i++){

            if (!map.containsKey(arr2[i])){
                map.put(arr2[i],1);

            }else{

            int count =     map.get(arr2[i]);
            count++;
            map.put(arr2[i],count);
            }
        }

//        now will traverse in whole map
        for (int  i : map.keySet()){
            union.add(i);
        }



        return union;
    }

    // make union of with two pointer approach

    public static ArrayList<Integer> findUnionWithTwoPointer(int arr1[], int n, int arr2[], int m){

        int i = 0;
        int j = 0;

        ArrayList<Integer> union = new ArrayList<>();

        while (i < n && j < m){



            if (arr1[i] <= arr2[j]){


                if (union.isEmpty() ||union.getLast() != arr1[i]) {




                    union.add(arr1[i]);


                }
                i++;



            }else{

               if (union.isEmpty() || union.getLast() != arr2[j]) {


                   union.add(arr2[j]);



               }
                j++;


            }

        }
        // remaning element
        while (i < n){
            if (union.isEmpty() ||union.getLast() != arr1[i]) {




                union.add(arr1[i]);


            }
            i++;
        }

        while (j < m){
            if (union.isEmpty() || union.getLast() != arr2[j]) {


                union.add(arr2[j]);



            }
            j++;
        }


        return union;
    }

    // find the missing numbers in an array
    // input: 1,2,4,5


    public static int findMissingNumbers(int arr[], int n){

        int j = 0;

        for (int i = 1; i < n; i++){

            if (arr[j] != i){

                return i;
            }
            j++;
        }

        return -1;

    }

    // approach2 : to find the missing numbers

    public static int missigNumbers(int arr[], int n){

        // outer loops that run from 1 to n

        for (int i  =1; i < n; i++){


            // it is used to check if the element is exist or not
            int flag = 0;

            for (int j = 0; j < n; j++){

                if (arr[j] == i){

                    flag=1;
                    break;
                }
            }

            // check the flag 0
            if (flag == 0){
                return i;
            }


        }
        return -1;

    }


    // better approach using hashing
    public static int findMissingNunbersHashing(int arr[], int n){

        int hash[] = new int[n+1];

        // store frequencies

        for (int i = 0; i < n-1; i++){

            hash[arr[i]]++;
        }

        // now checking the frequencies from 1 to n

        for (int  i =1; i < n; i++){
            System.out.println(i);

            if (hash[i] == 0){
                return i;
            }
        }
        return -1;
    }


    // apprpach 3: summiation

    public static int missingNumber(int arr[], int n){

        int sum = (n*(n+1)/2);

        int s2 = 0;
        for (int i = 0; i< n-1; i++){

            s2 += arr[i];
        }

        int missingNumbers =  sum-s2;

        return missingNumbers;
    }

    // counting maximum consecutive ones in the array

    // input: 1,1,0,1,1,1

    public static int coutingMaximumConsecutiveOnes(int arr1[], int n){

        int maxCount  = 0;
        int count = 0;

        for (int i = 0; i < n; i++){



            if (arr1[i] == 1){

                count++;
            }else {
                count = 0;
            }

            maxCount = Math.max(maxCount,count);


        }
        return maxCount;
    }



    //input: {2,2,1}
// find the number that has only one occurence
public static ArrayList<Integer> findNumberAppearOnce(int arr1[], int n){

        // we will use hash, means will store the freq
    int hash[] = new int[n+1];

    int firstOccur = 0;
    int secondOccur = 0;

    ArrayList<Integer> occur = new ArrayList<>();


    // store the frequency
    for (int i = 0 ; i < n; i++){

        hash[arr1[i]]++;
    }

    // now we will check the  numbers that has only oine frequency
    for (int i = 0; i < n; i++){

        if (hash[i] == 1){

            firstOccur = arr1[i];
            occur.add(firstOccur);

        }else if (hash[i] == 2){
           secondOccur = arr1[i];
           occur.add(secondOccur);
        }
    }

    return  occur;

}

// find the element that occur at once

    public static int findNumbersThatOccurOnce(int arr1[], int n){

        for (int  i =0 ; i < n; i++){

            int count = 0;

            for (int  j = 0; j < n;  j++){

                if (arr1[j] == arr1[i]){
                    count++;

                }
            }

            // check only for one count

            if (count == 1){
                return  arr1[i];
            }
        }
        return -1;
    }

    // find the element theoccur  one using hashmap
    public static int findElementOccurOnce(int arr1[], int n){

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < n; i ++){

            if (!map.containsKey(arr1[i])){

                map.put(arr1[i],1);
            }else{

                int count =  map.get(arr1[i]);
                count++;
                map.put(arr1[i],count);
            }
        }

        //traerse in map

        for (Map.Entry<Integer,Integer> num: map.entrySet()){

            if (num.getValue() == 1){

                return num.getKey();
            }
        }
        return -1;
    }


    // longest substring with given sum k positives

    public static int getLongestSubStringArray(int arr1[], int n, int kSum){

        int len = 0;

        for (int i = 0; i < n; i++){ // starting index

            for (int j = i; j < n; j++){

                long sum = 0;

                for (int k = i; k <= j; k++){

                    sum += arr1[k];
                }

                if (sum == kSum){

                    len = Math.max(len, j-i+1);

                }
            }


        }

        return len;

    }


    // input: 2,3,5
    // hashing prefux approach

public static int getLongestSubArray(int arr1[], int n, int  k ){


        // delcare map
    Map<Integer,Integer> map = new HashMap<>();

    int sum = 0;
    int maxLen = 0;


    for (int i = 0; i < n; i++){

        // claculatye the prefixsum
        sum += arr1[i];

        if (sum == k){
            maxLen = Math.max(maxLen,i+1);
        }

        // calculate the sum of remaing part from sum-k = rem
        int rem = sum - k;


        if (map.containsKey(rem)){
             int len = i - map.get(rem);
             maxLen = Math.max(maxLen,len);
        }


        if (!map.containsKey(rem)){

            map.put(sum,i);
        }
    }
    return maxLen;

}


// find longestSubArray with k sum using the two pointer approach
    public static int getLongestSubArrayWithSumK(int arr1[], int n, int k){

        int left = 0;
        int right = 0;
        int sum = 0;
        int maxLen = 0;

        while (right < n){


            sum += arr1[right];


            while (left <= right && sum > k){

                sum -= arr1[left];
                left++;



            }


            if (sum == k){

                maxLen = Math.max(maxLen, right-left+1);
            }


            right++;


        }
        return maxLen;
    }




    public static void main(String[] args) {

        int arr1[] = {2,3,5};
        int arr2[] = {2,3,4,4,5};

        int n = arr1.length;
        int m = arr2.length;
        int k = 5;


   int  numberAppearOnce = getLongestSubArrayWithSumK(arr1, n,k);
        System.out.println("This longest SubArray sum is : "+numberAppearOnce);


    }
}
