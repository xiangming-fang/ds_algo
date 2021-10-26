package indi.xm.jy.leetcode.sn.SN0600;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0496
 * @Author: albert.fang
 * @Description: 下一个更大元素 I
 * @Date: 2021/10/26 20:12
 */
public class SN0496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int temp = 0;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]){
                    temp = 1;
                }
                if (temp == 1 && nums2[j] > nums1[i]){
                    res[i] = nums2[j];
                    temp = 2;
                }
            }
            if (temp != 2){
                res[i] = -1;
            }
        }
        return res;
    }
}
