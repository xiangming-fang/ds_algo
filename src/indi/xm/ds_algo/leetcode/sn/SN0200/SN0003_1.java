package indi.xm.ds_algo.leetcode.sn.SN0200;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0003_1
 * @Author: albert.fang
 * @Description: 最长无重复子串的长度
 * @Date: 2022/5/17 17:01
 */
public class SN0003_1 {

//     整理下思路：
//     左神说看到题目里有关子串、子序列的问题，那么可以这样解答：
//     假设子串、子序列的结束位置在i处，那么有几个答案？

    // 主要思路，滑动窗口
    // 假设最大不重复子串的结束位置在 i处字符a，最右边窗口是位置i处
    // 那么最左边的窗口位置是哪个？
    // (1) 上一次出现a的位置
    // (2) 以i-1处为结束位置的最大不重复子串最左窗口
    // 那么到底选(1)还是(2)为最左窗口呢？
    // 答案：谁离i近就做为左侧窗口

    // 这里的算法原型是滑动窗口，但是窗口的大小不是固定的，最右边窗口是确定下来的，就是i。
    // 最左边有上面分析的两种情况。
    // 针对上面的第一种情况，我们可以开个map来存储下每个位置的元素位置。
    // 针对上面的第二种情况，我们可以用一个指针pre记下 i-1 最左侧窗口的位置。
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        // key -> 具体字符 value -> 字符存在位置
        HashMap<Character, Integer> map = new HashMap<>();
        int pre = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int max = Math.max(map.get(c), pre);
                res = Math.max(res,i - max);
                pre = max;
            }else {
                res = Math.max(res,i - pre);
            }
            map.put(c,i);
        }
        return res;
    }

    public int lengthOfLongestSubstring01(String s) {
        int res = 0;
        int[] map = new int[256];
        Arrays.fill(map,-1);
        int pre = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map[c] != -1) {
                int max = Math.max(map[c], pre);
                res = Math.max(res,i - max);
                pre = max;
            }else {
                res = Math.max(res,i - pre);
            }
            map[c] = i;
        }
        return res;
    }
}
