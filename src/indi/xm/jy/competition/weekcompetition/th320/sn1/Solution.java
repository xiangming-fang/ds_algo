package indi.xm.jy.competition.weekcompetition.th320.sn1;


/**
 * t1
 */
public class Solution {

    // 思路：暴力模拟
    public int unequalTriplets(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) continue;
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[k] == nums[j]) continue;
                    if (nums[k] == nums[i]) continue;
                    ans++;
                }
            }
        }
        return ans;
    }


}
