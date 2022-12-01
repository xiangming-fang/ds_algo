package indi.xm.ds_algo.leetcode.sn.SN0600;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0506
 * @Author: albert.fang
 * @Description: 相对名次
 * @Date: 2021/9/6 19:20
 */
public class SN0506 {
    public String[] findRelativeRanks(int[] score) {
        Integer[] source = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(source,(a,b) -> b - a);
        String[] res = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            int idx = getIdx(source, score[i]);
            if (idx == 0){
                res[i] = "Gold Medal";
            }
            else if (idx == 1){
                res[i] = "Silver Medal";
            }
            else if (idx == 2){
                res[i] = "Bronze Medal";
            }
            else {
                res[i] = (idx + 1) + "";
            }
        }
        return res;
    }

    private int getIdx(Integer[] arr,int target){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{10, 3, 8, 9, 4})));
    }
}
