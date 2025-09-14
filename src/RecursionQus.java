public class RecursionQus {


    public static void printNames(int i, int n){

        // base condition
        if (i > n) return;

        System.out.println("jdbn");

        printNames(i+1, n);
    }


    public static void printNthNumber(int i, int n){

        // base condition

        if (i > n) return;


        System.out.println(i);

        printNthNumber(i+1, n);
    }


    public static void printNRverseNumber(int i){

        // base case

        if (i < 1) return;

        System.out.println(i);

        printNRverseNumber(i-1);
    }


    public static void printSunNnaturalNumber(int i,int sum){


        // base case
        if (i < 1){
            System.out.println(sum);
            return;
        }

     printSunNnaturalNumber(i-1, sum+i);
    }

    public static int printReverseNum(int n){

        //base case
        if (n == 0){
            return 0;
        }

      return n + (printReverseNum(n-1));
    }


    public static int factoril(int n){

        if (n < 1)
            return 1;


        return n * factoril(n-1);
    }

    public static void reverseArray(int arr[], int left, int right){

        if (left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            reverseArray(arr, left+1, right-1);
        }
    }



    public static int finBociiSeres(int n){
        if (n == 0) return 0;  // base case 1
        if (n == 1) return 1;


        return finBociiSeres(n-1) + finBociiSeres(n-2);
    }


    public static boolean isPalindrome(int i, String s){

        // base condition

        if (i >= s.length()/2) return true;

        if (s.charAt(i) != s.charAt(s.length()-i-1)) return false;

        return isPalindrome(i+1, s);
    }


    public static void main(String[] args) {

   int i =5;

   System.out.println(finBociiSeres(i));


    }


}
