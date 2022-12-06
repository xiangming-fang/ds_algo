package indi.xm.ds_algo.acwing.questions.trie.s0143_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: albert.fang
 * @Description: 最大异或对
 * @Date: 2022/12/6 17:03
 */
public class Main {

    int N = 32 * (int)1e5 + 10;
    int[][] son = new int[N][2];
    int[] cnt = new int[N];
    int idx = 0;

    public void add(String s){
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if (son[cur][num] == 0) son[cur][num] = ++idx;
            cur = son[cur][num];
        }
        cnt[cur] ++;
    }

    // 从字典树中获取某个字符串 使得和 s 构成最大异或值
    public String getXor(String s){
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if (son[cur][1 ^ num] != 0) {
                sb.append('1');
                cur = son[cur][1^num];
            }else {
                sb.append('0');
                cur = son[cur][num];
            }
        }
        return sb.toString();
    }

    public String fillZero(String s){
        int n = 32 - s.length();
        StringBuilder sb = new StringBuilder();
        while (n-- > 0){
            sb.append('0');
        }
        sb.append(s);
        return sb.toString();
    }

    public int binaryToInt(String s){
        int x = 0;
        for (int i = 0; i < 32; i++) {
            if (s.charAt(i) == '1') x += 1 << (31 - i);
        }
        return x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        Main main = new Main();
        for (int i = 0; i < n; i++) {
            main.add(main.fillZero(Integer.toBinaryString(Integer.parseInt(s[i]))));
        }
        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, main.binaryToInt(main.getXor(main.fillZero(Integer.toBinaryString(Integer.parseInt(s[i]))))));
        }
        System.out.println(max);
    }
}
