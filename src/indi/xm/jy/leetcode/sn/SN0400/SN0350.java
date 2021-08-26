package indi.xm.jy.leetcode.sn.SN0400;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author: albert.fang
 * @date: 2021/4/23 15:59
 * @description: 350. 两个数组的交集 II
 * @description: 给定两个数组，编写一个函数来计算它们的交集，包含重复元素
 */
public class SN0350 {
    public int[] intersect01(int[] nums1, int[] nums2) {
        // key -> num,value -> times
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num,map.get(num) + 1);
            }else {
                map.put(num,1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)){
                list.add(num);
                map.put(num,map.get(num) - 1);
                if (map.get(num) == 0){
                    map.remove(num);
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    // 动态数组
    public int[] intersect02(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            list.add(i);
        }
        for (int i : nums2) {
            if (list.contains((Integer)i)){
                result.add(i);
                list.remove((Integer)i);
            }
        }
        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[i] = result.get(i);
        }
        return ints;
    }

    // hash table
    public int[] intersect03(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length){
            intersect(nums2,nums1);
        }
        int[] res = new int[nums2.length];
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums2) {
            if (map.containsKey(i)){
                map.put(i,map.get(i) + 1);
            }else {
                map.put(i,1);
            }
        }
        for (int i : nums1) {
            if (map.containsKey(i) && map.get(i) != 0){
                res[index] = i;
                map.put(i,map.get(i) - 1);
                index ++;
            }
        }
        return Arrays.copyOfRange(res,0,index);
    }

    // 排序 + 双指针
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[nums2.length];
        int index = 0;
        int first = 0;
        int second = 0;
        while (first < nums1.length && second < nums2.length){
            if (nums1[first] < nums2[second]){
                first ++;
            }
            else if (nums1[first] > nums2[second]){
                second ++;
            }
            else {
                res[index] = nums1[first];
                index ++;
                first ++;
                second ++;
            }
        }
        return Arrays.copyOfRange(res,0,index);
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }
}
