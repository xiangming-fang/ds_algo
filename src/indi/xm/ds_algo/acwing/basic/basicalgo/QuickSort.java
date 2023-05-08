package indi.xm.ds_algo.acwing.basic.basicalgo;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.algo.template
 * @ClassName: QuickSort
 * @Author: albert.fang
 * @Description: 快排算法模板
 * @Date: 2022/10/24 21:29
 */
public class QuickSort {

    // 分治法
    // 确定分界点，通常是arr[l]、arr[r]、arr[l + (r-l)/2]
    // 小于等于 分界点的放左边
    // 大于等于 分界点的放右边
    // 递归排序左边，递归排序右边
    // todo 中间放的并不是等于基值的值，这个算法只是分了两边，而不是三块
    public void quickSort(int[] arr,int l,int r){
        if ( l >= r ) return;
        int i = l - 1,j = r + 1;
        int x = arr[l];
        while ( i < j ){
            do i ++; while (arr[i] < x);
            do j --; while (arr[j] > x);
            if (i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        quickSort(arr,l,j);
        quickSort(arr,j + 1,r);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(new int[]{2,8,7,1,3,5,6,4},0,7);
    }

}
