package leetcode;

import java.util.ArrayList;
import java.util.List;

//Given a string containing only digits, restore it by returning all possible valid IP address combinations.
//        Example:
//        Input: "25525511135"
//        Output: ["255.255.11.135", "255.255.111.35"]
public class Test0093_RestoreIPAddresses {

    private static List<String> mySolution(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() > 12) return result;
        for (int i = 1; i < 4 && i <= s.length() - 3; i++) {
            String first = s.substring(0, i);
            if (!valid(first)) break;
            for (int j = 1; j < 4 && i + j <= s.length() - 2; j++) {
                String second = s.substring(i, i + j);
                if (!valid(second)) break;
                for (int k = 1; k < 4 && i + j + k <= s.length() - 1; k++) {
                    String third = s.substring(i + j, i + j + k);
                    if (!valid(third)) break;
                    String fourth = s.substring(i + j + k);
                    if (valid(fourth)) {
                        result.add(first + "." + second + "." + third + "." + fourth);
                    }
                }
            }
        }
        return result;
    }

    private static boolean valid(String str) {
        return str.length() <=3 && Integer.parseInt(str) <= 255 && (str.length() <= 1 || str.charAt(0) != '0');
    }

    public static void main(String[] args) {
//        List<String> ips = mySolution("25525511135");
//        List<String> ips = mySolution("0000");
//        List<String> ips = mySolution("010010");
        List<String> ips = mySolution("0279245587303");
        System.out.println(ips);
    }
}
