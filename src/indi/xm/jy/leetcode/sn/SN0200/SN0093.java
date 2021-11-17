package indi.xm.jy.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0093
 * @Author: albert.fang
 * @Description: 复原 IP 地址
 * @Date: 2021/11/11 15:04
 */
public class SN0093 {

    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s,0,new StringBuilder(),0);
        return res;
    }

    // start 切割线
    // 分隔符 “.” 个数
    private void dfs(String s, int start, StringBuilder singleCutting,int dot) {
        // 判断当前切割ip是否终止
        if (singleCutting.length() == s.length() + 4){
            res.add(singleCutting.substring(0,singleCutting.length() - 1));
            return;
        }
        // 点号大于3个
        if (dot == 4){
            return;
        }

        // 单层操作
        for (int i = start; i < s.length(); i++) {
            if (singleIpLegal(s,start,i + 1)){
//                System.out.println("符合的切割字符是：" + s.substring(start,i + 1));
                singleCutting.append(s, start, i + 1);
                if (dot <= 3){
                    singleCutting.append(".");
                    dot ++;
                }
//                System.out.println("加入字符之后结果是：" + singleCutting);
                dfs(s,i + 1,singleCutting,dot);
                // 回溯
                // 删除点号的个数
                dot --;
                // 删除最后一个点号 方便回溯
                singleCutting.delete(singleCutting.length() - 1,singleCutting.length());
                // 根据正确的点号进行回溯
                int lastIndex = singleCutting.lastIndexOf(".");
                singleCutting.delete(lastIndex + 1,singleCutting.length());
//                System.out.println("回溯到上一层之后结果是：" + singleCutting);
            }

        }
    }

    private boolean singleIpLegal(String s,int start,int end){
        String temp = s.substring(start, end);
        if (temp.length() > 1){
            if (temp.startsWith("0")) {
                return false;
            }
        }
        if (temp.length() > 3){
            return false;
        }
        return Integer.parseInt(temp) >= 0 && Integer.parseInt(temp) <= 255;
    }

    @Test
    public void test(){
//        System.out.println(restoreIpAddresses("010010"));
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("101023"));
        System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses("1111"));
//        System.out.println(restoreIpAddresses("1036"));
    }
}
