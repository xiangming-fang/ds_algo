package indi.xm.jy.acwing.questions.monotonestack.s0131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.monotonestack.s0131
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 直方图中最大的矩形
 * @Date: 2022/11/16 15:37
 */
public class Main {

    // 思路：
    // 1、算出给定直方图的左一小（左边第一个小于当前位置的值，并且计算出小的位置）得到数组ans
    // 2、ans每个位置有两个元素，一个是小的值 minV，一个是小的左边minI
    // 3、如果是-1的话，那么就直接当前 (index + 1) * origin[index]
    // 4、如果不是-1的话，那么就(index - minI + 1) * minV;
    // 5、取上述结果最大值。
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 100010;
        int[] stk = new int[N];
        while (true){
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            if ( n == 0) break;
            int[] origin = new int[n];
            Pair<Integer,Integer>[] ans = new Pair[n];
            int tt = 0;
            for (int i = 1; i <= n; i++) {
                origin[i-1] = Integer.parseInt(s[i]);
            }
            for (int i = 0; i < n; i++) {
                while (tt > 0 && stk[tt] >= origin[i]) tt--;
            }
        }
    }

    static class Pair<K,V>{
        public K k;
        public V v;
    }
}
