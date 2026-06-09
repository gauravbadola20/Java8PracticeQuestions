package DsaQuestions.Arrays;

import Multithreading.Main;

import java.util.Arrays;

public class MetrixArray {



    public static void printMatrx(int[][]arr1, int rows, int cols){

        for (int i = 0; i < rows; i++){

            for (int j = 0; j < cols; j++){

                if (i == j) {

                    System.out.print(arr1[i][j] + "  ");
                }
            }
        }

    }

    // row sum
    public static void printRowSum(int arr1[][], int rows, int cols){

        int maxSun = 0;

        int rowIndex = -1;

        for (int i =0; i < rows; i++){

            int sum = 0;

            for (int j = 0; j < cols; j++){

                sum += arr1[i][j];
            }
            if (sum > maxSun){
                maxSun = sum;

                rowIndex = i;

            }
        }

        System.out.println("Maximum sum row : "+ (rowIndex+1));
        System.out.println("Maximum sum row : "+ maxSun);



    }
//    {1, 2, 3},
//    {4, 5, 6},
//    {7, 8, 9}
    public static void printColSum(int arr1[][], int rows, int cols){

        int maxSun = 0;

        int rowIndex = -1;

        for (int i =0; i < cols; i++){

            int sum = 0;

            for (int j = 0; j < rows; j++){

                sum += arr1[j][i];
            }
            if (sum > maxSun){
                maxSun = sum;

                rowIndex = i;

            }
        }

        System.out.println("Maximum sum row : "+ (rowIndex+1));
        System.out.println("Maximum sum row : "+ maxSun);



    }


    // transpose the metrix
    public static void transposeMetrix(int arr[][], int rows, int cols){


        int transpose[][] = new int[cols][rows];

        for (int i =0 ; i < rows; i++){

            for (int j = 0; j < cols; j++){

                transpose[j][i] = arr[i][j];
            }
        }


        for (int i =0 ; i < rows; i++){

            for (int j = 0; j < cols; j++){

               System.out.print(transpose[i][j] + " ");
            }
        }


    }

    // transpose the metrix
    public static void transposeMetrixWithExtraSpace(int arr[][], int rows, int cols){




        for (int i =0 ; i < rows; i++){

            for (int j = 0; j < cols; j++){

                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;

            }
        }


        for (int i =0 ; i < rows; i++){

            for (int j = i+1; j < cols; j++){

                System.out.print(arr[i][j] + " ");
            }
        }


    }

    public static void rotate90(int[][] arr) {

        int n = arr.length;

        // Transpose

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // Reverse every row

        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = n - 1;

            while (left < right) {

                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;

                left++;
                right--;
            }
        }
    }


    public static void main(String[] args) {


        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        rotate90(matrix);

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {

                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
//        transposeMetrixWithExtraSpace(matrix,rows,cols);

    }


}
