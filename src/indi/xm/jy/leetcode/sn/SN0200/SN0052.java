package indi.xm.jy.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0052
 * @Author: albert.fang
 * @Description: N皇后 II
 * @Date: 2021/11/19 14:03
 */
public class SN0052 {
    int res = 0;
    public int totalNQueens(int n) {
        ArrayList<String> singleQueen = new ArrayList<String>(){{
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(".");
            }
            for (int i = 0; i < n; i++) {
                add(sb.toString());
            }
        }};
        dfs(n,0,singleQueen);
        return res;
    }

    private void dfs(int n, int row, ArrayList<String> singleQueen) {
        if (row >= n){
            res ++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (checkIllegal(singleQueen,row,col)){
                singleQueen.set(row,replace(singleQueen.get(row),col,'Q'));
                dfs(n,row + 1,singleQueen);
                singleQueen.set(row,replace(singleQueen.get(row),col,'.'));
            }
        }
    }

    // 将字符串target的指定位置index替换成字符c
    private String replace(String target,int index,char c){
        // 将指定index位置替换成 Q
        String pre = target.substring(0, index);
        String suffix = target.substring(index + 1);
        return pre + c + suffix;
    }

    // 合法 true 不合法 false
    // row 是第几行，是由递归控制的
    // col 是第几列，是有for循环控制的
    private boolean checkIllegal(ArrayList<String> singleQueen, int row,int col) {
        // 不合法的三种情况，同一横线，同一列、斜线上
        // 1、同一横线
        if (singleQueen.get(row).contains("Q")) {
            return false;
        }

        // 2、同一列
        for (int r = 0; r < row; r++) {
            if (singleQueen.get(r).charAt(col) == 'Q') {
                return false;
            }
        }

        // 3、是否在斜线上
        // 这里的len就是n皇后的n
        int len = singleQueen.get(0).length();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < len; c++) {
                // 在同一斜线上的判断
                if (singleQueen.get(r).charAt(c) == 'Q' && Math.abs(row - r) == Math.abs(col - c)){
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test(){
//        System.out.println(replace("....", 0,'Q'));
        System.out.println(totalNQueens(8));
    }
}
