package DsaQuestions;


public class MaxConsecutiveOnesIII {


    public static int maxConsecutiveOnes(int arr[], int n, int k){

//        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};

        int maxLen = 0;

        for (int  i =0 ; i < n; i++){

            int zeros = 0;

            for (int j =i; j < n; j++){

                if (arr[j] == 0){

                    zeros++;
                }

                if (zeros > k){
                    break;
                }


                maxLen = Math.max(maxLen,j-i+1);


            }
        }
        return maxLen;
    }


    // optimal solution by sliding window
    public static int maxConsecutive(int arr[], int n, int k){


        int left  = 0;
        int maxLen  = 0;

        int zeros  =0;


        for (int right  = 0; right < n; right++){

            if (arr[right] == 0){
                zeros++;
            }

            // if exceed the k

            while (zeros > k){

                if (arr[left]== 0){
                    zeros--;

                }
                left++;
            }


            maxLen = Math.max(maxLen, right-left+1);






        }
        return maxLen;
    }









   public  static  void main(String[] args){

       int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
       int n = nums.length;
       int k = 2;

       int i = maxConsecutive(nums, n, k);

       System.out.println(i);


   }
}
