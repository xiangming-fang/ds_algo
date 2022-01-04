package indi.xm.jy.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0077
 * @Author: albert.fang
 * @Description: 组合
 * @Date: 2021/11/10 15:38
 */
public class SN0077 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine01(int n, int k) {
        dfs(n,1,k,new ArrayList<>());
        return res;
    }

    // n 是数组范围 【1,n】 start 表示从哪个开始 k 是一个组合里包含几个数字 一组数字
    // k 控制递归深度
    private void dfs(int n,int start,int k,List<Integer> singleCombo){

        if (singleCombo.size() == k){
            res.add(new ArrayList<>(singleCombo));
            System.out.println("添加进去的是 ：" + singleCombo);
            return;
        }
        for (int i = start; i <= n; i++) {
//            System.out.println("添加一个：" + i);
            singleCombo.add(i);
            dfs(n,i + 1,k,singleCombo);
            // 回溯
//            System.out.println("撤销一个： " + singleCombo.get(singleCombo.size() - 1));
            singleCombo.remove(singleCombo.size() - 1);
//            System.out.println("当前单个是： " + singleCombo.toString());
        }
    }

    /******************* 2022-01-04 **************************/

    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n,k,new ArrayList<Integer>(),1);
        return ret;
    }

    private void dfs(int n, int k, ArrayList<Integer> ans,int start) {
        if (ans.size() == k){
            ret.add(new ArrayList<>(ans));
            return;
        }
        for (int i = start; i <= n; i++) {
            ans.add(i);
            dfs(n,k,ans,i + 1);
            ans.remove(ans.size() - 1);
        }
    }

    @Test
    public void test(){
        System.out.println(combine(4, 2).toString());
    }
}
