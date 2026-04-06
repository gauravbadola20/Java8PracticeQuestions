package SlidingWindow;

public class MaximumPointsFromACard {


    public static int maxPoints(int arr[],  int k){


        int maxSum = 0;


        for (int i = 0; i < arr.length; i++){

            int sum = 0;

            int count = 0;


            for (int j = i; j < arr.length; j++){


                sum += arr[j];
                count++;

                if (count == k){

                    maxSum = Math.max(maxSum, sum);

                    break;


                }



            }
        }
        return maxSum;

    }


    public static void main(String[] args) {


       int arr[] =  {1,2,3,4,5,6,1};
        int k = 3;


        System.out.println(maxPoints(arr, k));
    }
}
