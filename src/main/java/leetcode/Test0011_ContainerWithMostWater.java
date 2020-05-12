package leetcode;

public class Test0011_ContainerWithMostWater {
    private static int mySolution(int[] height) {
        int left = 0, right = height.length - 1;
        int max = -1;
        while (left < right) {
            max = Math.max(Math.min(height[left], height[right]) * (right - left), max);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(mySolution(test));
    }
}
