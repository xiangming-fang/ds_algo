package com.xm.jy.leetcode.sn.SN0400;

import java.util.*;

/**
 * @author: albert.fang
 * @date: 2020/9/7 9:58
 * @description: 347.前 K 个高频元素（打卡2020/09/07）
 */
public class SN0347 {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        Arrays.stream(nums).forEach( v -> {
            if (!map.containsKey(v)){
                map.put(v,1);
            }
            else {
                map.put(v,map.get(v) + 1);
            }
        });
        List<Integer> list = sortByValue(map);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i);
        }
        return result;

    }


    public static <K, V extends Comparable<? super V>> List<Integer> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        list.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<K, V> entry : list) {
            result.add((Integer)entry.getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = {1, 1, 1, 2, 2, 3};
        int[] ints1 = topKFrequent(ints, 2);
        for (int i : ints1) {
            System.out.println(i);
        }
    }

}
