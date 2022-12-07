package indi.xm.ds_algo.acwing.questions.uf.s0837;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @Author: albert.fang
 * @Description: 连通块中点的数量
 * @Date: 2022/12/7 15:18
 */
public class Main {

    int N = (int)1e5 + 10;

    int[] p = new int[N];
    int[] size = new int[N];


    public void init(){
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x){
        while (x != p[x]) x = p[x];
        return p[x];
    }

    public void union(int a,int b){
        int aRoot = find(a);
        int bRoot = find(b);
        // 已经处于同一个集合，必须再操作
        if (aRoot == bRoot) return;
        size[bRoot] += size[aRoot];
        p[aRoot] = bRoot;
    }

    public boolean isConnected(int a,int b){
        return find(a) == find(b);
    }

    public int count(int a){
        return size[find(a)];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        Main main = new Main();
        main.init();
        while (m -- > 0){
            String[] op = br.readLine().split(" ");
            if ("C".equals(op[0])) {
                int a = Integer.parseInt(op[1]);
                int b = Integer.parseInt(op[2]);
                main.union(a,b);
            }
            else if ("Q1".equals(op[0])){
                int a = Integer.parseInt(op[1]);
                int b = Integer.parseInt(op[2]);
                if (main.isConnected(a,b)) System.out.println("Yes");
                else System.out.println("No");
            }
            else {
                System.out.println(main.count(Integer.parseInt(op[1])));
            }
        }
    }
}
