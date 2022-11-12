package indi.xm.jy.competition.weekcompetition.th315;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th315
 * @ClassName: SN0004_2
 * @Author: albert.fang
 * @Description:
 * @Date: 2022/10/21 16:02
 */
public class SN0004_1 {

    public long countSubarrays(int[] nums, int minK, int maxK) {

        int left = 0;
        int minI = -1,maxI = -1;
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK){
                left = i + 1;
                minI = -1;
                maxI = -1;
                continue;
            }
            if (nums[i] == minK){
                minI = i;
            }
            if (nums[i] == maxK){
                maxI = i;
            }
            if (minI != -1 && maxI != -1){
                res += Math.min(maxI,minI) - left + 1;
            }
        }
        return res;

    }

    @Test
    public void test(){
        System.out.println(countSubarrays(new int[]{1, 3, 5,2,7,5}, 1, 5));
        System.out.println(countSubarrays(new int[]{1,1,1,1}, 1, 1));
    }


}
