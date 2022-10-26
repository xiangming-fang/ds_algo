package indi.xm.jy.acwing.questions.binarysearch.s0790;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.binarysearch.s0790
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 数的三次方根
 * @Date: 2022/10/26 11:15
 */
public class Main {

    // 数据范围-10000 —— 10000
    // 保留6位小数，经验值：r - l < 10^-7
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double x = Double.parseDouble(br.readLine());
        System.out.printf("%.6f",bs(-10000,10000,x));
    }

    private static double bs(double l, double r, double x) {
        while (r - l > 1e-8){
            double mid = l + (r - l)/2;
            if (Math.pow(mid,3) >= x) r = mid;
            else l = mid;
        }
        return l;
    }
}
