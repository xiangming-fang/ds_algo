package indi.xm.ds_algo.acwing.questions.monotonequeue.s0154;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: albert.fang
 * @Description: 滑动窗口，单调栈
 * @Date: 2022/12/5 14:54
 */
public class Main {

    public static void main(String[] args) throws IOException {
        int N = (int)1e6+10;
        int[] q = new int[N];
        int tt = -1,hh = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]),k = Integer.parseInt(s[1]);
        String[] snums = br.readLine().split(" ");
        int[] nums = new int[n];
        // 窗口内最小值
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(snums[i]);
            // 移除不在窗口内的单调队列
            while (tt >= hh && i - q[hh] + 1 > k) hh++;
            // 如果当前值小于等于队尾元素，那么移除队尾
            while (tt >= hh && nums[i] <= nums[q[tt]]) tt--;
            // 将当前元素放入队尾
            q[++tt] = i;
            // 只有当前位置至少为k-1才能说明这个窗口满K个元素，才可以打印
            if (i >= k - 1) System.out.print(nums[q[hh]] + " ");
        }
        System.out.println();
        tt = -1;
        hh = 0;
        for (int i = 0; i < n; i++) {
            while (tt >= hh && i - q[hh] + 1 > k) hh++;
            // 窗口最大值就这里需要做改变
            // 当前元素大于等于队尾，那么队尾移出
            while (tt >= hh && nums[i] >= nums[q[tt]]) tt--;
            q[++tt] = i;
            if (i >= k -1) System.out.print(nums[q[hh]] + " ");
        }
    }
}
