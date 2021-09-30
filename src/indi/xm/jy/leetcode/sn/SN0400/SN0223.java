package indi.xm.jy.leetcode.sn.SN0400;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0223
 * @Author: albert.fang
 * @Description: 矩形面积
 * @Date: 2021/9/30 9:34
 */
public class SN0223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // 求两个矩形在x轴方向的重合区域
        int x = Math.max(0,Math.min(bx2,ax2) - Math.max(bx1,ax1));
        // 求两个矩形在y轴方向的重合区域
        int y = Math.max(0,Math.min(by2,ay2) - Math.max(by1,ay1));
        return (ax2 - ax1) * (ay2 - ay1) - (x * y) + (bx2 - bx1) * (by2 - by1);
    }
}
