package leetcode;

import java.util.HashMap;
import java.util.Map;

//Validate if a given string can be interpreted as a decimal number.
//        Some examples:
//        "0" => true
//        " 0.1 " => true
//        "abc" => false
//        "1 a" => false
//        "2e10" => true
//        " -90e3   " => true
//        " 1e" => false
//        "e3" => false
//        " 6e-1" => true
//        " 99e2.5 " => false
//        "53.5e93" => true
//        " --6 " => false
//        "-+3" => false
//        "95a54e53" => false
//        Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:
//        Numbers 0-9
//        Exponent - "e"
//        Positive/negative sign - "+"/"-"
//        Decimal point - "."
//        Of course, the context of these characters also matters in the input.
public class Test0065_ValidNumber {
    private static int make(char c) {
        switch(c) {
            case ' ': return 0;
            case '+':
            case '-': return 1;
            case '.': return 3;
            case 'e': return 4;
            default:
                if(c >= 48 && c <= 57) return 2;
        }
        return -1;
    }

    //official solution 状态机解法
    private static boolean isNumber(String s) {
        int state = 0;
        int finals = 0b101101000;
        int[][] transfer = new int[][]{
                { 0, 1, 6, 2,-1},
                {-1,-1, 6, 2,-1},
                {-1,-1, 3,-1,-1},
                { 8,-1, 3,-1, 4},
                {-1, 7, 5,-1,-1},
                { 8,-1, 5,-1,-1},
                { 8,-1, 6, 3, 4},
                {-1,-1, 5,-1,-1},
                { 8,-1,-1,-1,-1}
        };
        for (char c : s.toCharArray()) {
            int id = make(c);
            if (id < 0) return false;
            state = transfer[state][id];
            if (state < 0) return false;
        }
        return (finals & (1 << state)) > 0;
    }

    public static void main(String[] args) {
        Map<String, Boolean> map = new HashMap<>();
        map.put("0", true);
        map.put("0.1", true);
        map.put("2e10", true);
        map.put(" -90e3   ", true);
        map.put(" 6e-1", true);
        map.put("53.5e93", true);
        map.put("3.", true);
        map.put(".1", true);
        map.put("+.8", true);
        map.put("46.e3", true);
        map.put("abc", false);
        map.put("1 a", false);
        map.put(" 1e", false);
        map.put("e3", false);
        map.put(" 99e2.5 ", false);
        map.put(" --6 ", false);
        map.put("-+3", false);
        map.put("95a54e53", false);
        map.put(" ", false);
        map.put(".", false);
        map.put(".e1", false);
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            if (isNumber(entry.getKey()) != entry.getValue()) {
                System.out.println("failed: " + entry.getKey());
                break;
            }
        }
        System.out.println("done");
    }
}
