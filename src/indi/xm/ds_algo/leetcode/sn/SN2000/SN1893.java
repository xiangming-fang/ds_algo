package indi.xm.ds_algo.leetcode.sn.SN2000;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: albert.fang
 * @date: 2021/7/23 23:49
 * @description: 1893. 检查是否区域内所有整数都被覆盖
 * @link: https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/
 */
public class SN1893 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        if(ranges == null || ranges.length == 0){
            return false;
        }
        List<Integer> temp = new ArrayList<>();
        for(int[] single : ranges){
            for (int i = single[0]; i <= single[1]; i ++){
                temp.add(i);
            }
        }
        for(int i = left; i <= right; i ++){
            if(!temp.contains(i)){
                return false;
            }
        }
        return true;
    }

    @Test
    public void  isCoveredTest(){
        int[][] ranges = {{1,50}};
        System.out.println(isCovered(ranges, 1, 50));
    }
}
