package indi.xm.jy.competition.weekcompetition.th83;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description: 较大分组的位置
 * @Date: 2022/10/21 16:26
 */
public class SN0001 {

    public List<List<Integer>> largeGroupPositions(String s) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        int tmp = 0,l = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i-1)) {
                ArrayList<Integer> sans = new ArrayList<>();
                if (i - l >= 3){
                    sans.add(l);
                    sans.add(i-1);
                    ans.add(sans);
                }
                l = i;
            }
        }
        if (s.length() - l >= 3) ans.add(Stream.of(l,s.length() - 1).collect(Collectors.toList()));
        return ans;
    }

}
