package indi.xm.ds_algo.leetcode.sn.SN1000;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1000
 * @ClassName: SN0944
 * @Author: albert.fang
 * @Description: 腐烂的橘子
 * @Date: 2021/9/2 13:18
 */
public class SN0994 {
    class pos{
        int r;
        int c;

        public pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public int orangesRotting01(int[][] grid) {
        Queue<pos> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int goodOrange = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2){
                    queue.offer(new pos(i,j));
                }
                if (grid[i][j] == 1){
                    goodOrange ++;
                }
            }
        }
        int count = -1;
        while (!queue.isEmpty()){
            count ++;
            // 一定要先保存再遍历，不如出队之后，大小会变
            int size = queue.size();
            // 每层一下子输出完，再走下一层。
            for (int i = 0; i < size; i++) {
                pos cur = queue.poll();

                visited[cur.r][cur.c] = true;

                // 上下左右 四个方向
                if (cur.r - 1 >= 0 && !visited[cur.r - 1][cur.c] && grid[cur.r - 1][cur.c] == 1){
                    queue.offer(new pos(cur.r - 1,cur.c));
                    grid[cur.r - 1][cur.c] = 2;
                    goodOrange --;
                }
                if (cur.r + 1 <= row - 1 && !visited[cur.r + 1][cur.c] && grid[cur.r + 1][cur.c] == 1){
                    queue.offer(new pos(cur.r + 1,cur.c));
                    grid[cur.r + 1][cur.c] = 2;
                    goodOrange --;
                }
                if (cur.c - 1 >= 0 && !visited[cur.r][cur.c - 1] && grid[cur.r][cur.c - 1] == 1){
                    queue.offer(new pos(cur.r,cur.c - 1));
                    grid[cur.r][cur.c - 1] = 2;
                    goodOrange --;
                }
                if (cur.c + 1 <= col - 1 && !visited[cur.r][cur.c + 1] && grid[cur.r][cur.c + 1] == 1){
                    queue.offer(new pos(cur.r,cur.c + 1));
                    grid[cur.r][cur.c + 1] = 2;
                    goodOrange --;
                }
            }
        }
        count = count == -1 ? 0 : count;
        return goodOrange != 0 ? -1 : count;
    }

    /************************2022-01-04*****************************/

    public int orangesRotting(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        LinkedList<int[]> queue = new LinkedList<>();
        boolean zeroFlag = true;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 2){
                    queue.offer(new int[]{row,col});
                    visited[row][col] = true;
                }
                if (zeroFlag && grid[row][col] == 1) zeroFlag = false;
            }
        }
        if (zeroFlag) return 0;

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int res = 0;
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] cell = queue.poll();
                int row = cell[0],col = cell[1];
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol] && grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;
                        queue.add(new int[]{newRow,newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
            res ++;
        }

        for (int[] ints : grid) {
            for (int col = 0; col < n; col++) {
                if (ints[col] == 1) return -1;
            }
        }
        // 解释一下为什么最后是res - 1。
        // 因为初始化找到所有烂橘子的时候，所有开始扩散的时候，这里会用1分钟。逻辑上会用1分钟，其实实际计算是不用的，所以这里减去1。
        return res - 1;
    }

    @Test
    public void test(){
        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        System.out.println(orangesRotting(new int[][]{{0,2}}));
        System.out.println(orangesRotting(new int[][]{{0}}));
        System.out.println(orangesRotting(new int[][]{{0,2,2}}));
    }
}
