package indi.xm.jy.leetcode.sn.SN0200;

import java.util.HashMap;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0001_1
 * @Author: albert.fang
 * @Description: 两数之和
 * @Date: 2022/5/17 15:27
 */
public class SN0001_1 {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        // key -> 值，value -> index
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ret[0] = i;
                ret[1] = map.get(target - nums[i]);
            }
            else {
                map.put(nums[i],i);
            }
        }
        return ret;
    }
}
