package DsaQuestions;

public class ArraysPractice {


    //put zeros at last in an array
    public static void putZerosAtLast(int arr[], int n){


        int j = 0;

        for (int i = 0; i < n; i++){

            if (arr[i] != 0){

                if (i!=j){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
    }

    // linear serach
    public static int linearSearch(int arr[], int num){

        for (int i = 0; i < arr.length; i++){

            if (arr[i] == num){
                return i;
            }
        }
        return  -1;
    }



    public static void main(String[] args) {


        int arr[] = {1,2,3,4,5};
        int num = 3;

       System.out.println( linearSearch(arr,num));


    }
}
