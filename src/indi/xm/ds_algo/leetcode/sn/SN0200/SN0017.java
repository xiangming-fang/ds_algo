package indi.xm.ds_algo.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0017
 * @Author: albert.fang
 * @Description: 电话号码的字母组合
 * @Date: 2021/11/10 14:58
 */
public class SN0017 {


    String[] letters = {" "," ", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")){
            return res;
        }
        dfs(digits,0, new StringBuilder(""));
        return res;
    }

    // index 是一棵树的深度 控制递归深度
    private void dfs(String digits,int index,StringBuilder temp){
        if (temp.length() == digits.length()){
            // 找到了和数字一样长的字符串了
            res.add(String.valueOf(temp));
            return;
        }

        int numIndex = digits.charAt(index) - '0';
        for (int i = 0; i < letters[numIndex].length(); i++) {
            temp.append(letters[numIndex].charAt(i));
            dfs(digits,index + 1,temp);
            // 回溯
            temp.delete(temp.length() - 1,temp.length());
        }
    }

    @Test
    public void test(){
        System.out.println(letterCombinations("23"));
    }
}
