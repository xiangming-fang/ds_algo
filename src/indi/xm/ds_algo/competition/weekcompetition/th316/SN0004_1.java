package indi.xm.ds_algo.competition.weekcompetition.th316;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th316
 * @ClassName: SN0004_1
 * @Author: albert.fang
 * @Description: 使数组相似的最少操作次数
 * @Date: 2022/10/25 17:00
 */
public class SN0004_1 {

    // 优化，这题的数据都是正数，所以我们可以将nums和target的奇数和偶数用正负分开
    // 若为奇数则去相反数
    public long makeSimilar(int[] nums, int[] target) {
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) nums[i] = -nums[i];
        }
        for (int i = 0; i < target.length; i++) {
            if ((target[i] & 1) == 1) target[i] = -target[i];
        }
        Arrays.sort(nums);
        Arrays.sort(target);
        for (int i = 0; i < nums.length; i++) {
            ans += Math.abs(nums[i] - target[i]);
        }
        return ans / 4;
    }

}
