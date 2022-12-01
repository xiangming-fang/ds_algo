package indi.xm.ds_algo.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0090
 * @Author: albert.fang
 * @Description: 子集II
 * @Date: 2021/11/11 16:54
 */
public class SN0090 {

    List<List<Integer>> res = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        res.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            dfs(nums,0,i,new ArrayList<>());
        }
        return res;
    }

    private void dfs(int[] nums, int start, int len, ArrayList<Integer> singleSubSet) {
        if (len == singleSubSet.size()){
            res.add(new ArrayList<>(singleSubSet));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
            singleSubSet.add(nums[i]);
            visited[i] = true;
            dfs(nums,i + 1,len,singleSubSet);
            // 回溯
            singleSubSet.remove(singleSubSet.size() - 1);
            visited[i] = false;
        }
    }

    @Test
    public void test(){
//        System.out.println(subsetsWithDup(new int[]{1, 1, 1, 2}));
//        System.out.println(subsetsWithDup(new int[]{1,2,2}));
        System.out.println(subsetsWithDup(new int[]{0}));
    }
}
