package indi.xm.ds_algo.leetcode.Interview;

import java.util.PriorityQueue;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.Interview
 * @ClassName: Interview1714
 * @Author: albert.fang
 * @Description: 最小的K个数
 * @Date: 2021/9/3 9:39
 */
public class Interview1714 {
    // 最小堆
    public int[] smallestK01(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int s : arr) {
            pq.offer(s);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    // 快排
    public int[] smallestK(int[] arr, int k) {
        quickSort(arr,0,arr.length - 1);
        int[] res = new int[k];
        System.arraycopy(arr,0,res,0,res.length);
        return res;
    }

    private void quickSort(int[] arr,int left,int right){
        if (left >= right){
            return;
        }
        int start = left;
        int end = right;
        int cardinalNum = arr[left];
        while (left < right){
            if (arr[left] > cardinalNum && arr[right] < cardinalNum){
                swap(arr,left,right);
            }
            if (arr[left] <= cardinalNum){
                left ++;
            }
            if (arr[right] >= cardinalNum){
                right --;
            }
        }
        if (arr[left] < arr[start]){
            swap(arr,start,left);
            quickSort(arr,start,left - 1);
            quickSort(arr,left + 1,end);
        }
        else {
            quickSort(arr,start,left - 1);
            quickSort(arr,left,end);
        }
    }

    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp;
    }
}
