import java.util.ArrayList;

public class Sorting {


    public static void selection_sort(int arr[], int n){

        for (int i = 0; i < n; i++){

            int mini = i;


            for (int j = i+1; j < n; j++){

                if (arr[j] < arr[mini]){
                    mini = j;
                }
            }

            // swap the elements
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }

    }



    // bubble sort using iteraive apporach

    public static void bubbleSort(int arr[], int n){

        for (int i = 0; i < n-1; i++){

            for (int j = 0; j < n-1-i; j++){

                if (arr[j] > arr[j+1]){

                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


    //insertion elements

    public static void insertionSort(int arr[], int n){

        for (int i =0; i < n; i++){

            int j = i;

            while (j > 0 && arr[j-1] > arr[j]){

//                swap

                int temp =  arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }


    // merge sort
    public static void merge(int arr[], int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>();

        int left = low;
        int right = mid+1;

        // stroing elements in the temp array in a sorted manner
        while (left <= mid && right <= high){
            if (arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elelemts on th eleft half are still left
        while (left <= mid){
            temp.add(arr[left]);
            left++;

        }

        while (right <= high){
            temp.add(arr[right]);
            right++;

        }


        // transfering the temp el i nto original array
        for (int i = low; i <= high; i++){
            arr[i] = temp.get(i-low);
        }
    }


    public static void mergeSort(int arr[], int low, int high){

        if (low >= high){
            return;
        }

        int mid = (low+high)/2;

        mergeSort(arr, low, mid);
        mergeSort(arr,mid+1, high);
        merge(arr,low,mid,high);
    }


    //bubble sort using recursion

    public static void bubble_sort(int arr[], int n){

        //base condition
        if (n==1) return;

        for (int j = 0; j <= n-2; j++){


            if (arr[j] > arr[j+1]){

                // swap
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }

        bubble_sort(arr,n-1);

    }


    public static void insertionSortUisngRecursion(int arr[], int i, int n){

        if (i==n){
            return;
        }


        int j = i;

        while (j > 0 && arr[j-1] > arr[j]){

            int temp = arr[j];
            arr[j] = arr[j-1];
            arr[j-1] = temp;
            j--;
        }


        insertionSortUisngRecursion(arr, i+1, n);
    }









    public static void main(String[] args){
        int arr[] = {13, 46, 24, 52, 20, 9};
        int n = arr.length;
        System.out.println("Before selection sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        selection_sort(arr, n);


        System.out.println("After selection sort:");
        // time complexity of selection sort is o(n2)
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        bubbleSort(arr,n);
        System.out.println("After bubble sort sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }


        System.out.println();

        insertionSort(arr,n);
        System.out.println("After insertion  sort sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }


        System.out.println();
        mergeSort(arr, 0, n - 1);
        System.out.println("After sorting array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }



        System.out.println();
        bubble_sort(arr, n);

        System.out.println("After bubble sort using recursion: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();



        System.out.println();
        insertionSortUisngRecursion(arr,0,n);


        System.out.println("After insertionSortUisngRecursion sort using recursion: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }






    }

