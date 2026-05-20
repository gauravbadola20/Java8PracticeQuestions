package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringKDistinctCharacter {


    public static void main(String[] args) {


        String s = "eceba";
        int k = 2;
        System.out.println(lengthOfLongestSubstringKDistinct1(s, k));

    }


    //sliding window
    private static int lengthOfLongestSubstringKDistinct(String s, int k) {


        int left = 0;
        int maxLen = 0;

        Map<Character,Integer> freq = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {

            freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0) + 1);


            while (freq.size() > k) {

                char leftChar = s.charAt(left);

                freq.put(leftChar, freq.get(leftChar) - 1);

                if (freq.get(leftChar) == 0) {

                    freq.remove(leftChar);
                }

                left++;

            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;

    }


    //brute force approach
    private static int lengthOfLongestSubstringKDistinct1(String s, int k) {

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {

            Map<Character, Integer> freq = new HashMap<>();


            int currLen = 0;

            for (int j = i; j < s.length(); j++) {

                freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0) + 1);

                if (freq.size() > k) {
                    break;
                }

                currLen = j-i+1;

                maxLen = Math.max(maxLen, currLen);
            }
        }

        return maxLen;
    }




}
