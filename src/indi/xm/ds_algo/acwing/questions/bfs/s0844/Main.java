package indi.xm.ds_algo.acwing.questions.bfs.s0844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author: albert.fang
 * @Description: 走迷宫
 * @Date: 2022/12/20 10:59
 */
public class Main {

    static boolean[][] flag;

    static int[][] board;

    static int n,m,ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        board = new int[n][m];
        flag = new boolean[n][m];
        int depth = 0;
        while (depth < n){
            String[] s1 = br.readLine().split(" ");
            for (int i = 0; i < s1.length; i++) {
                board[depth++][i] = Integer.parseInt(s1[i]);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1 || flag[i][j]) continue;
            }
        }

    }

    public static int bfs(int r,int c){


    }
}
