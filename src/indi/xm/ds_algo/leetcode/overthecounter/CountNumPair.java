package indi.xm.ds_algo.leetcode.overthecounter;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.overthecounter
 * @ClassName: CountNumPair
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/12 20:03
 */
public class CountNumPair {

    List<List<Integer>> res = new ArrayList<>();

    public int getNumPairs(int[] firstLine,int[] sendLine){
        int left = firstLine[1];
        int right = firstLine[2];
        dfs(sendLine,0,left,right,new ArrayList<>());
        return res.size();
    }

    private void dfs(int[] sendLine,int start, int left, int right,ArrayList<Integer> singleCombo) {
        int sum = getSum(singleCombo);
        if (singleCombo.size() >= 2 && sum >= left && sum <= right){
            res.add(new ArrayList<>(singleCombo));
            return;
        }
        if (singleCombo.size() >= 2){
            return;
        }
        for (int i = start; i < sendLine.length; i++) {
            singleCombo.add(sendLine[i]);
            dfs(sendLine,i + 1,left,right,singleCombo);
            // 回溯
            singleCombo.remove(singleCombo.size() - 1);
        }
    }

    private int getSum(ArrayList<Integer> singleCombo){
        int sum = 0;
        for (Integer integer : singleCombo) {
            sum += integer;
        }
        return sum;
    }

    @Test
    public void test(){
        System.out.println(getNumPairs(new int[]{3, 4, 7}, new int[]{5, 1, 2}));
    }
}
