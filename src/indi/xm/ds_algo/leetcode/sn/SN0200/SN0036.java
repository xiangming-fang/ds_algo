package indi.xm.ds_algo.leetcode.sn.SN0200;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0036
 * @Author: albert.fang
 * @Description: 有效的数独
 * @Date: 2021/11/12 14:58
 */
public class SN0036 {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] >= '1' && board[row][col] <= '9'){
                    if (!checkIllegal(board,row,col,board[row][col])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // 对填入的数字合法性判断
    // true 通过，false 不通过
    private boolean checkIllegal(char[][] board, int row,int col, char tryNum) {

        // 1、在当前行是否存在重复数字
        for (int i = 0; i < board[row].length; i++) {
            if (i != col && board[row][i] == tryNum) {
                return false;
            }
        }

        // 2、在当前列是否存在重复数字
        for (int i = 0; i < board.length; i++) {
            if (i != row && board[i][col] == tryNum) {
                return false;
            }
        }

        // 3、在该位置所处的9个小格子是否存在相同数字
        int rowBoardIndex = row / 3;
        int colBoardIndex = col / 3;

        for (int r = rowBoardIndex * 3; r <= rowBoardIndex * 3 + 2; r++) {
            for (int c = colBoardIndex * 3; c <= colBoardIndex * 3 + 2; c++) {
                if (r != row && c != col && board[r][c] == tryNum) {
                    return false;
                }
            }
        }
        return true;

    }

    @Test
    public void test(){
        char[][] chars = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(chars));
    }
}
