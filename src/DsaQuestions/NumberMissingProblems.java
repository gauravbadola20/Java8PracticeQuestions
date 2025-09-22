package DsaQuestions;

import java.util.HashMap;
import java.util.Map;

public class NumberMissingProblems {

    public static int findMissingNumbers(int arr[],int n){


        int j = 0;

        for (int i = 1; i <= n; i++) {


            if (arr[j] != i){

                return i;


            }
            j++;
            System.out.println(j);


        }
        return -1;

    }




    // this is optima apparoach
    public static int finNumAppearOnce(int arr[], int n) {
        int hash[] = new int[100000];

        // store frequencies for ALL elements
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }

        // find the number that appeared once
        for (int i = 0; i < n; i++) {
            if (hash[arr[i]] == 1) {
                return arr[i];
            }
        }
        return -1;
    }


    // brtute force approach

    public static int getSingleElement(int arr[], int n){


        for (int i = 0; i < n; i++){

            int num = arr[i];
            int count = 0;



            for (int j = 0; j < n; j++){

                if (arr[j] == num){
                    count++;
                }
            }

            if (count == 1) return num;
        }

        return -1;
    }


    // another optimal approach

    public static int getSingleElementUinggMap(int arr[], int n){

        // declarre the hasmap,
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++){

            if (!map.containsKey(arr[i])){


                map.put(arr[i],1);

            }else {
             int count =    map.get(arr[i]);
             count++;
             map.put(arr[i], count);
            }
        }


        // find the single element and return the answer
        for (Map.Entry<Integer,Integer> it : map.entrySet()){

           if (it.getValue()==1){

               return it.getKey();
           }
        }

        return -1;

    }





    public static void main(String[] args) {

        int[] arr = {4, 1, 2, 1, 2};

        int n = arr.length;
        int ans = getSingleElementUinggMap(arr,n);
        System.out.println("The single element is: " + ans);
        System.out.println("This is the single elmeemnt:");



    }
}
