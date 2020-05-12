package leetcode;
//Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
//        Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
//        The largest rectangle is shown in the shaded area, which has area = 10 unit.
//        Example:
//        Input: [2,1,5,6,2,3]
//        Output: 10
public class Test0084_LargestRectangleInHistogram {

    private static int[] highs;

    private static int mySolution(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        highs = heights;
        return getLargestRectangleArea(0, heights.length - 1);
    }

    private static int getLargestRectangleArea(int left, int right) {
        if (left == right) {
            return highs[left];
        }
        int min = Integer.MAX_VALUE, index = 0;
        for (int i = left; i <= right; i++) {
            if (highs[i] < min) {
                index = i;
                min = highs[i];
            }
        }
        int leftArea = 0;
        if (index > left) {
            leftArea = getLargestRectangleArea(left, index - 1);
        }
        int rightArea = 0;
        if (index < right) {
            rightArea = getLargestRectangleArea(index + 1, right);
        }
        return Math.max((right - left + 1) * min, Math.max(leftArea, rightArea));
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(mySolution(heights));
    }
}
