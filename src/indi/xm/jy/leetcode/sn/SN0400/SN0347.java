package indi.xm.jy.leetcode.sn.SN0400;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: albert.fang
 * @date: 2020/9/7 9:58
 * @description: 347.前 K 个高频元素
 * @link: https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class SN0347 {

    public static int[] solution01(int[] nums, int k) {
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

    /**
     * 基于堆
     * @param nums
     * @param k
     * @return
     */
    public static int[] solution02(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        Arrays.stream(nums).forEach( v -> {
            if (!map.containsKey(v)){
                map.put(v,1);
            }
            else {
                map.put(v,map.get(v) + 1);
            }
        });
        PriorityQueue<Integer> heap = new PriorityQueue<>((v1, v2) -> {
            if (map.get(v1).compareTo(map.get(v2)) > 0) {
                return -1;
            } else if (map.get(v1).compareTo(map.get(v2)) < 0) {
                return 1;
            }
            return 0;
        });
        int[] result = new int[k];
        heap.addAll(map.keySet());
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }


    public static <K, V extends Comparable<? super V>> List<Integer> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        list.sort((o1, o2) -> {
            if (o1.getValue().compareTo(o2.getValue()) > 0){
                return -1;
            }
            else if (o1.getValue().compareTo(o2.getValue()) < 0){
                return 1;
            }
            return 0;
        });

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<K, V> entry : list) {
            result.add((Integer)entry.getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = {2, 2, 3,1, 1, 1,2,2,3,3,3,3,3};
//        int[] ints1 = solution01(ints, 2);
        int[] ints1 = solution02(ints, 2);
        for (int i : ints1) {
            System.out.println(i);
        }
    }

}
