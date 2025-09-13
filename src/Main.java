import java.util.*;

class Main {


    public static List<List<Integer>> triplet(int n, int[] arr) {
        Set<List<Integer>> st = new HashSet<>();

        // check all possible triplets:
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }
        }

        // store the set elements in the answer:
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }



    public static List<List<Integer>> triplets(int n, int arr[]){
        Set<List<Integer>> st = new HashSet<>();

        // find triplets
        for (int i = 0; i < n; i++){

            Set<Integer> set = new HashSet<>();

            for (int j = i+1; j < n; j++){

                int third = -(arr[i]  + arr[j]);

                if (set.contains(third)){
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    temp.sort(null);
                    st.add(temp);
                }


                set.add(arr[j]);

            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }


    // s = "abcabcbb";
    // longest substring without repeating characters


    public static int lengthOfLongestSubstring(String s) {

        if (s.length()==0){
            return 0;
        }

        int maxAns = Integer.MIN_VALUE;


        for (int i  = 0; i < s.length(); i++){
            Set<Character> set = new HashSet<>();

            for (int j = i; j < s.length(); j++){

                if (set.contains(s.charAt(j))){
                    maxAns = Math.max(maxAns,j-i);
                    break;
                }

                set.add(s.charAt(j));
            }
        }
        return maxAns;


    }


    public static int longestLengthOfNonRepeatingCharacter(String str){

        if (str.length() == 0){
            return 0;
        }


        Set<Character> set = new HashSet<>();
        int maxlen = Integer.MIN_VALUE;
        int l = 0;

        for (int r = 0; r < str.length(); r++){

            if (set.contains(str.charAt(r))){

                while (l < r && set.contains(str.charAt(r))){
                    set.remove(str.charAt(l));
                    l++;
                }
            }
            set.add(str.charAt(r));
            maxlen = Math.max(maxlen, r-l+1);
        }
        return maxlen;
    }








    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};


//        int n = arr.length;
//        List<List<Integer>> ans = triplets(n, arr);
//        for (List<Integer> it : ans) {
//            System.out.print("[");
//            for (Integer i : it) {
//                System.out.print(i + " ");
//            }
//            System.out.print("] ");
//        }
//        System.out.println();

        String str = "takeUforward";
        System.out.println("The length of the longest substring without repeatcharacters is " +
                longestLengthOfNonRepeatingCharacter(str));




    }





}