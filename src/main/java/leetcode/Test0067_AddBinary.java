package leetcode;
//Given two binary strings, return their sum (also a binary string).
//        The input strings are both non-empty and contains only characters 1 or 0.
//        Example 1:
//        Input: a = "11", b = "1"
//        Output: "100"
//        Example 2:
//        Input: a = "1010", b = "1011"
//        Output: "10101"
public class Test0067_AddBinary {
    private static String mySolution(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int upFloor = 0;
        int i = 0;
        while (i < a.length() || i < b.length()) {
            int m = a.length() - 1 >= i ? Character.getNumericValue(a.charAt(a.length() - 1 - i)) : 0;
            int n = b.length() - 1 >= i ? Character.getNumericValue(b.charAt(b.length() - 1 - i)) : 0;
            int value = m + n + upFloor;
            sb.append(value % 2);
            upFloor = value > 1 ? 1 : 0;
            i++;
        }
        if (upFloor > 0) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(mySolution(a, b));
    }
}
