package indi.xm.jy.leetcode.sn.SN1000;

import org.junit.Test;

/**
 * @ProjectName:    leetcode
 * @Package:        indi.xm.jy.leetcode.sn.SN1000
 * @ClassName:      SN0668
 * @Author:     albert.fang
 * @Description: 668. 乘法表中第k小的数
 * @Date:    2022/5/18 8:21
 */
public class SN0668 {

    public int findKthNumber(int m, int n, int k) {
        int left = 1,right = m * n;
        while (left < right){
            int mid = left + ((right - left) >> 1);
            if (countLessTNums(m,n,mid) >= k) {
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    // 在 m * n 的乘法表矩阵中，小于等于t的有几个数
    private int countLessTNums(int m,int n,int t){
        int r = m,c = 1,ans = 0;
        while (r > 0 && c <= n){
            if (r * c <= t){
                ans += r;
                c ++;
            }else {
                r --;
            }
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(countLessTNums(4, 4, 12));
        System.out.println(findKthNumber(45, 12, 471));
    }

}
