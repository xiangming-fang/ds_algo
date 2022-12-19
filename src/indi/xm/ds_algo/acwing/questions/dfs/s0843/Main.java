package indi.xm.ds_algo.acwing.questions.dfs.s0843;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author: albert.fang
 * @Description: N皇后
 * @Date: 2022/12/19 17:32
 */
public class Main {

    static char[][] board;

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars,'.');
        }
        dfs(0);
    }

    public static void dfs(int row){
        if (row == n){
            for (char[] chars : board) {
                for (char aChar : chars) {
                    System.out.print(aChar + " ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int j = 0; j < n; j++) {
            if (legal(row,j)) {
                board[row][j] = 'Q';
                dfs(row+1);
                board[row][j] = '.';
            }
        }
    }

    public static boolean legal(int r,int c){
        for (char ch : board[r]) {
            if (ch == 'Q') return false;
        }
        for (int i = 0; i < n; i++) {
            if (board[i][c] == 'Q') return false;
        }
        // 左上角，右上角，左下角，右下角
        int qq = c,ww = c,ee = c,rr = c;
        for (int i = r + 1; i < n; i++) {
            if (qq - 1 >= 0 && board[i][--qq] == 'Q') return false;
            if (ww + 1 < n && board[i][++ww] == 'Q') return false;
        }
        for (int i = r - 1; i >= 0; i--){
            if (ee - 1 >= 0 && board[i][--ee] == 'Q') return false;
            if (rr + 1 < n && board[i][++rr] == 'Q') return false;
        }
        return true;
    }

}
