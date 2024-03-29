package indi.xm.ds_algo.leetcode.sn.SN0200;

/**
 * 删除有序数组中的重复项
 */
public class SN0026 {
    public int removeDuplicates(int[] nums) {
        // 不重复元素填写的下标
        int res = 0;
        if (nums.length == 0){
            return res;
        }
        for (int i = 1; i < nums.length; i++) {
            // 后一项和前一项不相等，往res++的位置填入当前遍历到的元素nums[i]
            if (nums[i] != nums[i - 1]){
                res ++;
                nums[res] = nums[i];
            }
        }
        return ++res;
    }
}
