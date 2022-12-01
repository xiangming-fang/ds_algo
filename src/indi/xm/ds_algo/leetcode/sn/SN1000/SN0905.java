package indi.xm.ds_algo.leetcode.sn.SN1000;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1000
 * @ClassName: SN0905
 * @Author: albert.fang
 * @Description: 905. 按奇偶排序数组
 * @Date: 2022/4/28 17:20
 */
public class SN0905 {

    public int[] sortArrayByParity(int[] nums) {
        // 1、两个指针，right 从 len - 1开始
        // 2、从左到右，遍历nums数组，遍历指针 index
        // 3、如果index位置元素是奇数，那么和right位置交换，然后right --
        // 4、如果index位置元素是偶数，index ++
        int right = nums.length - 1;
        for (int i = 0; i < right; ) {
            if ((nums[i] & 1) == 1){
                swap(nums,i,right--);
            }
            else {
                i ++;
            }
        }
        return nums;
    }

    private void swap(int[] arr,int a,int b){
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

}
