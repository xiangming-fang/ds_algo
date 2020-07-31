package com.xm.jy.leetcode.util;

import java.util.Arrays;

/**
 * @author: albert.fang
 * @date: 2020/7/22 15:11
 * @description: 刷题时经常用到的方法，封装
 */
public class LeetCodeUtil<T> {

    public static <T> T[] mergeTwoArrays(T[] array1,T[] array2){
        T[] result = Arrays.copyOf(array1, array1.length + array2.length);

        System.arraycopy(array2, 0, result, array1.length, array2.length);

        return result;
    }
}
