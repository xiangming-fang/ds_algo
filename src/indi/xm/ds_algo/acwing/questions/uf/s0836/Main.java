package indi.xm.ds_algo.acwing.questions.uf.s0836;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: albert.fang
 * @Description: 合并集合
 * @Date: 2022/12/6 18:37
 */
public class Main {

    int N = (int)1e5 + 10;
    int[] p = new int[N];

    // 找到a所处的集合编号
    public int find(int a){
        // 不是根节点的话，一直往上找
        while(a != p[a]) a = p[a];
        return p[a];
    }

    // 合并a，b两个元素所处的集合
    public void union(int a,int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot != bRoot) p[aRoot] = bRoot;
    }

    // 看元素a和b是否在同一个集合中
    public boolean isConnected(int a,int b){
        return find(a) == find(b);
    }

    public void init(){
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] f = br.readLine().split(" ");
        int n = Integer.parseInt(f[0]);
        int m = Integer.parseInt(f[1]);
        Main main = new Main();
        main.init();
        while (m-- > 0){
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[1]);
            int b = Integer.parseInt(s[2]);
            if ("M".equals(s[0])){
                main.union(a,b);
            }else {
                if (main.isConnected(a,b)) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }
}
