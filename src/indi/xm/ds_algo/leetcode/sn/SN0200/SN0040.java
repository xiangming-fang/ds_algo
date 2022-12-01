package indi.xm.ds_algo.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0040
 * @Author: albert.fang
 * @Description: 组合综合II
 * @Date: 2021/11/10 16:25
 */
public class SN0040 {

    List<List<Integer>> res = new ArrayList<>();

//    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        used = new boolean[getMax(candidates)];
        Arrays.sort(candidates);
        dfs(candidates,target,0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates, int target, int start, ArrayList<Integer> singleCombo) {
        // 找到了
        if (getSum(singleCombo) == target){
//            if (!isDuplicated(singleCombo)){
                // 因为等会要回溯，所以这里得新new一个
                res.add(new ArrayList<>(singleCombo));
//            }
            return;
        }
        // 如果 singleCombo 的size == candidates了，那么证明没有找到,已经到达最深的递归了，candidates里没有元素了
        if (singleCombo.size() == candidates.length){
            return;
        }
        // 如果已经大于target了，那么就不必再递归下层了
        if (getSum(singleCombo) >= target){
            return;
        }
        // 对单层的遍历
        for (int i = start; i < candidates.length; i++) {
            singleCombo.add(candidates[i]);
            dfs(candidates,target,i + 1,singleCombo);
            // 回溯
            singleCombo.remove(singleCombo.size() - 1);
            // 前一个和后一个比较 说明这个分支走过了
            while (i + 1 < candidates.length && candidates[i] == candidates[i+1]){
                i++;
            };
        }

    }

    private int getSum(ArrayList<Integer> singleCombo){
        int res = 0;
        for (Integer s : singleCombo) {
            res += s;
        }
        return res;
    }

    private int getMax(int[] array){
        int res = -1;
        for (int i : array) {
            res = Math.max(i,res);
        }
        return res;
    }

    // res 里是否存在了相同数字的组合
    // false 不存在，true 存在了
    private boolean isDuplicated(ArrayList<Integer> singleCombo){
        HashMap<Integer, Integer> pendingCompare = new HashMap<>();
        for (Integer integer : singleCombo) {
            pendingCompare.put(integer,pendingCompare.getOrDefault(integer,0) + 1);
        }
        for (List<Integer> re : res) {
            HashMap<Integer, Integer> tempHashMap = new HashMap<>();
            for (Integer integer : re) {
                tempHashMap.put(integer,tempHashMap.getOrDefault(integer,0) + 1);
            }
            AtomicInteger count = new AtomicInteger(tempHashMap.size());
            pendingCompare.forEach((k,v) -> {
                if (Objects.equals(tempHashMap.get(k), v)) {
                    count.getAndDecrement();
                }
            });
            if (count.get() == 0){
                return true;
            }
        }
        return false;
    }

    @Test
    public void test(){
//        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
//        System.out.println(combinationSum2(new int[]{2,5,2,1,2}, 5));
        System.out.println(combinationSum2(new int[]{2,2,2}, 2));
    }
}
