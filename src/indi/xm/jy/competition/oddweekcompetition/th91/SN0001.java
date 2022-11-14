package indi.xm.jy.competition.oddweekcompetition.th91;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.DoubleConsumer;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description: 不同的平均值数目
 * @Date: 2022/10/21 16:26
 */
public class SN0001 {

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int i = 0,j = nums.length - 1;
        HashSet<Double> set = new HashSet<>();
        while (i < j) set.add((nums[i++] + nums[j--])/2.0);
        return set.size();
    }

}
