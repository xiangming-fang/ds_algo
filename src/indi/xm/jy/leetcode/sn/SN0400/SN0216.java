package indi.xm.jy.leetcode.sn.SN0400;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0216
 * @Author: albert.fang
 * @Description: 组合总和 III
 * @Date: 2021/11/10 18:01
 */
public class SN0216 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(n,k,1,new ArrayList<Integer>());
        return res;
    }

    // k 是递归的最大深度
    private void dfs(int n, int k, int start, ArrayList<Integer> singleCombo) {
        if (singleCombo.size() == k && getSum(singleCombo) == n){
            res.add(new ArrayList<>(singleCombo));
            return;
        }
        if (singleCombo.size() >= k){
            return;
        }
        for (int i = start; i <= 9; i++) {
            singleCombo.add(i);
            dfs(n,k,i + 1,singleCombo);
            // 回溯
            singleCombo.remove(singleCombo.size() - 1);
        }
    }

    private int getSum(ArrayList<Integer> singleCombo){
        int res = 0;
        for (Integer s : singleCombo) {
            res += s;
        }
        return res;
    }

    @Test
    public void test(){
//        System.out.println(combinationSum3(3, 7));
        System.out.println(combinationSum3(3, 9));
    }
}
