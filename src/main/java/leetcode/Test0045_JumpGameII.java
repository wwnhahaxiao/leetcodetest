package leetcode;
//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//        Each element in the array represents your maximum jump length at that position.
//        Your goal is to reach the last index in the minimum number of jumps.
//        Example:
//        Input: [2,3,1,1,4]
//        Output: 2
//        Explanation: The minimum number of jumps to reach the last index is 2.
//        Jump 1 step from index 0 to 1, then 3 steps to the last index.
//        Note:
//        You can assume that you can always reach the last index.
public class Test0045_JumpGameII {
    private static int mySolution(int[] nums) {
        //开始就在终点
        if (nums.length == 1) {
            return 0;
        }
        //index 当前位置, step 步数
        int index = 0, step = 0;
        //下一次可以跳到终点时停止
        while (index + nums[index] < nums.length - 1) {
            //max 下一次最多可以跳到哪, next 这一次应该跳到哪
            int max = 0, next = 0;
            for (int i = 1; i <= nums[index]; i++) {
                if (nums[index + i] + i > max) {
                    max = nums[index + i] + i;
                    next = i;
                }
            }
            step++;
            index += next;
        }
        return ++step;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,1,1};
        System.out.println(mySolution(nums));

    }
}
