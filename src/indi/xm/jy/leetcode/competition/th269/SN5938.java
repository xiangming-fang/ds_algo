package indi.xm.jy.leetcode.competition.th269;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 5938. 找出数组排序后的目标下标
public class SN5938 {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target){
                continue;
            }
            if (nums[i] > target){
                return res;
            }
            res.add(i);
        }
        return res;
    }
}
