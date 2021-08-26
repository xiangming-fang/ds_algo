package indi.xm.jy.leetcode.sn.SN1000;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有可能的路径
 */
public class SN0797 {
    int[][] g;
    int length;
    List<List<Integer>> paths = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        g = graph;
        length = graph.length;
        path.add(0);
        dsf(0);
        return paths;
    }

    private void dsf(int index){
        if (length - 1 == index){
            paths.add(new ArrayList<>(path));
            return;
        }
        for (int t : g[index]) {
            path.add(t);
            dsf(t);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test(){
        List<List<Integer>> lists = allPathsSourceTarget(new int[][]{{1, 2},{3},{3},{}});
        System.out.println(lists);
    }
}
