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

    public static void main(String[] args) {

        int n = 4554;
      System.out.println( isPalindromeOrNor(n));


    }
}
