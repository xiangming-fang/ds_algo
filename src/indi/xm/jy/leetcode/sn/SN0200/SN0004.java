package indi.xm.jy.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0004
 * @Author: albert.fang
 * @Description: 4. 寻找两个正序数组的中位数
 * @Date: 2022/5/30 16:01
 */
public class SN0004 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if ((len & 1) == 0){
            return (findKthNum2(nums1,nums2,len/2) + findKthNum2(nums1,nums2,len/2 + 1))/2;
        }
        return findKthNum2(nums1,nums2,len/2 + 1);
    }

    // nums1、nums2是有序数组
    // 找到数组nums1和nums2中第k个小的数字 并且 k 合法
    public double findKthNum(int[] nums1,int[] nums2,int k){
        int[] merge = new int[nums1.length + nums2.length];
        System.arraycopy(nums1,0,merge,0,nums1.length);
        System.arraycopy(nums2,0,merge,nums1.length, nums2.length);
        Arrays.sort(merge);
        return merge[k - 1];
    }

    public double findKthNum2(int[] nums1,int[] nums2,int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int p1 = 0,p2 = 0;
        while (maxHeap.size() < k){
            if (indexIsLegal(p1,nums1) && !indexIsLegal(p2,nums2)){
                maxHeap.offer(nums1[p1++]);
            }
            else if (!indexIsLegal(p1,nums1) && indexIsLegal(p2,nums2)){
                maxHeap.offer(nums2[p2++]);
            }
            else {
                if (nums1[p1] <= nums2[p2]){
                    maxHeap.offer(nums1[p1++]);
                }
                else {
                    maxHeap.offer(nums2[p2++]);
                }
            }
        }
        return maxHeap.peek();
    }

    // 下标是否合法
    public boolean indexIsLegal(int index,int[] arr){
        return index >= 0 && index < arr.length;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        boolean flag = ((nums1.length + nums2.length) & 1) == 0;
        int avgLen = flag ? (nums1.length + nums2.length) / 2 : (nums1.length + nums2.length) / 2 + 1;
        for (int i : nums1) {
            if (maxHeap.size() < avgLen){
                maxHeap.add(i);
            }else {
                if (maxHeap.peek() >= i){
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(i);
                }else {
                    minHeap.add(i);
                }
            }
        }
        for (int i : nums2) {
            if (maxHeap.peek() >= i){
                minHeap.add(maxHeap.poll());
                maxHeap.add(i);
            }else {
                minHeap.add(i);
            }
        }
        if (flag){
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }

    @Test
    public void test(){
        System.out.println(findMedianSortedArrays2(new int[]{1, 3}, new int[]{2, 3}));
    }
}
