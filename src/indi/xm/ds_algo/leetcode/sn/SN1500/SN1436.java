package indi.xm.ds_algo.leetcode.sn.SN1500;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 旅行终点站
 */
public class SN1436 {

    public String destCity(List<List<String>> paths) {
        List<String> first = paths.get(0);
        return getNextStop(first.get(1), paths);
    }

    private String getNextStop(String stop,List<List<String>> paths){
        for (List<String> path : paths) {
            if (path.get(0).equals(stop)) {
                return getNextStop(path.get(1),paths);
            }
        }
        return stop;
    }

    @Test
    public void test(){
        List<List<String>> paths = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add("London");
        path.add("New York");
        paths.add(path);
        List<String> path1 = new ArrayList<>();
        path1.add("New York");
        path1.add("Lima");
        paths.add(path1);
        List<String> path2 = new ArrayList<>();
        path2.add("Lima");
        path2.add("Sao Paulo");
        paths.add(path2);
        System.out.println(destCity(paths));
    }
}
