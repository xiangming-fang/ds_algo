package indi.xm.ds_algo.leetcode.sn.SN0200;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0119
 * @Author: albert.fang
 * @Description: 杨辉三角 II
 * @Date: 2021/9/7 17:31
 */
public class SN0119 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> yh = generate(rowIndex);
        return yh.get(yh.size() - 1);
    }

    private List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(1);
        result.add(one);
        if (numRows == 1){
            return result;
        }
        for (int i = 1; i < numRows; i++) {
            List<Integer> pre = result.get(i - 1);
            List<Integer> list = new ArrayList<>();
            list.add(pre.get(0));
            for (int j = 1; j < i ; j++) {
                list.add(pre.get(j) + pre.get(j - 1));
            }
            list.add(pre.get(pre.size() - 1));
            result.add(list);
        }
        return result;
    }
}
