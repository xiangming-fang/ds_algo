package indi.xm.ds_algo.acwing.questions.uf.s0836;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: albert.fang
 * @Description: 合并集合
 * @Date: 2022/12/6 18:37
 */
public class Main {

    static class UF{
        int N = (int)1e5 + 10;
        // 下标表示数
        // 数组具体值表示集合id
        int[] set = new int[N];

        public UF(){
            for (int i = 0; i < N; i++) {
                set[i] = i;
            }
        }

        // 表示将数a和b放在一个集合中
        // 将a数集合id改成b数集合id
        public void union(int a,int b){
            int setAId = set[a];
            int setBId = set[b];
            for (int i = 0; i < N; i++) {
                if (set[i] == setAId) set[i] = setBId;
            }
        }

        // 两个数是否在同一个集合中
        public boolean isConnected(int a,int b){
            return set[a] == set[b];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] f = br.readLine().split(" ");
        int n = Integer.parseInt(f[0]);
        int m = Integer.parseInt(f[1]);
        UF uf = new UF();
        while (m-- > 0){
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[1]);
            int b = Integer.parseInt(s[2]);
            if ("M".equals(s[0])){
                uf.union(a,b);
            }else {
                if (uf.isConnected(a,b)) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }
}
