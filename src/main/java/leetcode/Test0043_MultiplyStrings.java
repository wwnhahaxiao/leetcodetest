package leetcode;

//Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
//        Example 1:
//        Input: num1 = "2", num2 = "3"
//        Output: "6"
//        Example 2:
//        Input: num1 = "123", num2 = "456"
//        Output: "56088"
//        Note:
//        The length of both num1 and num2 is < 110.
//        Both num1 and num2 contain only digits 0-9.
//        Both num1 and num2 do not contain any leading zero, except the number 0 itself.
//        You must not use any built-in BigInteger library or convert the inputs to integer directly.
public class Test0043_MultiplyStrings {
    private static String mySolution(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] arr = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                arr[i + 1 + j + 1 - 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= 10) {
                arr[i - 1] += arr[i] / 10;
                arr[i] = arr[i] % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                for (int j = i; j < arr.length; j++) {
                    sb.append(arr[j]);
                }
                return sb.toString();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        //56088
        System.out.println(mySolution(num1, num2));
    }
}
