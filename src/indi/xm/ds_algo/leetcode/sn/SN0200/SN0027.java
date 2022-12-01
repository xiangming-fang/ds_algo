package indi.xm.ds_algo.leetcode.sn.SN0200;

/**
 * 移除元素
 */
public class SN0027 {
    public int removeElement(int[] nums, int val) {
        int res = 0;
        if (nums.length == 0) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[res ++] = nums[i];
            }
        }
        return res;
    }
}
