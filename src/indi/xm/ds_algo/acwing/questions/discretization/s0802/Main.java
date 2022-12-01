package indi.xm.ds_algo.acwing.questions.discretization.s0802;

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

    // 离散化：将无限空间（坐标）的元素，与有限空间（坐标）的元素一一对应。
    // 离散前 bd: 300、489、23、34、123、3245、3245
    // 离散化后: 4、5、1、2、3、6、6
    // 我们可以看见离散化只关注离散化元素的大小关系，而并不关注离散化的具体值。
    // 因此我们可以将bd用数组存储，并且排序、然后去重。得到一个有序且去重的数组 bd1，这个数组的下标就是离散化后的大小关系，也就是离散化后的大小关系值。（坐标）
    // 创建一个与bd1大小相同的数组记为ad。
    // 如果我们此时给离散化前的位置 3245加上 111 其实就相当于给离散化后的ad[5]加上111. => 其实这里包含两个操作：1、去bd1查找值为3245的元素下标，记为index。2、修改ad[index] += 111;
    // 总之：离散化前的数组bd里面的元素都是坐标的概念，经过对bd的排序、去重之后得到离散化后的数组bd1.
    // bd1中的元素值是离散化前bd坐标，bd1的下标就是离散化的坐标。
    // 以上就是整个离散化的思想。

    // 针对本题的特别点：
    // （1）我们可以直接创建一个大小为N=300010的ad数组，为什么 N = 300010 ?
    // 因为题目给出add(x,c) x就是离散化前bd的坐标位置。一共要add n次，其中 1 <= n <= 100000
    // 然后查找query(l,r) l,r 也是离散化前bd的坐标位置。一共要query m次，其中 1 <= m <= 100000
    // 在极端情况下x,l,r是不会存在重复的，也就是说存在x+l+r = 300000
    // 而 N 还要比300000多个10，主要是因为求前缀和的时候，我们习惯从下标为1的位置开始。
    // (2) 由于我们的ad下标是从1开始的，所以我们离散化在找下标的过程中，我们习惯性将目标下标+1
    // (3) query(l,r) 中的l、r也是需要加入bd中的，为什么？
    // l,r 是属于离散化前bd中的元素（坐标），既然我们查询需要用到bd中的元素，那么我们自然需要将l、r与bd1中的元素进行匹配
    // 如果 lr不加入bd，那么后续bd1则不会存在于lr对应的下标位置，从而ad也压根没有l、r对应的区间范围。
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
            else i ++;
        }
        for (Pair<Integer, Integer> pair : addPair) {
            int index = bs(bd, pair.k);
            ad[index] += pair.v;
        }
        for (int j = 1; j < N; j++) {
            prefixSum[j] = prefixSum[j-1] + ad[j];
        }
        for (Pair<Integer, Integer> pair : queriesPair) {
            System.out.println(prefixSum[bs(bd,pair.v)] - prefixSum[bs(bd,pair.k) - 1]);
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
