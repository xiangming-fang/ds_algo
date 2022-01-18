package indi.xm.jy.leetcode.sn.SN0400;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0373
 * @Author: albert.fang
 * @Description: 查找和最小的K对数字
 * @Date: 2022/1/14 9:15
 */
public class SN0373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        int len1 = nums1.length,start1 = 0;
        int len2 = nums2.length,start2 = 0;
        while (start1 < len1){
            int second = start1 + 1;
            while (start2 < len2){
                int a = nums1[start1] + nums2[start2];
                int b = nums1[start1] + nums2[second];
                if (a < b){
                    ArrayList<Integer> ans = new ArrayList<>();
                    ans.add(nums1[start1]);
                    ans.add(nums2[start2 ++]);
                    res.add(ans);
                }
                else {
                    ArrayList<Integer> ans = new ArrayList<>();
                    ans.add(nums1[start2 ++]);
                    ans.add(nums1[second++]);
                    res.add(ans);
                }
                if (res.size() == k) break;
            }
            start1 ++;
        }
        return res;
    }


    @Test
    public void test(){
        int[] a = {1, 7, 11};
        int[] b = {2,4,6};
        System.out.println(kSmallestPairs(a, b, 3));
    }

}
