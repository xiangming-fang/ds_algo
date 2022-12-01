package indi.xm.ds_algo.leetcode.sn.SN0400;

import indi.xm.ds_algo.leetcode.util.ArrayUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0215
 * @Author: albert.fang
 * @Description: 215. 数组中的第K个最大元素
 * @Date: 2021/12/15 15:35
 */
public class SN0215 {

    // 最大堆
    public int findKthLargest(int[] nums, int k) {
        if (k < 0 || k > nums.length){
            return 0;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        for (int num : nums) {
            maxHeap.add(num);
        }
        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        return maxHeap.poll();
    }

    // 排序
    public int findKthLargest01(int[] nums, int k) {
//        Arrays.sort(nums);
        quickSort(nums,-1,nums.length);
        return nums[nums.length - k];
    }

    // 快排 左开右开
    private void quickSort(int[] arr,int left,int right){
        if (right - left <= 2){
            return;
        }
        // 保存左右边界副本
        int copyLeft = left;
        int copyRight = right;
        // 选取数组的第一个元素位置
        int cur = left + 1;
        // 选取第一个部分数组的第一个位置为基值
        int pivot = arr[cur];
        while (cur < right){
            if (arr[cur] == pivot){
                cur ++;
            }
            else if (arr[cur] > pivot){
                swap(arr,cur,--right);
            }
            else if (arr[cur] < pivot){
                swap(arr,cur++,++left);
            }
        }
        quickSort(arr,copyLeft,left + 1);
        quickSort(arr,right - 1,copyRight);
    }

    private void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    @Test
    public void test(){
        for (int i = 0; i < 1000; i++) {
            if (!detector()) {
                throw new RuntimeException("快排错误");
            }
        }
        System.out.println("快排正确");
//        int[] ints = {1, 3, 5, 2, 8, 7};
//        quickSort(ints,-1,ints.length);
//        System.out.println(Arrays.toString(ints));
    }

    // 对数器 - 递归归并
    private boolean detector(){
        int[] ints = ArrayUtil.generatorArray();
        int[] ans = new int[ints.length];
        System.arraycopy(ints,0,ans,0,ints.length);
        quickSort(ints,-1,ints.length);
        Arrays.sort(ans);
        return ArrayUtil.isEquals(ints, ans);
    }

}
