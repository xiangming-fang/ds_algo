package indi.xm.ds_algo.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0039
 * @Author: albert.fang
 * @Description: 组合总和I
 * @Date: 2021/11/10 17:43
 */
public class SN0039 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates,target,0,new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates, int target, int start, ArrayList<Integer> singleCombo) {
        // 大于目标值
        if (getSum(singleCombo) > target){
            return;
        }
        // 等于目标值
        if (getSum(singleCombo) == target){
            // 要new，因为等会要回溯
            res.add(new ArrayList<>(singleCombo));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            singleCombo.add(candidates[i]);
            dfs(candidates,target,i,singleCombo);
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
        //        System.out.println(combinationSum(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
//        System.out.println(combinationSum(new int[]{2,5,2,1,2}, 5));
//        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(combinationSum(new int[]{2,3,5}, 8));
    }
}
