package SlidingWindow;

public class LongestMaxSubarray {


    // longest subarray with sum <= k;

    public  static int longestSubArraySum(int arr[], int n, int k){


        int maxLen = 0;

        for (int i = 0; i < n; i++){


            int sum = 0;


            for (int j = i; j < n; j++){

                sum = sum + arr[j];


                if(sum <= k){


                    maxLen = Math.max(maxLen,j-i+1);




                } else if (sum > k) {
                    break;

                }
            }
        }

        return maxLen;
    }



    // optimla approach using sliding window

    public  static int longestSubArraySums(int arr[], int n, int k){

        int l = 0, r = 0, maxLen = 0, sum = 0;
        int start  =0, end = 0;


        while (r < n){

            sum = sum + arr[r];

            // check ing the invalid condition

           if (sum > k){

                sum = sum-arr[l];
                l++;
            }

            if (sum <= k){

                maxLen = Math.max(maxLen,r-l+1);
                start = l;
                end = r;

            }
            r++;
        }


        // print subarray
        System.out.print("Subarray: ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return maxLen;
    }

    public static void main(String[] args) {

        int arr[] = {2,5,1,7,10};
        int n = arr.length-1;

        int k = 14;


        int i = longestSubArraySums(arr, n, k);

        System.out.println(i);


    }




}
