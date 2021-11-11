package indi.xm.jy.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0078
 * @Author: albert.fang
 * @Description: 子集
 * @Date: 2021/11/11 16:41
 */
public class SN0078 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            dfs(nums,0,i, new ArrayList<>());
        }
        return res;
    }

    private void dfs(int[] nums,int start, int len,ArrayList<Integer> singleSubSet) {
        if (singleSubSet.size() == len){
            res.add(new ArrayList<>(singleSubSet));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            singleSubSet.add(nums[i]);
            dfs(nums,i + 1,len,singleSubSet);
            // 回溯
            singleSubSet.remove(singleSubSet.size() - 1);
        }
    }

    @Test
    public void test(){
        System.out.println(subsets(new int[]{1, 2, 3}));
        System.out.println(subsets(new int[]{0}));
    }


}
