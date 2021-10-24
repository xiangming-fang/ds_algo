package indi.xm.jy.leetcode.sn.SN0400;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0229
 * @Author: albert.fang
 * @Description: 求众数 II
 * @Date: 2021/10/22 12:56
 */
public class SN0229 {
    // 方法一：模拟
    public List<Integer> majorityElement01(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int temp : nums) {
            if (!map.containsKey(temp)) {
                map.put(temp, 1);
            } else {
                map.put(temp, map.get(temp) + 1);
            }
        }
        Collector<Map.Entry<Integer, Integer>, ?, Map<Integer, Integer>> filterCondition = Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue);
        Map<Integer, Integer> filterMap = map.entrySet().stream().filter(v -> v.getValue() > nums.length / 3).collect(filterCondition);
        return new ArrayList<>(filterMap.keySet());
    }

    // 方法二：摩尔投票法
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> campA = new ArrayList<>();
        ArrayList<Integer> campB = new ArrayList<>();
        for (int num : nums) {
            // 1、如果num属于a阵营，那么直接加入a阵营
            // 2、如果a阵营为空，那么判断b阵营是否为空，如果b阵营为空，那么num直接加入a阵营。
            // 3、如果a阵营为空，那么判断b阵营是否为空，如果b阵营不为空，并且num不属于b阵营的元素，那么num加入a阵营
            if ((campA.size() == 0 && campB.size() == 0) || (campA.size() == 0 &&  campB.get(0) != num) || (campA.size() != 0 && campA.get(0) == num)){
                campA.add(num);
            }
            // 同上
            else if (campB.size() == 0 || campB.get(0) == num){
                campB.add(num);
            }
            else {
                campA.remove(0);
                campB.remove(0);
            }
        }

        // 最后判断两个阵营人数在nums中出现的次数是否满足 > 1/3
        if (campA.size() != 0){
            Integer campAValue = campA.get(0);
            if (count(nums,campAValue) > nums.length/3) {
                res.add(campAValue);
            }
        }
        if (campB.size() != 0){
            Integer campBValue = campB.get(0);
            if (count(nums,campBValue) > nums.length/3) {
                res.add(campBValue);
            }
        }
        return res;
    }

    // 辅助方法，判断pendingValue在nums中出现的次数
    private int count(int[] nums,int pendingValue){
        int count = 0;
        for (int num : nums) {
            if (num == pendingValue) count ++;
        }
        return count;
    }

    @Test
    public void test(){
        System.out.println(majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}));
        System.out.println(majorityElement(new int[]{3,2,3}));
        System.out.println(majorityElement(new int[]{3}));
        System.out.println(majorityElement(new int[]{2,1,1,3,1,4,5,6}));
        System.out.println(majorityElement(new int[]{1,1,1,2,1,4,2,6,2}));
    }
}
