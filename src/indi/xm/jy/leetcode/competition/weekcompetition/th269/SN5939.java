package indi.xm.jy.leetcode.competition.weekcompetition.th269;


import java.util.Arrays;
import java.util.HashMap;

// 5939. 半径为 k 的子数组平均值
public class SN5939 {

    // key- 位置，总和
    HashMap<Integer,Long> memo = new HashMap<>();

    public int[] getAverages(int[] nums, int k) {
        int[] res = new int[nums.length];
        if (nums.length <= 2 * k){
            Arrays.fill(res,-1);
            return res;
        }
        for (int i = 0; i < k; i++) {
            res[i] = -1;
            res[nums.length - 1 - i] = -1;
        }

        // 中间部分 [ k ,nums.length - 1 - k]
        for (int i = k; i <= nums.length - 1 - k; i++) {
            if (!memo.containsKey(i - 1)){
                res[i] = getAvg(nums,i - k, i + k,i);

            }
            else {
                memo.put(i,memo.get(i - 1)  + nums[i + k] - nums[i - k - 1]);
                res[i] = (int)(memo.get(i)/ (2 * k + 1));
            }
        }
        return res;
    }

    private int getAvg(int[] nums,int start,int end,int pos){
        long avg = 0;
        for (int i = start; i <= end; i++) {
            avg += nums[i];
        }
        memo.put(pos,avg);
        avg = avg / (end - start + 1);
        return (int)avg;
    }
}
