package indi.xm.ds_algo.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 单词拆分 II
public class SN0140 {
    List<String> wordDicts;
    List<String> res = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordDicts = wordDict;
        dfs(s,new StringBuilder());
        return res;
    }

    private void dfs(String s, StringBuilder sb) {
        // s 为空的话，说明已经截取完了
        if (s.isEmpty()){
            res.add(sb.substring(0, sb.length() - 1));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String path = s.substring(0, i);
            if (isLegal(path)) {
                sb.append(path).append(" ");
                dfs(s.substring(i),sb);
                // 进行回溯
                sb.delete(sb.length() - (path.length() + 1), sb.length());
            }
        }
    }

    // 校验字符串pendingCompare是否在wordDict里
    // 在返回 - true 不在返回 - false
    private boolean isLegal(String pendingCompare){
        if (pendingCompare == null){
            return false;
        }
        return wordDicts.contains(pendingCompare);
    }

    @Test
    public void test(){
//        String[] params = {"cat", "cats", "and", "sand", "dog"};
        String[] params = {"apple", "pen", "applepen", "pine", "pineapple"};
        List<String> param = Arrays.stream(params).collect(Collectors.toList());
//        System.out.println(wordBreak("catsanddog", param));
        System.out.println(wordBreak("pineapplepenapple", param));
    }
}
