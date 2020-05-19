package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//        Note: For the purpose of this problem, we define empty string as valid palindrome.
//        Example 1:
//        Input: "A man, a plan, a canal: Panama"
//        Output: true
//        Example 2:
//        Input: "race a car"
//        Output: false
public class Test0125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        s = s.toLowerCase();
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    @Test
    public void test() {
        Map<String, Boolean> testMap = new HashMap<>();
        testMap.put("A man, a plan, a canal: Panama", true);
        testMap.put("race a car", false);
        testMap.entrySet().stream()
                .filter(entry -> isPalindrome(entry.getKey()) != entry.getValue())
                .findAny()
                .ifPresent(System.out::println);
    }
}
