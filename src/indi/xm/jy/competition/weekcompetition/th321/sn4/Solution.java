package indi.xm.jy.competition.weekcompetition.th321.sn4;

/**
 * t4
 */
public class Solution {


    public int countSubarrays(int[] nums, int k) {

        int ki = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                ki = i;
                break;
            }
        }
        if (ki == -1) return -1;
        int i = ki - 1,j = ki + 1;
        int small = 0,big = 0;
        int ans = 1;
        while (i > 0 ){
            if (nums[i--] < k){
                small++;
                if (big == small || big == small + 1) ans++;
            }
            else {
                big ++;
                if (big == small || big == small + 1) ans++;
            }
        }
        int lsmall = small,lbig = big;
        small = 0;big = 0;
        while (j < nums.length){
            if (nums[j++] > k) {
                big++;
                if (big == small || big == small + 1) ans++;
            }else {
                small ++;
                if (big == small || big == small + 1) ans++;
            }
        }
        j = ki + 1;
        big = lbig;
        small = lsmall;
        while (j < nums.length){
            if (nums[j++] > k) {
                big++;
                if (big == small || big == small + 1) ans++;
            }else {
                small ++;
                if (big == small || big == small + 1) ans++;
            }
        }
        return ans;
    }


}
