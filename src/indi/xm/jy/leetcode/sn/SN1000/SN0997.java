package indi.xm.jy.leetcode.sn.SN1000;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

// 997. 找到小镇的法官
public class SN0997 {

    public int findJudge(int n, int[][] trust) {
        if (n == 1) {
            return 1;
        }
        // key：可能是法官的人，value：信任该法官的人数
        HashMap<Integer, Integer> map = new HashMap<>();
        // 法官不允许相信任何人，用来装不可能是法官的人
        HashSet<Integer> impossibleJudge = new HashSet<>();
        for (int[] s : trust) {
            if (map.containsKey(s[1])) {
                map.put(s[1],map.get(s[1]) + 1);
            }
            else {
                map.put(s[1],1);
            }
            impossibleJudge.add(s[0]);
        }
        AtomicInteger res = new AtomicInteger(-1);
        map.forEach( (k,v) -> {
            if (v == n - 1 && !impossibleJudge.contains(k)) {
                res.set(k);
                return;
            }
        });
        return res.get();
    }

    // 入度、出度
    public int findJudge02(int n, int[][] trust) {
        int[] in = new int[n];
        int[] out = new int[n];
        for (int[] ints : trust) {
            out[ints[0] - 1] ++;
            in[ints[1] - 1] ++;
        }
        for (int i = 0; i < n; i++) {
            if (out[i] == 0 && in[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }

}
