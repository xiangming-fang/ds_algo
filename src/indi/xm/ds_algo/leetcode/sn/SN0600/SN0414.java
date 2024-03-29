package indi.xm.ds_algo.leetcode.sn.SN0600;

import indi.xm.ds_algo.leetcode.sort.QuickSort;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

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

    // 2021 10 06 打卡
    public int thirdMax01(int[] nums){
        Integer[] res = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(res, Collections.reverseOrder());
        int count = 1;
        for (int i = 1; i < res.length; i++) {
            if (!Objects.equals(res[i], res[i - 1])){
                count ++;
                if (count == 3){
                    return res[i];
                }
            }
        }
        return res[0];
    }

    @Test
    public void test(){
//        System.out.println(thirdMax(new int[]{1, 2, 3}));
//        System.out.println(thirdMax(new int[]{1, 2}));
//        System.out.println(thirdMax(new int[]{1, 2,2,3}));
//        System.out.println(thirdMax01(new int[]{3,2,1}));
//        System.out.println(thirdMax01(new int[]{1,2}));
//        System.out.println(thirdMax01(new int[]{-2147483648,1,1}));
//        System.out.println(thirdMax01(new int[]{-2147483648,-2147483648,-2147483648,-2147483648,1,1,1}));
        Integer i = -2147483648;
        Integer j = -2147483648;
        System.out.println(i == j);
    }
}
