package leetcode;

import java.util.ArrayList;
import java.util.List;

//The set [1,2,3,...,n] contains a total of n! unique permutations.
//        By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
//        "123"
//        "132"
//        "213"
//        "231"
//        "312"
//        "321"
//        Given n and k, return the kth permutation sequence.
//        Note:
//        Given n will be between 1 and 9 inclusive.
//        Given k will be between 1 and n! inclusive.
//        Example 1:
//        Input: n = 3, k = 3
//        Output: "213"
//        Example 2:
//        Input: n = 4, k = 9
//        Output: "2314"
public class Test0060_PermutationSequence {
    private static String mySolution(int n, int k) {
        List<Integer> dictionary = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            dictionary.add(i);
        }
        int total = factorial(n);
        StringBuilder result = new StringBuilder();
        for (int i = n; i > 0; i--) {
            total = total / i;
            if (k % total == 0) {
                result.append(dictionary.remove(k / total - 1));
                for (int j = dictionary.size() - 1; j >= 0; j--) {
                    result.append(dictionary.get(j));
                }
                return result.toString();
            } else {
                result.append(dictionary.remove(k / total));
                k = k % total;
            }
        }
        return result.toString();
    }

    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(mySolution(3, 3));
    }
}
