package indi.xm.ds_algo.acwing.questions.bigint.s0793;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.bigint.s0793
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 高精度乘法
 * @Date: 2022/10/27 11:13
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        int second = Integer.parseInt(br.readLine());
        ArrayList<Integer> a = new ArrayList<>();
        int i = first.length() - 1;
        while (i >=0 ) a.add(first.charAt(i--) - '0');
        ArrayList<Integer> ans = mul(a,second);
        i = ans.size() - 1;
        while (i >= 0) System.out.print(ans.get(i--));
    }

    private static ArrayList<Integer> mul(ArrayList<Integer> a, int B) {
        int tmp = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < a.size() || tmp != 0; i++) {
            if (i < a.size() ) tmp += a.get(i) * B;
            ans.add(tmp % 10);
            tmp /= 10;
        }
        while(ans.size() > 1 && ans.get(ans.size() - 1) == 0) ans.remove(ans.size() - 1);
        return ans;
    }
}
