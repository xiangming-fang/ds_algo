package indi.xm.jy.acwing.questions.discretization.s0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.discretization.s0802
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 区间和
 * @Date: 2022/10/28 18:06
 */
public class Main {
    public static void main(String[] args) throws IOException {
        int N = 300010;
        int[] ad = new int[N];
        int[] prefixSum = new int[N];
        ArrayList<Pair<Integer, Integer>> addPair = new ArrayList<>();
        ArrayList<Integer> bd = new ArrayList<>();
        ArrayList<Pair<Integer, Integer>> queriesPair = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] f = br.readLine().split(" ");
        int n = Integer.parseInt(f[0]);
        int m = Integer.parseInt(f[1]);
        for (int i = 0; i < n; i++) {
            String[] sec = br.readLine().split(" ");
            int x = Integer.parseInt(sec[0]);
            int c = Integer.parseInt(sec[1]);
            bd.add(x);
            addPair.add(new Pair<>(x,c));
        }
        for (int i = 0; i < m; i++) {
            String[] th = br.readLine().split(" ");
            int l = Integer.parseInt(th[0]);
            int r = Integer.parseInt(th[1]);
            queriesPair.add(new Pair<>(l,r));
            bd.add(l);
            bd.add(r);
        }
        // 对bd进行排序，去重
        Collections.sort(bd);
        int i = 1;
        while (i < bd.size()) {
            if (bd.get(i) == bd.get(i-1)) bd.remove(i);
            i ++;
        }
        for (Pair<Integer, Integer> pair : addPair) {
            int bs = bs(bd, pair.k);
            ad[bs] += pair.v;
        }
        for (int j = 1; j < N; j++) {
            prefixSum[i] = prefixSum[i-1] + ad[i];
        }
        for (Pair<Integer, Integer> pair : queriesPair) {
            System.out.println(prefixSum[pair.v] - prefixSum[pair.k - 1]);
        }
    }

    public static int bs(ArrayList<Integer> bd,int x){
        int l = 0,r = bd.size() - 1;
        while (l < r){
            int mid = l + (r-l)/2;
            if (bd.get(mid) >= x) r = mid;
            else l = mid + 1;
        }
        return l+1;
    }

    private static class Pair<K,V>{
        public K k;
        public V v;
        public Pair(K k,V v){
            this.k = k;
            this.v = v;
        }
    }
}
