package indi.xm.jy.leetcode.sn.SN0600;

import org.junit.Test;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0502
 * @Author: albert.fang
 * @Description: IPO
 * @Date: 2021/9/8 9:57
 */
public class SN0502 {

    // 方法一：排序 + 最大堆
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // 1、创建二维数组，固定profits.length行，2列，每个元素类似一个键值对的形式【1,2】
        int[][] res = new int[profits.length][2];
        for (int i = 0; i < profits.length; i++) {
            res[i][0] = capital[i];
            res[i][1] = profits[i];
        }
        // 2、对其进行排序
        Arrays.sort(res, Comparator.comparingInt(a -> a[0]));
        // 3、基于java类库，创建最大堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b) -> b - a);
        // j 变量控制二维数组的下移
        int j = 0;
        // 最外层的循环是k，因为最多k次
        for (int i = 0; i < k; i++) {
            // 判断 j 下移的过程中是否超过 二维数组 的最大高度
            // 并且判断当前资本 w 是否超过二维数组第一列的值（这个项目所需资本）
            // 4、其实就是为了找到所有在我们资本 w 内 可以投资的项目，然后将可投资的项目收益 放入最大堆中
            while (j < profits.length && res[j][0] <= w ){
                priorityQueue.offer(res[j][1]);
                j ++;
            }
            if (!priorityQueue.isEmpty()){
                // 所出堆的就是最大收益
                int value = priorityQueue.poll();
                w += value;
            }
        }
        return w;
    }

    @Test
    public void test(){
//        System.out.println(findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
//        System.out.println(findMaximizedCapital(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2}));
//        System.out.println(findMaximizedCapital(1, 2, new int[]{1, 2, 3}, new int[]{1, 1, 2}));
//        System.out.println(findMaximizedCapital(1, 0, new int[]{1, 2, 3}, new int[]{1, 1, 2}));
//        System.out.println(findMaximizedCapital(11, 11, new int[]{1, 2, 3}, new int[]{11, 13, 12}));
        System.out.println(findMaximizedCapital(2, 2, new int[]{1,2,3,4,6,5,19}, new int[]{1,1,1,1,2,1,3}));
    }

}
