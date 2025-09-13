public class PatternPractice {

public void reverseTriangle(int N){
    for (int i = 0; i < N; i++) {
        // 0, 2, 4, 6, ...
        int stars = 2 * (N - i) - 1;             // 11, 9, 7, 5, 3, 1 for N=6

        // print leading spaces
        for (int s = 0; s < i; s++) System.out.print(" ");

        // print stars
        for (int j = 0; j < stars; j++) System.out.print("*"+" ");

        // move to next line
        System.out.println();
    }

}


public static void leftPramid(int n){

    // loop for outer raws
    for (int i = 0; i < n; i++){


        // for printing spaces
        for (int j = 0; j < n-i-1; j++){
            System.out.print(" ");
        }

        // for printing spaces
        for (int j = 0; j <= i; j++){
            System.out.print("*");
        }

        for (int j = 1; j <=i; j++){
            System.out.print("*");
        }

        System.out.println();
    }

}


public static void rightRevresePrymid(int n){
    for (int i =0; i < n; i++){
        // for printing spaces
        for (int j = 0; j <= i; j++){
            System.out.print(" ");
        }

        for (int j = n; j > i; j--){
            System.out.print("*");
        }
        for (int j = n-1
             ; j > i; j--){
            System.out.print("*");
        }


        System.out.println();
    }
}


public static void diamondStarPattern(int n){

    for (int i = 0; i < n; i++){

        // printing spaces for ist traingle
        for (int j = 0; j < n-i-1; j++){
            System.out.print(" ");
        }

        // printing stars
        for (int j = 0; j < 2*i+1; j++){
            System.out.print("*");
        }


        System.out.println();
    }


    for (int i = 0; i < n; i++){
        // for printing spaces for the 2nd triangle
        for (int j = 0; j < i; j++){

            System.out.print(" ");
        }

        // printing stars for the 2nd triangle
        for (int j = 0; j < 2*(n-i)-1; j++){
            System.out.print("*");
        }

        System.out.println();
    }
}

public static void leftDiamondStarPattern(int n){

    // first leftPrymid
    for (int i = 0; i < n; i++){
        for (int j = 0; j <= i; j++){
            System.out.print("*");
        }
        System.out.println();
    }

    // second part of triangle
    for (int i = 0; i < n; i++){
        for (int j = n; j > i; j--){
            System.out.print("*");
        }
        System.out.println();
    }
}


public static void binaryNumberTrianglePattern(int n){

    int start = 1;
    for (int i = 0; i < n; i++){

        if (i%2 == 0){
            start = 1;
        }else {
            start = 0;
        }

        for (int j = 0; j <=i; j++){
            System.out.print(start);
            start = 1-start;
        }
        System.out.println();

    }
}

public static void numberCrownPattern(int n){

    int spaces = 2*(n-1);

    for (int i =1; i < n; i++){

        for (int j = 1; j <=i; j++){
            System.out.print(j);
        }

        for (int j = 1; j<= spaces; j++){
            System.out.print(" ");
        }

        for (int j = i; j>=1; j--){
            System.out.print(j);
        }
        System.out.println();

        spaces -= 2;

    }

}


public static void increasingNumberTrianglePattern(int n){
    int num = 1;
     for (int i = 1; i < n; i++){

         for (int j = 1; j <= i; j++){
             System.out.print(num);

             num = num +1;
         }
         System.out.println();
     }
}

    public static void main(String[] args) {
        int n = 4;
        increasingNumberTrianglePattern(n);











    }


}
