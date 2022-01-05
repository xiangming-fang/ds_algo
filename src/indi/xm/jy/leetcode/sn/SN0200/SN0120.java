package indi.xm.jy.leetcode.sn.SN0200;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0120
 * @Author: albert.fang
 * @Description: 120. 三角形最小路径和
 * @Date: 2022/1/5 10:24
 */
public class SN0120 {

    int min = Integer.MAX_VALUE;

    // 暴力dfs超时
    public int minimumTotal(List<List<Integer>> triangle) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(triangle.get(0).get(0));
        dfs(triangle,0,1,ans);

        return min;
    }


    private void dfs(List<List<Integer>> triangle,int preIndex,int h,List<Integer> ans){

        if (h == triangle.size()){
            min = Math.min(ans.stream().mapToInt(v -> v).sum(),min);
            return;
        }

        ans.add(triangle.get(h).get(preIndex));
        dfs(triangle,preIndex,h + 1,ans);
        ans.remove(ans.size() - 1);

        ans.add(triangle.get(h).get(preIndex + 1));
        dfs(triangle,preIndex + 1,h + 1,ans);
        ans.remove(ans.size() - 1);
    }

}
