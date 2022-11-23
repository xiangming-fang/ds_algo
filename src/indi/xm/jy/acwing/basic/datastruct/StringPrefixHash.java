package indi.xm.jy.acwing.basic.datastruct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.basic.datastruct
 * @ClassName: StringPrefixHash
 * @Author: albert.fang
 * @Description: 字符串哈希：字符串前缀哈希
 * @Date: 2022/11/23 15:07
 */
public class StringPrefixHash {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        long[] h = new long[n + 1];
        int P = 13331;
        long mod = Long.MAX_VALUE;
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            h[i+1] = (h[i] * P) % mod + str.charAt(i);
        }
        while (m -- > 0){
            String[] region = br.readLine().split(" ");
            int l1 = Integer.parseInt(region[0]);
            int r1 = Integer.parseInt(region[1]);
            int l2 = Integer.parseInt(region[2]);
            int r2 = Integer.parseInt(region[3]);
            long h1 = (long)(h[r1] - h[l1 - 1] * Math.pow(P, r1 - l1 + 1));
            long h2 = (long)(h[r2] - h[l2 - 1] * Math.pow(P, r2 - l2 + 1));
            if (h1 == h2) System.out.println("Yes");
            else System.out.println("No");
        }
    }

}
