package leetcode;

import org.junit.Test;

import java.util.Arrays;

//Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
//        A region is captured by flipping all 'O's into 'X's in that surrounded region.
//        Example:
//        X X X X
//        X O O X
//        X X O X
//        X O X X
//        After running your function, the board should be:
//        X X X X
//        X X X X
//        X X X X
//        X O X X
//        Explanation:
//        Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
public class Test0130_SurroundedRegions {

    private char[][] board;
    private char[][] result;
    private boolean[][] memory;

    private void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        this.board = board;
        memory = new boolean[board.length][board[0].length];
        result = new char[board.length][board[0].length];
        int left = 0, right = board[0].length - 1, down = 0, up = board.length - 1;
        for (int i = down; i <= up; i++) {
            placeNextO(i, left);
            placeNextO(i, right);
        }
        for (int i = left; i <= right; i++) {
            placeNextO(down, i);
            placeNextO(up, i);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (result[i][j] != 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void placeNextO(int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
            if (!memory[i][j]) {
                memory[i][j] = true;
                if (board[i][j] == 'O') {
                    result[i][j] = 'O';
                    placeNextO(i - 1, j);
                    placeNextO(i + 1, j);
                    placeNextO(i, j - 1);
                    placeNextO(i, j + 1);
                }
            }
        }
    }

    @Test
    public void test() {
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
//                {'O','O','O'},
//                {'O','O','O'},
//                {'O','O','O'}
        };
        solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}
