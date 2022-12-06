package indi.xm.ds_algo.acwing.questions.trie.s0835_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: albert.fang
 * @Description: 数组实现Trie
 * @Date: 2022/12/6 16:33
 */
public class Main {

    int N = (int)1e5 + 10;
    int[][] son = new int[N][26];
    int[] cnt = new int[N];
    int idx;

    public void add(String s){
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a';
            if (son[cur][num] == 0) son[cur][num] = ++idx;
            cur = son[cur][num];
        }
        cnt[cur] ++;
    }

    public int getCount(String s){
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a';
            if (son[cur][num] == 0) return 0;
            cur = son[cur][num];
        }
        return cnt[cur];
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            if ("I".equals(s[0])){
                main.add(s[1]);
            }else {
                System.out.println(main.getCount(s[1]));
            }
        }
    }
}
