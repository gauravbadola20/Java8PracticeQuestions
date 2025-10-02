package JavaMedium;

public class SubArray {

    public static int maxSubArray(int arr[], int n){

        int maxi  = Integer.MIN_VALUE;
        int sum = 0;

        int start = 0;
        int ansStart = -1;
        int ansEnd = -1;

        for (int i = 0; i < n; i++){

            if(sum == 0) start = i;

            sum += arr[i];

            if (sum > maxi){
                maxi = sum;

                ansStart = start;
                ansEnd = i;
            }


            if (sum < 0){
                sum = 0;
            }


        }

        //  printing the subArray
        System.out.println("The subArray is :[");

        for (int i = ansStart; i <= ansEnd; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();


        return maxi;
    }



    public static void main(String [] args){

        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        long maxSum = maxSubArray(arr, n);
        System.out.println("The maximum subarray sum is: " + maxSum);

    }
}
