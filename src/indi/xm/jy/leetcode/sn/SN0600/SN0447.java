package indi.xm.jy.leetcode.sn.SN0600;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0447
 * @Author: albert.fang
 * @Description: 回旋镖的数量
 * @Date: 2021/9/13 14:36
 */
public class SN0447 {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int[] p : points) {
            HashMap<Integer, Integer> distance = new HashMap<>();
            for (int[] q : points) {
                int dis = Math.abs((p[0] - q[0]) * (p[0] - q[0])) + Math.abs((p[1] - q[1]) * (p[1] - q[1]));
                distance.put(dis,distance.getOrDefault(dis,0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : distance.entrySet()) {
                Integer value = entry.getValue();
                ans += value * (value - 1);
            }
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
    }
}
