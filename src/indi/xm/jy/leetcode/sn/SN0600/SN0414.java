package indi.xm.jy.leetcode.sn.SN0600;

import indi.xm.jy.leetcode.sort.QuickSort;
import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0414
 * @Author: albert.fang
 * @Description: 第三大的数
 * @Date: 2021/9/6 19:12
 */
public class SN0414 {
    // 排序之后取第三大的数
    public int thirdMax(int[] nums) {
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums);
        int count = 1;
        for (int i = nums.length - 2; i >= 0 ; i--) {
            if (nums[i] != nums[i + 1]){
                count ++;
                if (count == 3){
                    return nums[i];
                }
            }
        }
        return nums[nums.length - 1];
    }

    @Test
    public void test(){
        System.out.println(thirdMax(new int[]{1, 2, 3}));
        System.out.println(thirdMax(new int[]{1, 2}));
        System.out.println(thirdMax(new int[]{1, 2,2,3}));
    }
}
