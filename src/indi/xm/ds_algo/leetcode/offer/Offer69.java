package indi.xm.ds_algo.leetcode.offer;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.offer
 * @ClassName: Offer69
 * @Author: albert.fang
 * @Description: 山峰数组的顶部
 * @Date: 2021/10/14 9:21
 */
public class Offer69 {
    public int peakIndexInMountainArray(int[] arr) {
        return findMax(arr,0,arr.length-1);
    }

    private int findMax(int[] arr, int l, int r) {
        int mid = l + (r - l)/2;
        if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]){
            return mid;
        }
        if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]){
            return findMax(arr,mid,r);
        }
        return findMax(arr,l,mid);
    }

    @Test
    public void test(){
        System.out.println(peakIndexInMountainArray(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19}));
        System.out.println(peakIndexInMountainArray(new int[]{3,4,5,1}));
        System.out.println(peakIndexInMountainArray(new int[]{0,10,5,2}));
        System.out.println(peakIndexInMountainArray(new int[]{1,3,5,4,2}));
        System.out.println(peakIndexInMountainArray(new int[]{0,1,0}));
        System.out.println(peakIndexInMountainArray(new int[]{3,5,3,2,0}));
    }
}
