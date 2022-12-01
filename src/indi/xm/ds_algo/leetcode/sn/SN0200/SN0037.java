package indi.xm.ds_algo.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0037
 * @Author: albert.fang
 * @Description: 解数独
 * @Date: 2021/11/12 11:27
 */
public class SN0037 {

    public void solveSudoku(char[][] board) {
        dfs(board);
    }

    private boolean dfs(char[][] board) {

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {
                // 空位置的判断
                if (board[i][j] == '.'){
                    // 每个空位置尝试 1-9
                    for (char tryNum = '1'; tryNum <= '9'; tryNum++) {
                        if (checkIllegal(board,i,j,tryNum)) {

                            board[i][j] = tryNum;

                            if (dfs(board)) {
                                return true;
                            }
                            // 回溯
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean allNums(char[][] board){
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar <= '0' || aChar > '9'){
                    return false;
                }
            }
        }
        return true;
    }

    // 对填入的数字合法性判断
    // true 通过，false 不通过
    private boolean checkIllegal(char[][] board, int row,int col, char tryNum) {

        // 1、在当前行是否存在重复数字
        for (char c : board[row]) {
            if (c == tryNum) {
                return false;
            }
        }

        // 2、在当前列是否存在重复数字
        for (char[] chars : board) {
            if (chars[col] == tryNum) {
                return false;
            }
        }

        // 3、在该位置所处的9个小格子是否存在相同数字
        int rowBoardIndex = row / 3;
        int colBoardIndex = col / 3;

        for (int r = rowBoardIndex * 3; r <= rowBoardIndex * 3 + 2; r++) {
            for (int c = colBoardIndex * 3; c <= colBoardIndex * 3 + 2; c++) {
                if (board[r][c] == tryNum) {
                    return false;
                }
            }
        }
        return true;

    }

    // 具体九个小格子是否存在尝试元素
    // true - 存在，false - 不存在
    private boolean calculateBoard(char[][] board,int row,int col,char tryNum){
        int rowBoardIndex = row / 3;
        int colBoardIndex = col / 3;

        // 找到具体小格子位置
        for (int r = rowBoardIndex * 3; r <= rowBoardIndex * 3 + 2; r++) {
            for (int c = colBoardIndex * 3; c <= colBoardIndex * 3 + 2; c++) {
                if (board[r][c] == tryNum) {
                    return true;
                }
            }
        }
        return false;
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
        solveSudoku(chars);
        for (char[] aChar : chars) {
            System.out.println("[ " + Arrays.toString(aChar) + " ]");
        }
    }


}
