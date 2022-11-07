package indi.xm.jy.acwing.basic.basicalgo;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.algo.template
 * @ClassName: MergeSort
 * @Author: albert.fang
 * @Description: 归并排序
 * @Date: 2022/10/25 13:00
 */
public class MergeSort {

    // 分治法
    // 确认分界点：mid = l + (r-l)/2
    // 递归(l,mid)、(mid+1,r)
    // 归并左右两个有序数组
    public void mergeSort(int[] arr,int l,int r){
        if ( l >= r ) return;
        int mid = l + (r - l)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid + 1,r);
        int[] tmp = new int[r - l + 1];
        // 归并两个有序数组
        int k = 0,i = l,j = mid + 1;
        while ( i <= mid && j <= r){
            if (arr[i] <= arr[j]) tmp[k++] = arr[i++];
            else tmp[k++] = arr[j++];
        }
        while ( i <= mid ) tmp[k++] = arr[i++];
        while ( j <= r ) tmp[k++] = arr[j++];
        for (i = l; i <= r; i++) arr[i] = tmp[ i - l];
    }
}
