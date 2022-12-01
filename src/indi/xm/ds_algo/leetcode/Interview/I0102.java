package indi.xm.ds_algo.leetcode.Interview;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.Interview
 * @ClassName: I0102
 * @Author: albert.fang
 * @Description: 判定是否为字符重排
 * @Date: 2022/9/27 10:10
 */
public class I0102 {

    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        int[] hashtable = new int[256];
        for(int i = 0; i < s1.length(); i++){
            hashtable[s1.charAt(i)] ++;
        }
        for(int i = 0; i < s2.length(); i++){
            hashtable[s2.charAt(i)] --;
        }
        for(int i = 0; i < 256; i++){
            if(hashtable[i] != 0) return false;
        }
        return true;
    }

}
