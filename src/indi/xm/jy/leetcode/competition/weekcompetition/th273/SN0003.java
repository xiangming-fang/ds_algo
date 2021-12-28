package indi.xm.jy.leetcode.competition.weekcompetition.th273;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SN0003 {

    public long[] getDistances(int[] arr) {
        long[] ret = new long[arr.length];
        // 元素，相同元素的位置
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                List<Integer> ans = map.get(arr[i]);
                ans.add(i);
                map.put(arr[i],ans);
                for (int j = 0; j < ans.size(); j++) {
                    int x = 0;
                    for (Integer integer : ans) {
                        x += Math.abs(ans.get(j) - integer);
                    }
                    ret[ans.get(j)] = x;
                }
            }else {
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(i);
                map.put(arr[i],ans);
            }
        }


        return ret;
    }

    public long[] getDistances01(int[] arr) {
        long[] res = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            List<Integer> samePos = findSamePos(arr,  arr[i]);
            if (samePos.size() != 0) {
                int v = 0;
                for (Integer samePo : samePos) {
                    v  += Math.abs(i - samePo);
                }
                res[i] = v;
            }else {
                res[i] = 0;
            }
        }
        return res;
    }

    private List<Integer> findSamePos(int[] arr,int value){
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) ret.add(i);
        }
        return ret;
    }

    @Test
    public void test(){
        int[] res = {2, 1, 3, 1, 2, 3, 3};
        System.out.println(Arrays.toString(getDistances(res)));
    }

}
