package indi.xm.ds_algo.acwing.questions.regionmerge.s0759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.discretization.s0759
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 格子染色
 * @Date: 2022/11/2 13:45
 */
public class Main {

    // 模拟
    // 将二维每个点在一维层面用唯一标识表示，用set承接
    // 结果：tle
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] axis = br.readLine().split(" ");
            int x1 = Integer.parseInt(axis[0]);
            int y1 = Integer.parseInt(axis[1]);
            int x2 = Integer.parseInt(axis[2]);
            int y2 = Integer.parseInt(axis[3]);
            int max,min;
            if (x1 == x2){
                max = Math.max(y1,y2);
                min = Math.min(y1,y2);
                for (int j = min; j <= max; j++) {
                    set.add(axis[0] + "," + j);
                }
            }
            else if (y1 == y2){
                max = Math.max(x1,x2);
                min = Math.min(x1,x2);
                for (int j = min; j <= max; j++) {
                    set.add(j + "," + axis[1]);
                }
            }
        }
        System.out.println(set.size());
    }
}
