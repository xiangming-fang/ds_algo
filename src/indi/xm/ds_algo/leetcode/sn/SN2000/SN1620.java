package indi.xm.ds_algo.leetcode.sn.SN2000;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN2000
 * @ClassName: SN1620
 * @Author: albert.fang
 * @Description: 1620. 网络信号最好的坐标
 * @Date: 2022/11/2 22:01
 */
public class SN1620 {

    public int[] bestCoordinate(int[][] towers, int radius) {
        double radiusD = radius;
        int[] ans = new int[2];
        int max = 0;
        int x1,y1,x2,y2,xhqd,q;
        int N = 50;
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                x1 = i;
                y1 = j;
                xhqd = 0;
                for (int t = 0; t < towers.length; t++) {
                    x2 = towers[t][0];
                    y2 = towers[t][1];
                    q = towers[t][2];
                    double distance = distance(x1, y1, x2, y2);
                    if (distance <= radiusD) xhqd += Math.floor(q / (1 + distance));
                }
                if (xhqd > max){
                    max = xhqd;
                    ans[0] = x1;
                    ans[1] = y1;
                }
                else if (xhqd == max){
                    if (x1 < ans[0] || (x1 == ans[0] && y1 < ans[1])) {
                        ans[0] = x1;
                        ans[1] = y1;
                    }
                }
            }
        }
        return ans;
    }

    private double distance(int x1,int y1,int x2,int y2){
        return Math.sqrt(Math.pow(Math.abs(x1-x2),2) + Math.pow(Math.abs(y1-y2),2));
    }

    @Test
    public void test(){
        int i = 1;
        System.out.println(i * 1.0);
        System.out.println(distance(0,0,1,1));
    }

}
