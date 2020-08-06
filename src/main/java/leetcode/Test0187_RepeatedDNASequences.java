package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
//        Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
//        Example:
//        Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//        Output: ["AAAAACCCCC", "CCCCCAAAAA"]
public class Test0187_RepeatedDNASequences {

    private List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (set.contains(sub)) {
                result.add(sub);
            } else {
                set.add(sub);
            }
        }
        return result;
    }

    @Test
    public void test() {
        String dnaSeq = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> repeatedDnaSequences = findRepeatedDnaSequences(dnaSeq);
        System.out.println(repeatedDnaSequences);
    }
}
