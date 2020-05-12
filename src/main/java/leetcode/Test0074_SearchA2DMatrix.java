package leetcode;
//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//        Integers in each row are sorted from left to right.
//        The first integer of each row is greater than the last integer of the previous row.
//        Example 1:
//        Input:
//        matrix = [
//        [1,   3,  5,  7],
//        [10, 11, 16, 20],
//        [23, 30, 34, 50]
//        ]
//        target = 3
//        Output: true
//        Example 2:
//        Input:
//        matrix = [
//        [1,   3,  5,  7],
//        [10, 11, 16, 20],
//        [23, 30, 34, 50]
//        ]
//        target = 13
//        Output: false
public class Test0074_SearchA2DMatrix {
    private static boolean mySolution(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int left = 0, right = matrix.length * matrix[0].length - 1;
        while (left <= right) {
            int mid = (left + right + 1) / 2;
            int value = matrix[mid / matrix[0].length][mid % matrix[0].length];
            if (value == target) return true;
            if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int[][] matrix = {{1}};

//        int[][] matrix = {
//            {1,   3,  5,  7},
//            {10, 11, 16, 20},
//            {23, 30, 34, 50}
//        };
        System.out.println(mySolution(matrix, 1));
    }
}
