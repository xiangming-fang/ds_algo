package indi.xm.ds_algo.acwing.questions.twopoint.s1575;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.monotonestack.s1575
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 盛水最多的容器
 * @Date: 2022/11/17 14:09
 */
public class Main {

    // 思路：双指针，碰撞指针
    // 1、定义左指针l指向数组左端，r指向数组右端。
    // 2、对应的origin[l] < origin[r] 则左指针 l++.否则 r--。
    // 3、l>=r则停止，迭代每步找出最大值。


    // 可行性分析：
    // 1、盛水最多容器肯定是在两个指针之间。
    // 2、所以我们可以定义两个指针，可是为什么当谁更小就移动谁呢？
    // 3、因为我们的目的是找更大、更高的边界。
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] origin = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            origin[i] = Integer.parseInt(s[i]);
        }
        int max = 0;
        int l = 0, r = n-1;
        while (l < r){
            max = Math.max(max,(r-l) * Math.min(origin[l],origin[r] ));
            // 谁小移动谁
            if (origin[l] > origin[r]) r--;
            else l++;
        }
        System.out.println(max);
    }
}
