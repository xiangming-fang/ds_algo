package indi.xm.ds_algo.acwing.questions.bfs.s0844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author: albert.fang
 * @Description: 走迷宫
 * @Date: 2022/12/20 10:59
 */
public class Main {

    // 存储迷宫中每个位置的最短路径（从00出发到此位置的）
    static int[][] ans;

    // 迷宫的建模
    static int[][] board;

    // 行列
    static int n,m;

    // bfs 必须用到的队列
    static LinkedList<Pair> q;

    // 四个方向的x坐标变化和y坐标变化，上下左右
    static int[] x = {-1,0,1,0},y = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        board = new int[n][m];
        ans = new int[n][m];
        // 初始让答案都为-1，表示还没有路径经过这个点
        for (int[] ints : ans) {
            Arrays.fill(ints,-1);
        }
        // 但是起始点是可以确认的，就是0
        ans[0][0] = 0;
        int depth = 0;
        while (depth < n){
            String[] s1 = br.readLine().split(" ");
            for (int i = 0; i < s1.length; i++) {
                board[depth][i] = Integer.parseInt(s1[i]);
            }
            depth ++;
        }
        q = new LinkedList<>();
        bfs();
        System.out.println(ans[n-1][m-1]);
    }

    static class Pair{
        public int r;
        public int c;

        public Pair(int r,int c){
            this.r = r;
            this.c = c;
        }
    }

    // 常规bfs模板
    // while 嵌套 for
    public static void bfs(){
        q.offer(new Pair(0,0));
        while (!q.isEmpty()){
            Pair poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int rr = poll.r + x[i],cc = poll.c + y[i];
                // 新坐标合法 && 是可走路径 && 该点之前没有被走过
                if (rr >= 0 && rr < n && cc >= 0 && cc < m && board[rr][cc] == 0 && ans[rr][cc] == -1){
                    ans[rr][cc] = ans[poll.r][poll.c] + 1;
                    q.offer(new Pair(rr,cc));
                }
            }
        }
    }
}
