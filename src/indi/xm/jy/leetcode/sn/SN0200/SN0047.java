package indi.xm.jy.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0047
 * @Author: albert.fang
 * @Description: 全排列II
 * @Date: 2021/11/11 10:49
 */
public class SN0047 {

    List<List<Integer>> res = new ArrayList<>();

    // 这个是用来表示，数组对应位置有没有访问过
    // 也就是数组的该位置元素是否已经放入单个singleCombo中了
    boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,new ArrayList<Integer>());
        return res;
    }

    private void dfs(int[] nums, ArrayList<Integer> singleCombo) {
        if (singleCombo.size() == nums.length){
            // 等会要回溯，所以这里必须要重新new一个
            res.add(new ArrayList<>(singleCombo));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]){
                continue;
            }
            // 去重判断
            if (i > 0 && nums[i] == nums[i-1] && !visited[i - 1]) continue;
            singleCombo.add(nums[i]);
            // 已经将i位置的元素放入单个排列中了，表示该位置已经访问过了
            visited[i] = true;
            dfs(nums,singleCombo);
            // 回溯
            int pendingBt = singleCombo.size() - 1;
            singleCombo.remove(pendingBt);
            // 这里要将回溯的位置元素，访问状态visited[i]改成false;
            visited[i] = false;
        }
    }

    @Test
    public void test(){
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
//                System.out.println(permuteUnique(new int[]{1,2,3}));
    }
}
