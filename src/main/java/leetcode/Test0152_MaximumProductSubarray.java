package leetcode;

import org.junit.Test;

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
    private int[] nums;

    public int maxProduct(int[] nums) {
        this.nums = nums;
        return maxProduct(0, nums.length - 1);
    }

    public int maxProduct(int left, int right) {
        //边界
        if (left == right) return nums[left];
        if (left + 1 >= right) {
            return nums[left] * nums[right] > 0
                    ? nums[left] * nums[right] : Math.max(nums[left], nums[right]);
        }
        int mid = (left + right) / 2;
        //包含中点左半部分最大值
        int lMax = Integer.MIN_VALUE;
        int lMin = Integer.MAX_VALUE;
        int lCurr = 1;
        for (int i = mid; i >= left; i--) {
            lCurr *= nums[i];
            lMax = Math.max(lCurr, lMax);
            lMin = Math.min(lCurr, lMin);
        }
        //从中点开始右半部分最大值
        int rMax = Integer.MIN_VALUE;
        int rMin = Integer.MAX_VALUE;
        int rCurr = 1;
        for (int i = mid + 1; i <= right; i++) {
            rCurr *= nums[i];
            rMax = Math.max(rCurr, rMax);
            rMin = Math.min(rCurr, rMin);
        }
        //过中点的连续子串 最大乘积midMax
        int midMax = Math.max(Math.max(lMax * rMax, lMin * rMin), Math.max(lMax, rMax));
        //中点左边的连续子串 最大乘积leftMax
        int leftMax = maxProduct(left, mid - 1);
        //中点右边的连续子串 最大乘积rightMax
        int rightMax = maxProduct(mid + 1, right);
        return Math.max(Math.max(leftMax, rightMax), midMax);
    }


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

    @Test
    public void test() {
        int[] a = new int[]{2,3,-2,4};
        int[] b = new int[]{-2,0,-1};
        int[] c = new int[]{-2,0,1,2,3,0,-2,1,-2,2,3,-2,-2};
        System.out.println(maxProduct(a));
        System.out.println(maxProduct(b));
        System.out.println(maxProduct(c));
    }
}
