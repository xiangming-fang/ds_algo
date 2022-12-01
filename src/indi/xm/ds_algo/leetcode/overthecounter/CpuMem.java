package indi.xm.ds_algo.leetcode.overthecounter;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.overthecounter
 * @ClassName: CpuMem
 * @Author: albert.fang
 * @Description: cpu 测试三级缓存策略对内存读取的影响
 * @Date: 2022/1/19 22:56
 */
public class CpuMem {
    public static void main(String[] args) {
        int[][] arr = new int[10000][10000];
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
//                System.out.println(arr[i][j]);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("行优先读取总花费：" + (end - start) + "ms");

        long start1 = System.currentTimeMillis();
        for (int j = 0; j < arr[0].length; j++) {
            for (int i = 0; i < arr.length; i++) {
//                System.out.println(arr[i][j]);
            }
        }
        long end1 = System.currentTimeMillis();
        System.out.println("列优先读取总共花费：" + (end1 - start1) + "ms");
    }
}
