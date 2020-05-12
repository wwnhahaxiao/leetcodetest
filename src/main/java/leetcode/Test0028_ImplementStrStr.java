package leetcode;

//Implement strStr().
//        Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//        Example 1:
//        Input: haystack = "hello", needle = "ll"
//        Output: 2
//        Example 2:
//        Input: haystack = "aaaaa", needle = "bba"
//        Output: -1
//        Clarification:
//        What should we return when needle is an empty string? This is a great question to ask during an interview.
//        For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
public class Test0028_ImplementStrStr {
    private static int mySolutionForce(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean same = true;
                for (int j = 1; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        same = false;
                    }
                }
                if (same) {
                    return i;
                }
            }
        }
        return -1;
    }
    private static int mySolutionKMP(String haystack, String needle) {
        int i = 0;
        int[] next = getAlreadyMatchlenArr(needle);
        int alreadyOkLen = 0;
        while (i <= haystack.length() - needle.length()) {
            int j = alreadyOkLen;
            while (j < needle.length()) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    alreadyOkLen = next[j];
                    if (j - alreadyOkLen > 0) {
                        i += j - alreadyOkLen - 1;
                    }
                    break;
                }
                j++;
            }
            if (j == needle.length()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private static int[] getAlreadyMatchlenArr(String str) {
        int[] result = new int[str.length() + 1];
        for (int i = 1; i < str.length(); i++) {
            String sub = str.substring(0, i);
            result[i] = getMaxSame(sub);
        }
        result[str.length()] = 0;
        return result;
    }

    private static int getMaxSame(String str) {
        for (int i = str.length() - 1; i > 0 ; i--) {
            String a = str.substring(0, i);
            String b = str.substring(str.length() - i);
            if (a.equals(b)) {
                return i;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(mySolutionForce(haystack, needle));
        System.out.println(mySolutionKMP(haystack, needle));
    }
}
