package indi.xm.jy.leetcode.sn.SN0400;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0278
 * @Author: albert.fang
 * @Description: 第一个错误版本
 * @Date: 2021/8/24 17:52
 */
public class SN0278 {
    // 注意：坏的是连续的，不可能存在坏、好的情况。
    public int firstBadVersion(int n) {
        return firstBadVersion(1,n);
    }

    private int firstBadVersion(int start,int end){
        int mid = start + (end - start) / 2;
        // 终止条件
        if (mid == 1 && isBadVersion(mid)){
            return mid;
        }
        else if (isBadVersion(mid) && !isBadVersion(mid-1)) {
            return mid;
        }
        else if (!isBadVersion(mid) && isBadVersion(mid + 1)){
            return mid + 1;
        }
        // 更小问题
        if (isBadVersion(mid) && isBadVersion(mid)){
            return firstBadVersion(start, mid - 1);
        }
        return firstBadVersion(mid + 1, end);
    }

    private boolean isBadVersion(int version){
        return false;
    }

    public static void main(String[] args) {
        System.out.println(2 >> 1);
    }
}
