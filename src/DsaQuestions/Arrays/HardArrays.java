package DsaQuestions.Arrays;

import com.sun.source.tree.ArrayAccessTree;

import java.security.Key;
import java.util.*;

public class HardArrays {


    public static List<Integer> majorityElements(int arr1[], int n){

        List<Integer> result = new ArrayList<>();

        for (int i =0 ; i < n; i++ ){

            // now we will select one lements from here and check it with all
            // other lements and incr its count

            int el = arr1[i];



            if (result.isEmpty() || result.getFirst() != arr1[i]) {

                int count = 0;

                for (int j = 0; j < n; j++) {

                    if (arr1[j] == el) {
                        count++;
                    }
                }

                if (count > n / 3) {
                    result.add(el);
                }
            }

            if (result.size() == 2) break;;
        }
        return result;
    }

    // optimal approach using the Hashing
    public static List<Integer> majorityElemets(int arr1[], int n) {

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        // Threshold for majority element (> n/3)
        int mini = (n / 3) + 1;

        for (int i = 0; i < n; i++) {
            int value = map.getOrDefault(arr1[i], 0);
            map.put(arr1[i], value + 1);

            // FIX 1: Pass the element arr1[i], not the array variable arr1
            if (map.get(arr1[i]) == mini) {
                result.add(arr1[i]);
            }

            //  Break only when both possible majority elements are found
            if (result.size() == 2) {
                break;
            }
        }

        return result;
    }


    // triplate that add up to 0
//    {-1, -1, 2 }, {-1, 0, 1}

    public static List<List<Integer>> triplate(int arr1[], int n){

        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < n; i++){

            for (int j = i+1; j < n; j++){

                for (int k = j+1; k < n; k++){

                    if (arr1[i] + arr1[j]+ arr1[j] == 0){

                        List<Integer> temp = Arrays.asList(arr1[i],arr1[j],arr1[k]);

                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(st);

        return ans;

    }

    // OPTIMAL APPROACH USING THE HASHSET
    public static List<List<Integer>> tripleta(int arr1[], int n){
        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < n ; i++){

            Set<Integer>hashSet = new HashSet<>();
            for (int j = i+1; j < n; j++) {

                int third = -(arr1[i] + arr1[j]);

                // find the elemenst in hashset
                if (hashSet.contains(third)){
                    List<Integer> temp = Arrays.asList(arr1[i],arr1[j],third);
                    temp.sort(null);

                    st.add(temp);
                }

                hashSet.add(arr1[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }


    public static int longestSubArrayWithSumZero(int arr1[], int n){

        Map<Integer,Integer> map = new HashMap<>();

        int maxi = 0;
        int sum = 0;

        for (int i = 0; i < n; i++){

            sum += arr1[i];

            if (sum == 0){
                maxi = i+1;
            }else if (map.containsKey(sum)){

                maxi = Math.max(maxi,i-map.get(sum));
            }else {

                map.put(sum,i);
            }
        }
        return maxi;
    }

// find repeating and missing numer
    public static int[] findReapeatingMissingNumbers(int arr1[], int n){

        int repeating = -1;
        int missing = -1;

        for (int  i = 1; i < n; i++){

            int count = 0;

            for (int j = 0; j < n; j++){

                if (arr1[j] == i){
                    count++;
                }


                if (count == 2){
                    repeating = i;
                } else if (count == 0) {
                    missing = i;

                }
            }


            if (repeating == -1 && missing == -1){
                break;
            }
        }
        int ans[] = {repeating,missing};
        return ans;

    }

    //optimal approach using the hashing
    public static int[] findMissingAndRepeatingNumbers(int arr1[], int n){



        int hash[] = new int[n+1];

        for (int i = 0; i < n; i++){
            hash[arr1[i]]++;
        }

        int missing = -1, repeating = -1;
        // now we will check the missing and repeating numbers
        for (int i = 0; i <= n; i++){

            if (hash[i] == 2){
                repeating = i;
            } else if (hash[i] == 0) {
                missing = i;

            }
           if (repeating == -1 && missing == -1)break;
        }
        int ans[] ={repeating,missing};
        return ans;
    }

    public static void main(String[] args) {

        int arr[] = {3,1,2,5,3};
        int n = arr.length;

        int[] reapeatingMissingNumbers = findMissingAndRepeatingNumbers(arr, n);

        System.out.println("Repeating and missing numbers: "+Arrays.toString(reapeatingMissingNumbers));
    }
}
