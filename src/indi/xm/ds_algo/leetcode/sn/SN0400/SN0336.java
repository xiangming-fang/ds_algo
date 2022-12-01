package indi.xm.ds_algo.leetcode.sn.SN0400;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0336
 * @Author: albert.fang
 * @Description: 回文对
 * @Date: 2021/11/29 15:52
 */
public class SN0336 {

    List<List<Integer>> res = new ArrayList<>();

    String[] words;

    public List<List<Integer>> palindromePairs(String[] words) {
        this.words = words;
        backtracking(words,new ArrayList<>());
        return res;
    }

    private void backtracking(String[] words, ArrayList<Integer> path) {
        if (path.size() == 2 && isPalindromePairs(path) && !Objects.equals(path.get(0), path.get(1))){
            res.add(new ArrayList<>(path));
            return;
        }
        if (path.size() == 2){
            return;
        }
        for (int i = 0; i < words.length; i++) {
            path.add(i);
            backtracking(words,path);
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindromePairs(ArrayList<Integer> path){
        StringBuilder sb = new StringBuilder();
        sb.append(words[path.get(0)]).append(words[path.get(1)]);
        int left = 0,right = sb.length() - 1;
        while (left < right){
            if (sb.charAt(left) != sb.charAt(right)){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
    }


}
