package indi.xm.jy.leetcode.competition.weekcompetition.th318;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description:
 * @Date: 2022/10/21 16:26
 */
public class SN0001 {

    // 模拟直接干
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                nums[i] = 2 * nums[i+1];
                nums[i+1] = 0;
            }
        }
        int i = 0,j = 0;
        while ( j < nums.length){
            while (i < nums.length && nums[i] != 0) i++;
            j = i;
            while (j < nums.length && nums[j] == 0) j++;
            if (i < nums.length && j < nums.length){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i ++;
                j ++;
            }
        }
        return nums;
    }

    // [1694,399,832,1758,412,206,272,0,0,0,0,0,0,0]
    @Test
    public void test(){
        int[] ans = applyOperations(new int[]{847,847,0,0,0,399,416,416,879,879,206,206,206,272});
        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}
