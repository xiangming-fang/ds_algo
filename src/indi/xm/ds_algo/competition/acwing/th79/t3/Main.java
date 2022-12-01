package indi.xm.ds_algo.competition.acwing.th79.t3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * t3
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        String sNum = br.readLine();
        int[] count = new int[10];
        for (int i = 0; i < n; i++) {
            count[sNum.charAt(i) - '0']++;
        }
        int tmpMaxNum = 0,max = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                tmpMaxNum = i;
                max = count[i];
            }
        }
        if (max >= k) {
            System.out.println(0);
            System.out.println(sNum);
        }else {
            int minFixNum = k - max;
            // 贪心策略是啥呀，妈的，尽力了，尽力了，这个点想不出来
        }

    }

}
