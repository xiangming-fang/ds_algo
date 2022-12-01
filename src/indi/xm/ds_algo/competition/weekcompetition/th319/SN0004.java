package indi.xm.ds_algo.competition.weekcompetition.th319;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description: 不重叠回文子字符串的最大数目
 * @Date: 2022/10/21 16:26
 */
public class SN0004 {

    // 思路：贪心
    // 假设以i为起点的子字符串，我们要判断子字符串是否存在回文串，只需要证明以i为起始点的两个子串即可。即 [i,i+k-1]或者[i,i+k]
    // 疑问1：为什么只需要这两个？而[i,i+k+1]……不需要呢？
    // 因为我们这里求的是最大回文子串，所以我们应该尽可能让每个回文子串最短。
    // 比如说：abcdefg gfedcba如果我们要check [i,i+k+1]……，那么最后只能得到一个回文子串，所以这里应该尽可能让其更短。
    // 疑问2：既然尽可能的最短，那么为什么还需要校验[i,i+k]呢？不是只需要校验[i,i+k-1]即可吗？
    // 因为如果[i,i+k]不是回文子串，那么我们下一步要做的是i指针右移一位，然后再判断[i,i+k-1]，我们是尽可能的需要让[i,i+k-1]是回文子串
    // 可是此时的i+k-1其实就是i没有右移之前的i+k位置，我们的目的都是为了得到1个，所以我们这里是校验两种可能即可。
    public int maxPalindromes(String s, int k) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + k - 1 < s.length() && isPalindrome(s,i,i + k - 1)){
                i = i + k - 1;
                ans ++;
            }
            else if (i + k < s.length() && isPalindrome(s,i,i + k)){
                i = i + k;
                ans ++;
            }
        }
        return ans;
    }

    public boolean isPalindrome(String s,int l,int r){
        while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }

}
