package leetcode;

import java.util.*;

//Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//        Example:
//        Input: [1,1,2]
//        Output:
//        [
//        [1,1,2],
//        [1,2,1],
//        [2,1,1]
//        ]
public class Test0047_PermutationsII {
    private static List<List<Integer>> mySolution(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new LinkedList<>(), new HashSet<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, LinkedList<Integer> list, Set<Integer> set, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        Integer temp = null;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(i)) {
                if (temp != null && temp.equals(nums[i])) {
                    continue;
                } else {
                    temp = nums[i];
                }
                list.add(nums[i]);
                set.add(i);
                backtrack(nums, list, set, result);
                list.removeLast();
                set.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> lists = mySolution(nums);
        System.out.println(lists);
    }
}
