package indi.xm.ds_algo.leetcode.sn.SN0400;

import java.util.TreeSet;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0217
 * @Author: albert.fang
 * @Description: 存在重复元素
 * @Date: 2021/8/24 16:00
 */
public class SN0217 {
    public boolean containsDuplicate(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

}
