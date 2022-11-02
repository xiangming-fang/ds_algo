package indi.xm.jy.acwing.questions.regionmerge.s0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.regionmerge.s0803
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 区间合并
 * @Date: 2022/11/2 12:53
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] region = br.readLine().split(" ");
            pairs.add(new Pair(Integer.parseInt(region[0]),Integer.parseInt(region[1])));
        }
        pairs = mergeRegion(pairs);
        System.out.println(pairs.size());
    }

    public static List<Pair<Integer,Integer>> mergeRegion(List<Pair<Integer,Integer>> regions){
        Collections.sort(regions,(a,b) -> a.k - b.k);
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        int N = -2_000_000_000;
        int l = N,r = N;
        for (Pair<Integer, Integer> region : regions) {
            if (region.k > r){
                if (l != N) pairs.add(new Pair<>(l,r));
                l = region.k;
                r = region.v;
            }
            else r = Math.max(r,region.v);
        }
        if (l != N) pairs.add(new Pair<>(l,r));
        return pairs;
    }

    public static int mergeRegionNums(List<Pair<Integer,Integer>> regions){
        Collections.sort(regions,(a,b) -> a.k - b.k);
        int N = -2_000_000_000;
        int l = N,r = N,res = 0;
        for (Pair<Integer, Integer> region : regions) {
            if (region.k > r){
                if (l != N) res ++;
                l = region.k;
                r = region.v;
            }
            else r = Math.max(r,region.v);
        }
        if ( l != N) res++;
        return res;
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
