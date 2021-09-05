package indi.xm.jy.leetcode.sn.SN1000;

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
    public int orangesRotting(int[][] grid) {
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

    @Test
    public void test(){
//        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
//        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
//        System.out.println(orangesRotting(new int[][]{{0,2}}));
//        System.out.println(orangesRotting(new int[][]{{0}}));
        System.out.println(orangesRotting(new int[][]{{0,2,2}}));
    }
}
