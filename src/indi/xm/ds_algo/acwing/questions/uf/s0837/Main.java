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

    HashMap<Integer,Integer> cntMap = new HashMap<>();

    public void init(){
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
            cntMap.put(i,1);
        }
    }

    public int find(int x){
        while (x != p[x]) x = p[x];
        return p[x];
    }

    public void union(int a,int b){
        int aRoot = find(a);
        int bRoot = find(b);
        // a,b所处同一个集合，不必进行后续操作
        if (aRoot == bRoot) return;
        cntMap.put(bRoot,cntMap.get(aRoot) + cntMap.get(bRoot));
        cntMap.remove(aRoot);
        p[aRoot] = bRoot;
    }

    public boolean isConnected(int a,int b){
        return find(a) == find(b);
    }

    public int count(int a){
        return cntMap.get(find(a));
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
