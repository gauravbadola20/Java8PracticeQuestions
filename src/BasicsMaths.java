import java.util.ArrayList;
import java.util.List;

public class BasicsMaths {


    public static int countDigit(int n){

        int count = 0;
        while (n > 0){
            count++;

            n = n/10;
        }

        return count;
    }

    public static int reverseDigit(int n){

        int rev = 0;

        while(n > 0){

            int digit = n%10;

            rev = (rev*10)+digit;

            n = n/10;

        }
        return rev;
    }

    public static String isPalindromeOrNor(int n){

        int rev = 0;

        int temp = n;
        int digit = 0;

        while (n > 0){

             digit = n % 10;

            rev = (rev * 10) + digit;
            n = n/10;
        }


        if (temp == rev){

            return "This is palindrome";
        }else {
            return "not a palindrome";
        }
    }


    public static boolean isAmstrong(int n){

        int num = n;

        int k = String.valueOf(n).length();

        int sum = 0;

        while (n > 0){
            int id = n%10;

            sum += (int) Math.pow(id,k);

            n = n/10;
        }

        return sum == num;
    }


    public static int[] findDivisors(int n, int size[]){


        int divisors[] = new int[n];
        int count = 0;

        for (int i = 1; i <= n; i++){

            if (n % i == 0){
                divisors[count++] = i;
            }
        }

        size[0] = count;
        return divisors;
    }

    public static List<Integer> printDivisors(int num) {

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= num; i++) {

            if (num % i == 0) {
                list.add(i);
            }
        }
        return list;
    }


    public static String checkPrimeNumber(int n){

        int count = 0;

        for (int i = 1; i <= n; i++){

            if (n % i == 0){
                count++;
            }
        }

        if (count > 2){
            return "Not a prime number";
        }else{
            return "is a prime number";
        }
    }

    public static void main(String[] args) {

        int n = 4;

       System.out.println( checkPrimeNumber(n));
    }



    }

