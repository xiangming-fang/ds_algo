package indi.xm.jy.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0051
 * @Author: albert.fang
 * @Description: N皇后
 * @Date: 2021/11/12 9:43
 */
public class SN0051 {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        ArrayList<String> singleQueen = new ArrayList<String>(){{
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(".");
            }
            for (int i = 0; i < n; i++) {
                add(sb.toString());
            }
        }};
        dfs(n,singleQueen,0);
        return res;
    }

    // n 是 皇后的个数
    // singleQueen 是满足条件的一种做法
    // row 行高，控制递归深度
    private void dfs(int n, ArrayList<String> singleQueen,int row) {

        if (row >= n){
            res.add(new ArrayList<>(singleQueen));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (checkIllegal(singleQueen,i,row)){

                String queen = replace(singleQueen.get(row), i, 'Q');
                singleQueen.set(row,queen);

                dfs(n,singleQueen,row + 1);

                // 回溯
                singleQueen.set(row,replace(singleQueen.get(row), i, '.'));
            }
        }
    }

    // 将 字符串的指定位置替换成指定的字符
    private String replace(String s, int i, char c) {
        int len = s.length();
        String pre = s.substring(0, i);
        String suffix = s.substring(i + 1, len);
        return pre + c + suffix;
    }

    // 合法 true 不合法 false
    // row 是第几行，是由递归控制的
    // col 是第几列，是有for循环控制的
    private boolean checkIllegal(ArrayList<String> singleQueen, int col,int row) {
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
//        System.out.println(replace("....",0,'Q'));
        List<List<String>> lists = solveNQueens(8);
        print(lists);
    }

    private void print(List<List<String>> arr){
        for (List<String> strings : arr) {
            for (String string : strings) {
                System.out.println("[ " + string + " ]");
            }
            System.out.println("");
        }
    }
}
