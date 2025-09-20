package DsaQuestions;

import java.util.ArrayList;
import java.util.HashMap;

public class ArraysPractice {


    //put zeros at last in an array
    public static void putZerosAtLast(int arr[], int n){


        int j = 0;

        for (int i = 0; i < n; i++){

            if (arr[i] != 0){

                if (i!=j){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
    }

    // linear serach
    public static int linearSearch(int arr[], int num){

        for (int i = 0; i < arr.length; i++){

            if (arr[i] == num){
                return i;
            }
        }
        return  -1;
    }

    // find unio using the hashmap
    public static ArrayList<Integer> FindUnion(int arr1[],  int arr2[], int n, int m){

        HashMap<Integer,Integer> freq = new HashMap<>();

        // unio array
        ArrayList<Integer> union = new ArrayList<>();


        // first the arr1 ele in map
        for (int i = 0; i < n; i++){

            freq.put(arr1[i],freq.getOrDefault(arr1[i],0)+1);
        }

        // first the arr2 ele in map
        for (int i = 0; i < m; i++){

            freq.put(arr2[i],freq.getOrDefault(arr2[i],0)+1);
        }

        //now add eleme from hasmpa to unio list

        for (int it : freq.keySet()){
            union.add(it);
        }

        return union;

    }


    // now fiund unio uning two pointer approach
    public static ArrayList<Integer> findUnion(int arr1[],  int arr2[], int n, int m){

        int i =0,  j = 0;

        ArrayList<Integer> union = new ArrayList<>();

        while (i < n && j < m){

            if (arr1[i] <= arr2[j]){

                if (union.isEmpty() || union.get(union.size()-1) != arr1[i]){

                    union.add(arr1[i]);

                }
                i++;

            }else {

                if (union.isEmpty() ||union.get(union.size()-1) != arr2[j]){
                    union.add(arr2[j]);
                }
                j++;
            }
        }

        // if any elemnet left in arr1

        while (i < n){

            if (union.get(union.size()-1) != arr1[i]){

                union.add(arr1[i]);

            }
            i++;

        }


        while (j < m){

            if (union.get(union.size()-1) != arr2[j]){
                union.add(arr2[j]);
            }
            j++;

        }

        return union;
    }





    public static void main(String[] args) {


        int arr1[] = {1, 2, 3, 4, 5};
        int arr2[] = {2, 3, 4, 4, 5};

        int n =arr1.length , m = arr2.length;
        ArrayList<Integer> Union = findUnion(arr1, arr2, n, m);
        System.out.println("Union of arr1 and arr2 is ");
        for (int val: Union)
            System.out.print(val+" ");


    }
}
