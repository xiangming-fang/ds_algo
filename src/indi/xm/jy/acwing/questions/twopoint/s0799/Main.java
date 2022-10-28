package indi.xm.jy.acwing.questions.twopoint.s0799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.twopoint.s0799
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 最长连续不重复子序列
 * @Date: 2022/10/28 10:13
 */
public class Main {


    // 同力扣第三题
    //  a[]：9 3 6 9 5 10 1 2 3
    //       0 1 2 3 4 5 6 7 8
    //  因为数据范围是100000，所以我们这里可以开一个大小为100010的数据来表示
    //  hash[10010] => 下标含义是a[]中元素的值，value表示出现了几次
    //  初始让 i = 0; j = 0，都指向a[] 的第一个元素
    //  i => 含义是连续子序列的右边界
    //  j => 含义是连续子序列的左边界
    // 以i指针为下标，遍历a[],同时修改hash数组，改变元素出现的频次
    // 当出现重复的时候，也就是hash[a[i]] > 1 的时候，那么就需要将j指针右移，右移的过程中，注意释放hash[a[j]]。
    // 一直到j移动到使hash[a[i]] = 1的时候 => 其实这里就是a[i]这个值出现的上一个位置的下一个位置。
    // 比如以上面的例子为例，当i移动到第二个9的时候，hash[9] 就等于 2了，此时需要移动j指针，并且释放j指针元素在hash[]出现的频次
    // 也就是移动到 第一个9出现的位置的后面一个位置 => j = 1

    // n 的范围是10^5
    // 每个数据的大小范围也是10^5
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 用于记录元素值上一次出现的位置
        int[] hash = new int[100010];
        int[] a = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        int res = 0;
        for (int i = 0,j = 0; i < n; i ++){
            hash[a[i]] ++;
            while (j < i && hash[a[i]] > 1) hash[a[j++]] --;
            res = Math.max(res,i - j + 1);
        }
        System.out.println(res);
    }

}
