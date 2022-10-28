package indi.xm.jy.acwing.questions.bit.s0801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.bit.s0801
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 二进制中1的个数
 * @Date: 2022/10/28 15:58
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String[] b = br.readLine().split(" ");
        for (int i = 0; i < b.length; i++) {
            a[i] = Integer.parseInt(b[i]);
            System.out.print(getOnes(a[i]) + " ");
        }
    }

    public static int getOnes(int num){
        int lastOne,res = 0;
        while (num != 0){
            lastOne = num & (~num + 1);
            num = num ^ lastOne;
            res ++;
        }
        return res;
    }

    public static int obtainOnes(int num){
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((1 << i & num) == 1 << i) {
                res ++;
            }
        }
        return res;
    }
}
