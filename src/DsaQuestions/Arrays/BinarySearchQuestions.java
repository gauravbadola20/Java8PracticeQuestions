package DsaQuestions.Arrays;

public class BinarySearchQuestions {

public static int lowerBound(int arr1[], int low, int high, int x){

    int ans = 0;


    while (low <= high){

        int mid = (low+high)/2;

        if (arr1[mid] >= x){




            ans = mid;
            high = mid-1;
        }else {

            low = mid+1;
        }
    }
    return ans;
}

// upperbound

    public static int upperrBound(int arr1[], int low, int high, int x){

        int ans = arr1.length;


        while (low <= high) {
            int mid = low + (high - low) / 2;


            if (arr1[mid] > x) {
                ans = mid;        // Store current index as potential answer
                high = mid - 1;   // Move left
            } else {
                low = mid + 1;    // Move right
            }
        }
        return ans;  // Return final answer
    }



    public static void main(String[] args) {

        int arr1[] = {3, 5, 8, 9,15,19};
        int low = 0;
        int x = 9;
        int n = arr1.length;

        int upperrBound = upperrBound(arr1, low, n, x);

        System.out.println("This is upper bound: "+ upperrBound);

    }
}
