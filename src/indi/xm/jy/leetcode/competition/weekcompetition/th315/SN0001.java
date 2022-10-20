package indi.xm.jy.leetcode.competition.weekcompetition.th315;

public class SN0001 {
    public int findMaxK(int[] nums) {
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] + nums[j] == 0) {
                    max = Math.max(Math.abs(nums[i]), max);
                    break;
                }
            }
        }
        return max;
    }
}
