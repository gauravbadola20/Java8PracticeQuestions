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



    public static void main(String[] args) {


        int arr[] = {1,0,2,3,0,4,0,1};

        int n = arr.length;

        putZerosAtLast(arr,n);

        for (int i : arr){
            System.out.print(i+" ");
        }
    }
}
