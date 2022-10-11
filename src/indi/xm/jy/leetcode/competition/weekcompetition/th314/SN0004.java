package indi.xm.jy.leetcode.competition.weekcompetition.th314;

import java.util.ArrayList;

public class SN0004 {

    int count = 0;
    int r,c,k;

    public int numberOfPaths(int[][] grid, int k) {
        r = grid.length;
        c = grid[0].length;
        this.k = k;
        dfs(grid,0,0,new ArrayList<>());
        return count;
    }

    public void dfs(int[][] grid, int row, int col, ArrayList<Integer> path){
        if (!isTrue(grid,row,col)){
            path.add(0);
            return;
        }
        path.add(grid[row][col]);
        if (row == r - 1 && col == c - 1){
            if (isMod(path)) {
                count ++;
            }
            return;
        }
        dfs(grid,row,col + 1,path);
        path.remove(path.size() - 1);
        dfs(grid,row + 1,col,path);
        path.remove(path.size() - 1);
    }

    // true - 合法
    public boolean isTrue(int[][] grid,int row,int col){
        return row >= 0 && row <= r - 1 && col >=0 && col <= c - 1;
    }

    // true - 可以整除
    public boolean isMod(ArrayList<Integer> path){
        long sum = 0;
        for (Integer integer : path) {
            sum += integer;
        }
        return (sum % (100000007) % k) == 0;
    }

}
