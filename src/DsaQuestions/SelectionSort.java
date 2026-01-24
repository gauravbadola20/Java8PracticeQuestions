package DsaQuestions;

import java.util.ArrayList;

public class SelectionSort {

    //selection sort here if pic one elemensts put it as min elemenst and if we find any other min
    // elemeents then swap it with this slemenets

    // 13, 46, 24, 52, 20, 9

    public static void selectionSort(int arr[], int n){

        for (int  i = 0; i < n; i++){

            int min = i;


            for (int j = i+1; j < n; j++){

                if (arr[j] < arr[min]){
                    min = j;
                }
            }


            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        // printing all the elemenst in the sorted form

        for (int i = 0; i < n; i++){
            System.out.print(arr[i]);
        }
    }


    //bubble sort

    public static void bubbleSort(int arr[], int n){

        for (int i = 0; i < n-1; i++){


            for (int j = 0; j < n-1-i; j++){

                if (arr[j] > arr[j+1]){

                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

        }

        // printing all the elemenst in the sorted form

        for (int i = 0; i < n; i++){
            System.out.print(arr[i] +" ");
        }
    }


    // insertion sort

    public static void insertionSort(int arr[], int n){

        for (int i = 0; i < n; i++){

            int j = i;


            while (j > 0 && arr[j-1] > arr[j]){

                // swappping

                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }

        for (int i =0; i < n; i++){
            System.out.println(arr[i]);
        }
    }

    // merge sort

    // first we merge the  halves of arrya

    private static void merge(int arr[], int low, int mid, int high){

        ArrayList<Integer> temp = new ArrayList<>();

        int left = low;

        int right = mid + 1;


        // storing array in temp array

        while (left <= mid && right <= high){

            if (arr[left] <= arr[right] ){
                temp.add(arr[left]);
                left++;
            }else{

                temp.add(arr[right]);
                right++;
            }
        }

        // if elemensts left in left half
        while (left <= mid){

            temp.add(arr[left]);
            left++;
        }

        // if elements left in right half

        while (right <= high){
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temp to originnal

        for (int i = low; i <= high; i++){

            arr[i] = temp.get(i-low);
        }
    }


    public static void mergerSort(int arr[], int low, int high){



        if(low >= high) return;

        int mid = (low + high)/2;

        mergerSort(arr, low, mid);// left half

        mergerSort(arr,mid+1, high);

        merge(arr, low, mid,high);


        for (int i =0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

    }


    public static void main(String[] args) {

        int arr[] = { 13, 46, 24, 52, 20, 9};

        int n =arr.length;



    }
}
