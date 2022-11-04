package indi.xm.jy.acwing.questions.regionmerge.s0759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.discretization.s0759
 * @ClassName: Main1
 * @Author: albert.fang
 * @Description: 格子染色
 * @Date: 2022/11/4 16:12
 */
public class Main1 {

    // 思路：二维区间合并
    // 之前一维区间是给定左边界和右边界，然后按左边界为第一顺序进行排序的；
    // 二维层面的区间合并，同样有左右边界，但同时还要维护一个行号或者列号。
    // 1、我们记行号或列号为k,左边界为l,右边界为r。
    // 2、在二维层面的每个区间需要维护这三个值：k、l、r
    // 3、所有区间可以分为两类：按行区间、按列区间，下面以按行来说，列同理。
    // 4、行区间集合的排序规则是：第一顺序是行号、第二顺序是左边界、第三顺序是右边界
    // 5、对行区间集合进行区间排序
    //    5.1、k相同则进行和一维区间合并，k不同切换l = r = -2_000_000_000，再次进行比较。
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        List<Region> rows = new ArrayList<>();
        List<Region> cols = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] axis = br.readLine().split(" ");
            int x1 = Integer.parseInt(axis[0]);
            int y1 = Integer.parseInt(axis[1]);
            int x2 = Integer.parseInt(axis[2]);
            int y2 = Integer.parseInt(axis[3]);
            if (x1 == x2) rows.add(new Region(x1,Math.min(y1,y2),Math.max(y1,y2)));
            else cols.add(new Region(y1,Math.min(x1,x2),Math.max(x1,x2)));
        }
        Pair<List<Region>, Long> rowPairs = mergeRegion(rows);
        Pair<List<Region>, Long> colPairs = mergeRegion(cols);
        rows = rowPairs.k;
        cols = colPairs.k;
        long ans = rowPairs.v + colPairs.v;
        // 去除重复点
        for (Region row : rows) {
            for (Region col : cols) {
                if (row.k >= col.l && row.k <= col.r && col.k >= row.l && col.k <= row.r) ans--;
            }
        }
        System.out.println(ans);
    }

    public static Pair<List<Region>,Long> mergeRegion(List<Region> regions){
        Collections.sort(regions,(e1,e2) -> {
            if (e1.k != e2.k) return e1.k - e2.k;
            else if (e1.l != e2.l) return e1.l - e2.l;
            else return e1.r - e2.r;
        });
        int N = -2_000_000_000;
        int l = N,r = N,k = N;
        List<Region> ans = new ArrayList<>();
        long ansI = 0;
        for (Region region : regions) {
            // 换行|列、更新k 并且保存上一行或列的最后一个区间
            if (region.k != k) {
                if (l != N) {
                    ansI += r - l + 1;
                    ans.add(new Region(k,l,r));
                }
                l = N;
                r = N;
                k = region.k;
            }
            if (region.l > r){
                if (l != N) {
                    ansI += r - l + 1;
                    ans.add(new Region(k,l,r));
                }
                l = region.l;
                r = region.r;
            }
            else r = Math.max(r,region.r);
        }
        if (l != N) {
            ans.add(new Region(k,l,r));
            ansI += r - l + 1;
        }
        return new Pair<List<Region>,Long>(ans,ansI);
    }

    static class Pair<K,V>{
        public K k;
        public V v;
        public Pair(K k,V v){
            this.k = k;
            this.v = v;
        }
    }

    static class Region{
        public int k;
        public int l;
        public int r;
        public Region(int k,int l,int r){
            this.k = k;
            this.l = l;
            this.r = r;
        }
    }
}
