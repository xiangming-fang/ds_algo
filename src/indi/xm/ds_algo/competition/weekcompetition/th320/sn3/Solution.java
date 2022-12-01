package indi.xm.ds_algo.competition.weekcompetition.th320.sn3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * t3
 * 思路：构造图和图的dfs
 * 1、从叶子节点开始，当前节点往根节点走的路径中，某个节点有m个人员，大巴车有seats个座位，那么这个节点到下一个节点，需要几个大巴车？
 *  (m/seats) 向上取整，设为 n = Math.ceil(m/seats)
 * 2、既然有了这个结论，那么我们就可以dfs我们构造出来的图，从叶子节点一直往根节点走，记得累加走的过程中，节点人员个数。
 */
public class Solution {

    public List<Integer>[] graph;

    public long ans;

    public int seats;

    public long minimumFuelCost(int[][] roads, int seats) {

        graph = new List[roads.length + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        this.seats = seats;

        return ans;
    }

    // u 当前节点，pa是u的父亲节点
    private int dfs(int u, int pa) {
        // 当前节点u有几个人员，默认1个
        int size = 1;
        for (int cur : graph[u]) {
            if (cur == pa) continue;
            size += dfs(cur,u);
        }
        // 0 是首都，不需要再通往其他城市了
        if (u != 0) ans += Math.ceil(size/1.0/seats);
        return size;
    }

    @Test
    public void test(){

        // 7
//         int[][] roads = {{3,1},{3,2},{1,0},{0,4},{0,5},{4,6}};
//         System.out.println(minimumFuelCost(roads, 2));

        // 3
        int[][] roads = {{0,1},{0,2},{0,3}};
        System.out.println(minimumFuelCost(roads, 5));

//        int[][] roads = {};
//        System.out.println(minimumFuelCost(roads, 1));
    }


}
