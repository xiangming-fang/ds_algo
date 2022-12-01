package indi.xm.ds_algo.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0046
 * @Author: albert.fang
 * @Description: 全排列
 * @Date: 2021/11/11 10:27
 */
public class SN0046 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute01(int[] nums) {
        dfs(nums,new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, ArrayList<Integer> singleCombo) {
        // 单个排列的个数等于所有数字的个数
        if (singleCombo.size() == nums.length){
            res.add(new ArrayList<>(singleCombo));
            return;
        }
        for (int num : nums) {
            // 同一纵列之前添加过这个，此次就不要添加了
            if (singleCombo.contains(num)) {
                continue;
            }
            singleCombo.add(num);
            dfs(nums, singleCombo);
            // 回溯
            singleCombo.remove(singleCombo.size() - 1);
        }
    }


    /******************* 2022-01-04 **************************/

    private boolean[] visited;

    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        dfs(new ArrayList<>(),nums);
        return ret;
    }

    private void dfs(ArrayList<Integer> ans, int[] nums) {
        if (ans.size() == nums.length) {
            ret.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]){
                visited[i] = true;
                ans.add(nums[i]);
                dfs(ans,nums);
                visited[i] = false;
                ans.remove(ans.size() - 1);
            }
        }
    }

    @Test
    public void test(){
        System.out.println(permute(new int[]{1,2,3}));
//        System.out.println(permute(new int[]{1,1,2}));
    }
}
