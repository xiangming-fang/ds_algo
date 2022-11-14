package indi.xm.jy.competition.oddweekcompetition.th91;

import indi.xm.jy.leetcode.util.StringUtils;
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
public class SN0003 {

    // 思路：构造图 + dfs遍历
    // 1、根据给的edges构造出图
    // 2、dfs bob前往根节点的过程，用map存储：key -> 经过的节点值，value -> bob第几步经过这个节点
    // 3、dfs alice 前往叶子节点的过程


    public Map<Integer,Integer> bobStep = new HashMap<>();

    // alice 经过的节点
    public Set<Integer> aliceStep = new HashSet<>();

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
        aliceStep.add(u);
        if (u != 0 && graph[u].size() == 1) {
            ans = Math.max(ans,sum);
            return;
        }

        for (int next : graph[u]) {
            int tmp = amount[next];
            if (aliceStep.contains(next)) continue;
            if (bobStep.containsKey(next) && bobStep.get(next) < step + 1) tmp = 0;
            else if (bobStep.containsKey(next) && bobStep.get(next) == step + 1) tmp = tmp >> 1;
            aliceDfs(next,step + 1,sum + tmp);
        }
    }

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
//        int[][] edges = {{0,1},{1,2},{1,3},{3,4}};
//        int bob = 3;
//        int[] amount = {-2,4,2,-4,6};
//        System.out.println(mostProfitablePath(edges, bob, amount));

        int[][] edges = {{0,1}};
        int bob = 1;
        int[] amount = {-7280,2350};
        System.out.println(mostProfitablePath(edges, bob, amount));
    }


}