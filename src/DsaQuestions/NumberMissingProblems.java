package DsaQuestions;

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





    public static void main(String[] args) {

        int arr[] = {2,2,1,1,4};
        int n = arr.length;
        System.out.println("This is the missing numbers:");

        System.out.println(finNumAppearOnce(arr,n));



    }
}
