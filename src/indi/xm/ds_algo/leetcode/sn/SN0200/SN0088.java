package indi.xm.ds_algo.leetcode.sn.SN0200;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0088
 * @Author: albert.fang
 * @Description: 合并两个有序数组
 * @Date: 2021/8/25 11:40
 */
public class SN0088 {

    // 双指针
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int oPoint = 0;
        int tPoint = 0;
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            if (tPoint >= n){
                result[i] = nums1[oPoint];
                oPoint++;
            }
            else if (oPoint >= m){
                result[i] = nums2[tPoint];
                tPoint++;
            }
            else if (nums1[oPoint] <= nums2[tPoint]){
                result[i] = nums1[oPoint];
                oPoint++;
            }
            else if (nums1[oPoint] > nums2[tPoint]) {
                result[i] = nums2[tPoint];
                tPoint++;
            }
        }
        System.arraycopy(result,0,nums1,0,result.length);
    }
    @Test
    public void test(){
        merge(new int[]{1,2,3,4,10,11,15},7,new int[]{},0);
    }
}
