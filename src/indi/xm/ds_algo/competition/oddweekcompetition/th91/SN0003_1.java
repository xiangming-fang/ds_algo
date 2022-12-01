package indi.xm.ds_algo.competition.oddweekcompetition.th91;

import org.junit.Test;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description: 树上最大得分和路径
 * @Date: 2022/10/21 16:26
 */
public class SN0003_1 {

    // 思路：构造图 + dfs遍历
    // 1、根据给的edges构造出图
    // 2、dfs bob前往根节点的过程，用map存储：key -> 经过的节点值，value -> bob第几步经过这个节点
    // 3、dfs alice 前往叶子节点的过程


    public Map<Integer,Integer> bobStep = new HashMap<>();

    // alice 经过的节点，经过的节点值，改成对应的true
    boolean[] exists = new boolean[100010];

    // 下标：对应节点
    // value: 与这个节点相邻的节点
    public List<Integer>[] graph;

    public int ans = Integer.MIN_VALUE;

    public int[] amount;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {

        this.amount = amount;

        graph = new List[amount.length];
        for (int i = 0; i < amount.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int a = edge[0],b = edge[1];
            graph[a].add(b);
            graph[b].add(a);
        }


        bobDfs(bob,0);

        aliceDfs(0,0,amount[0]);

        return ans;

    }

    private void aliceDfs(int u,int step,int sum) {
        exists[u] = true;
        if (u != 0 && graph[u].size() == 1) {
            ans = Math.max(ans,sum);
            return;
        }

        for (int next : graph[u]) {
            int tmp = amount[next];
            if (exists[next]) continue;
            // 如果bobStep经过这个节点，并且经过这个节点的步数小于 step + 1说明bob先到这个节点，所以alice这步操作应该等于0
            if (bobStep.containsKey(next) && bobStep.get(next) < step + 1) tmp = 0;
            // 如果包含，并且 想等，那么 alice这步操作应该等于 这个节点的 1/2 值
            else if (bobStep.containsKey(next) && bobStep.get(next) == step + 1) tmp = tmp >> 1;
            // 不包含，alice自己得到全部的值
            aliceDfs(next,step + 1,sum + tmp);
        }
    }

    // 用true控制是往根节点走的路径
    private boolean bobDfs(int u,int step) {

        bobStep.put(u,step);

        if (u == 0) return true;

        for (int next : graph[u]) {
            if (bobStep.containsKey(next)) continue;
            if (bobDfs(next,step + 1)) return true;
        }

        bobStep.remove(u);
        return false;
    }

    @Test
    public void test(){
        int[][] edges = {{0,1},{1,2},{1,3},{3,4}};
        int bob = 3;
        int[] amount = {-2,4,2,-4,6};
        System.out.println(mostProfitablePath(edges, bob, amount));

//        int[][] edges = {{0,1}};
//        int bob = 1;
//        int[] amount = {-7280,2350};
//        System.out.println(mostProfitablePath(edges, bob, amount));
    }


}