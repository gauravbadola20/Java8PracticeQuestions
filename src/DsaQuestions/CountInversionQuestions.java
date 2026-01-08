package DsaQuestions;

public class CountInversionQuestions {



    // count inversion in an array
//     it is happen where arr[i] > arr[i]

    public static int numberOfInversion(int arr[], int n){

        // count the number of paris

        int cnt = 0;
        for (int i =0; i <= n; i++){
            for (int j = i+1; j <= n; j++){
                if (arr[i] > arr[j]){
                    cnt++;
                }
            }
        }
        return cnt;

    }

    // now we use optimal approach using the merge sort

    // function to merge two halves and count inversion
    public static int merge(int arr[], int low, int mid, int high){
        // temporary array
        int temp[] = new int[high-low+1];

        // starting indices of left and right halves
        int left = low;
        int right = mid + 1;
        int k = 0;

        //variable to count inversion
        int cnt = 0;


        //merge elements in sorted order
        while (left <= mid && right <= high){

            if (arr[left] <= arr[right]){
                temp[k++] = arr[left++];

            }else {
                temp[k++] = arr[right++];

                cnt += (mid - left + 1);// count inversion
            }
        }

        // copying remaining elements of left half

        while (left <= mid){

            temp[k++] = arr[left++];

        }

        while (right <= high){

            temp[k++] = arr[right++];

        }

        // copy back to original array

        for (int  i = low; i <= high; i++){
            arr[i] = temp[i-low];
        }

        return cnt;
    }


    // merge sort function

    public static int mergeSort(int arr[], int low, int high){


        int cnt = 0;

        if (low >= high) return cnt;


        int mid = (low + high) / 2;

        cnt += mergeSort(arr, low, mid);

        cnt += mergeSort(arr, mid+1, high);



        cnt += merge(arr,low,mid,high);

        return cnt;



    }



    public static void main(String[] args) {

        int arr[] = {5,4,3,2,1};

        int n = arr.length-1;

        int i = mergeSort(arr, 0, n);



        System.out.println(i);


    }
}
