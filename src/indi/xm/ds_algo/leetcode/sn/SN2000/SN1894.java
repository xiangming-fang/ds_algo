package indi.xm.ds_algo.leetcode.sn.SN2000;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN2000
 * @ClassName: SN1894
 * @Author: albert.fang
 * @Description: 找到需要补充粉笔的学生编号
 * @Date: 2021/9/10 12:36
 */
public class SN1894 {

    // 常规解法，前缀和
    public int chalkReplacer(int[] chalk, int k) {
        int res = 0;
        int sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
            if (sum > k){
                return i;
            }
        }
        int remains = k % sum;
        int[] preSum = new int[chalk.length];
        preSum[0] = chalk[0];
        if (preSum[0] > remains){
            return 0;
        }
        for (int i = 1; i < chalk.length; i++) {
            preSum[i] = preSum[i-1] + chalk[i];
            if (preSum[i] > remains){
                res = i;
                break;
            }
        }
        return res;
    }

    // 前缀和 —— 超出时间限制
    public int chalkReplacer01(int[] chalk, int k) {
        int[] sum = new int[chalk.length];
        int res = 0;
        for (int i = 0; i < chalk.length; i++) {
            if (i == 0){
                sum[i] = sum[chalk.length - 1] + chalk[i];
            }else {
                sum[i] = sum[i - 1] + chalk[i];
            }
            if (sum[i] > k){
                res = i;
                break;
            }
            if (i == chalk.length - 1 && sum[i] <= k){
                i = -1;
            }
        }
        return res;
    }

    @Test
    public void test() throws IOException {
//        System.out.println(chalkReplacer(new int[]{5, 1, 5}, 22));
//        System.out.println(chalkReplacer(new int[]{3,4,1,2}, 25));
        FileReader fr = new FileReader("E:\\IdeaProjects\\leetcode\\src\\indi\\xm\\jy\\leetcode\\test\\SN1894.txt");
        BufferedReader bufferedReader = new BufferedReader(fr);
        String line;
        List<Integer> list = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            for (String s : line.split(",")) {
                int parseInt = Integer.parseInt(s);
                list.add(parseInt);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        System.out.println(chalkReplacer(res, 539095482));
    }
}
