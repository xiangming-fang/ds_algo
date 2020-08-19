package com.xm.jy.leetcode.doing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: albert.fang
 * @date: 2020/7/31 18:05
 * @description: 面试题 08.03. 魔术索引
 * @description: 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，
 * 编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。
 * 若有多个魔术索引，返回索引值最小的一个。
 *
 */
public class FindMagicIndex {
    public int findMagicIndex(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]){
                list.add(i);
            }
        }
        if (list.size() != 0){
            list.sort(Integer::compareTo);
            return list.get(0);
        }
        return -1;
    }
}
