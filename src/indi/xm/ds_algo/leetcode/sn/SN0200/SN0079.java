package indi.xm.ds_algo.leetcode.sn.SN0200;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0079
 * @Author: albert.fang
 * @Description: 单词搜索
 * @Date: 2021/11/16 20:03
 */
public class SN0079 {

    // 用来判断是否访问过了
    boolean[][] visited;

    // 上下左右四个方向
    int[][] direction = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    // board 有几行
    int rows;

    // board 有几列
    int cols;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];
        // 每个位置都 回溯 一遍
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board,i,j,word,0)) {
                    return true;
                }
            }
        }
        // 每个位置回溯之后还是没找到符合的，那么直接返回false
        return false;
    }

    // row ,col 表示从那个位置开始回溯递归的
    private boolean dfs(char[][] board, int row, int col, String word, int index) {

        // index 控制找到的递归深度
        if (index == word.length() - 1){
            System.out.println("找到了~~~");
            return word.charAt(index) == board[row][col];
        }
        System.out.println("比较 " + board[row][col]);
        if (word.charAt(index) == board[row][col]){
            visited[row][col] = true;
            for (int i = 0; i < direction.length; i++) {
                int newRow = row + direction[i][0];
                int newCol = col + direction[i][1];
                // 新位置合法，并且没有使用过
                if (isValidPosition(newRow,newCol) && !visited[newRow][newCol]) {
                    if (dfs(board,newRow,newCol,word,index + 1)) {
                        return true;
                    }
                }
            }
            visited[row][col] = false;
        }
        System.out.println(board[row][col] + " 和 " + word.charAt(index) + " 不相等");
        return false;
    }

    // 根据传进来的row,col判断这个位置是否合法
    private boolean isValidPosition(int row,int col){
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    @Test
    public void test(){
//        StringUtils.replaceChar("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]",
//                new char[]{'[',']','\"'},new char[]{'{','}','\''});
//        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED"));
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        char[][] board = {{'A','b','c'}};
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];
        System.out.println(dfs(board,0,0,"ABFCC",0));
    }
}
