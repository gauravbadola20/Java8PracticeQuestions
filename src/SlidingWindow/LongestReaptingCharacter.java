package SlidingWindow;

public class LongestReaptingCharacter {

    public  static int characterReplacement(String s, int k){

        //varibale to track the maximum length of valid substring
        int maxLength = 0;

        // outer loop to iterate to all indeces
      for (int i = 0; i < s.length(); i++){

          // frequency array to  stire count of all characters
          int freq[] = new int[26];

          //variable to tract the max frequent chacrter in current window
          int maxFreq = 0;

          //inner loop to check subString  starting  at i

          for (int j  = i; j < s.length(); j++){

              freq[s.charAt(j)- 'A']++;

              // update the most frequent charcter
              maxFreq = Math.max(maxFreq,freq[s.charAt(j)- 'A']);

              //current window length
              int windowLength = j - i + 1;;


              // Calculate replacements needed to make all characters same

              int replacements = windowLength - maxFreq;

              if (replacements <= k){
                  maxLength = Math.max(maxLength,windowLength);
              }


          }
      }
      return maxLength;
    }


    public static int characterReplacement2(String s, int k){


        // varaiable to tract the maxLength
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++){

            int freq[] = new int[26];

            int maxFreq = 0;


            for (int j = i; j < s.length(); j++){

                freq[s.charAt(j) - 'A']++;

                maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'A']);


                int windowLength = j - i + 1;

                int replacements = windowLength - maxFreq;

                if (replacements <= k){

                    maxLength = Math.max(maxLength,windowLength);
                }


            }
        }
        return maxLength;

    }


    // print the substring instead of length
    public static String characterReplacementPrintSubString(String s, int k){

        int maxLength = 0;
        int startIndex = 0;


        for (int i = 0; i < s.length(); i++){


            int freq[] = new int[26];

            int maxFreq = 0;


            for (int  j = i; j < s.length(); j++){


                freq[s.charAt(j) - 'A']++;

                maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'A']);


                int windowLength = j-i+1;

                int replacement = windowLength - maxFreq;



                if (replacement <= k){

                    if (windowLength > maxLength) {


                        maxLength = windowLength;

                        startIndex = i; // store the start thje stirng
                    }

                }
            }
        }

        return s.substring(startIndex, startIndex+maxLength);
    }


    public static void main(String[] args) {

        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacementPrintSubString(s, k));

    }
}
