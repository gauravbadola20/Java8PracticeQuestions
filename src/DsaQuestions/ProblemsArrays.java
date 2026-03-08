package DsaQuestions;

import com.sun.source.tree.ArrayAccessTree;

import java.util.*;

public class ProblemsArrays {


    // find the largest array

    // [2,5,1,3,0]
    // logic is this we nned to find the largest array
    // if arr[i] > largest laregest = =arra[i]


    public int largestArray(int arr[], int n){

        int largest = 0;

        for (int i = 0; i < n; i++){

            if (largest < arr[i]){
                largest = arr[i];
            }


        }
        return largest;
    }


    // find the second larggest array

    public int secondLargest(int arr[], int n){

        ProblemsArrays problemsArrays = new ProblemsArrays();
        int largest = problemsArrays.largestArray(arr,n);

        int secondLargest = 0;


        for (int i = 0; i< n; i++){

            if (largest < arr[i]){

                largest = arr[i];
                secondLargest = largest;

            } else if (arr[i] > secondLargest && arr[i] < largest) {

                secondLargest = arr[i];

            }
        }
        return secondLargest;

    }

    // check if the array is sorted or not



    public boolean checkSortedOrnot(int arr[], int n){

        for (int i = 1; i < n; i++){

            if (arr[i] < arr[i-1]){
                return false;
            }
        }
        return true;
    }

    // brute force

    public boolean checkSorted(int arr[], int n){

        for(int i = 0; i < n; i++){

            for (int j = i+1; j < n; j++){

                if (arr[j] < arr[i]){
                    return false;
                }
            }
        }
        return true;

    }


    // remove duplicates

    public int removeDuplicates(int arr[], int n){

        int index = 0;//

        for (int i = 1; i <= n; i++){

            if (arr[i] != arr[index]){

                index++;
                arr[index] = arr[i];


            }
        }
        return index;
    }

    // left rotate by one

    public void leftRotateByOne(int arr[], int n){

        int temp = arr[0];
        for (int i = 0; i < n-1; i++){
            arr[i] = arr[i+1];
        }

        arr[n-1] = temp;


    }



    // left rotate by kth times'




    //move all zeros at teh end of an array


//    int[] arr = {1,0, 2,0,0, 3,0, 4, 7, 8};

    public void moveZeros(int arr[], int n){

        int j = 0;

        for (int i = 0; i <= n; i++){

            if (arr[i] != 0){

                if (i != j){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                }



                j++;
            }



        }

    }


    // linear search
    public int linearSearch(int arr[], int n, int k){


        for (int i = 0; i <= n; i++){

            if (arr[i] == k){
                return i;
            }
        }
        return -1;
    }


    // union of two sorted arrays
//    arr{1,2,3,4,5}
//    arr{2,3,4,4,5}

    ArrayList<Integer> findUnion(int arr1[],int n, int arr2[], int m){

        ArrayList<Integer> union = new ArrayList<>();

        for (int i = 0; i <= n; i++){

            if (!union.contains(arr1[i])){

                union.add(arr1[i]);
            }
        }

        for (int i = 0; i<=m; i++){
            if (!union.contains(arr2[i])){
                union.add(arr2[i]);
            }
        }
        Collections.sort(union);

        return union;
    }


    // using set

    public ArrayList<Integer> findUnionUsingSet(int arr1[],int n, int arr2[], int m ){

        Set<Integer>set = new HashSet<>();


        for (int i  =0 ; i <=n; i++){
            set.add(arr1[i]);
        }



        for (int i = 0; i<=m; i++){
            set.add(arr2[i]);
        }

        ArrayList<Integer> res = new ArrayList<>(set);
        return res;
    }

    // approach using hashMap

    ArrayList<Integer> findUnionByUsingHashMap(int arr1[], int n, int arr2[], int m){

         HashMap<Integer,Integer> freq = new HashMap<>();

        ArrayList<Integer> union = new ArrayList<>();

         for (int i = 0; i <=n; i++){

             if (!freq.containsKey(arr1[i])){

                 freq.put(arr1[i],1);

             }else{

                int count =  freq.get(arr1[i]);
                count++;

                freq.put(arr1[i],count);
             }
         }


         for (int i = 0; i <= m; i++){

             if (!freq.containsKey(arr2[i])){
                 freq.put(arr2[i],1);
             }else{


              int count =    freq.get(arr2[i]);
              count++;

              freq.put(arr2[i],count);


             }
         }


         for (int i : freq.keySet()){
             union.add(i);
         }

         return union;
    }







    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 2, 4};
        int[] b = {2, 2, 4, 4};
        
        int n = a.length-1;
        int m = b.length-1;


        ProblemsArrays problemsArrays = new ProblemsArrays();

  ArrayList<Integer> res =  problemsArrays.findUnionByUsingHashMap(a,n,b,m);



        for (int x : res) {
            System.out.print(x + " ");
        }
    }
}
