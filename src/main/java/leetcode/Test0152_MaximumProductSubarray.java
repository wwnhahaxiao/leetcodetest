package leetcode;

//    Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
//    Example 1:
//    Input: [2,3,-2,4]
//    Output: 6
//    Explanation: [2,3] has the largest product 6.
//    Example 2:
//    Input: [-2,0,-1]
//    Output: 0
//    Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
public class Test0152_MaximumProductSubarray {

    private static int mySolution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            result = Math.max(max, result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,-2,4};
        int[] b = new int[]{-2,0,-1};
        int[] c = new int[]{-2,0,1,2,3,0,-2,1,-2,2,3,-2,-2};
        System.out.println(mySolution(a));
        System.out.println(mySolution(b));
        System.out.println(mySolution(c));
    }
}
