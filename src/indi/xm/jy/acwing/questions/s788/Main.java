package indi.xm.jy.acwing.questions.s788;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.s788
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 逆序对个数
 * @Date: 2022/10/25 13:47
 */
public class Main {

    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] strs = br.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        System.out.print(res);
    }
}
