package leetcode;
//Given a 2D board and a word, find if the word exists in the grid.
//        The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//        Example:
//        board =
//        [
//        ['A','B','C','E'],
//        ['S','F','C','S'],
//        ['A','D','E','E']
//        ]
//        Given word = "ABCCED", return true.
//        Given word = "SEE", return true.
//        Given word = "ABCB", return false.
//        Constraints:
//        board and word consists only of lowercase and uppercase English letters.
//        1 <= board.length <= 200
//        1 <= board[i].length <= 200
//        1 <= word.length <= 10^3
public class Test0079_WordSearch {

    private static char[][] boxes;
    private static int[][] used;

    private static boolean mySolution(char[][] board, String word) {
        boxes = board;
        used = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    used[i][j] = 1;
                    if (getNextIndex(word, 1, i, j)) {
                        return true;
                    }
                    used[i][j] = 0;
                }
            }
        }
        return false;
    }

    private static boolean getNextIndex(String word, int index, int i, int j) {
        boolean exist = false;
        if (index == word.length()) {
            exist = true;
        }
        if (!exist && i + 1 < boxes.length && used[i + 1][j] == 0 && boxes[i + 1][j] == word.charAt(index)) {
            used[i + 1][j] = 1;
            if (getNextIndex(word, index + 1, i + 1, j)) {
                exist = true;
            }
            used[i + 1][j] = 0;
        }
        if (!exist && j + 1 < boxes[0].length && used[i][j + 1] == 0 && boxes[i][j + 1] == word.charAt(index)) {
            used[i][j + 1] = 1;
            if (getNextIndex(word, index + 1, i, j + 1)) {
                exist = true;
            }
            used[i][j + 1] = 0;
        }
        if (!exist && i - 1 >= 0 && used[i - 1][j] == 0 && boxes[i - 1][j] == word.charAt(index)) {
            used[i - 1][j] = 1;
            if (getNextIndex(word, index + 1, i - 1, j)) {
                exist = true;
            }
            used[i - 1][j] = 0;
        }
        if (!exist && j - 1 >= 0 && used[i][j - 1] == 0 && boxes[i][j - 1] == word.charAt(index)) {
            used[i][j - 1] = 1;
            if (getNextIndex(word, index + 1, i, j - 1)) {
                exist = true;
            }
            used[i][j - 1] = 0;
        }
        return exist;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println("ABCCED:" + mySolution(board, "ABCCED"));
        System.out.println("SEE:" + mySolution(board, "SEE"));
        System.out.println("ABCB:" + mySolution(board, "false"));
    }
}
