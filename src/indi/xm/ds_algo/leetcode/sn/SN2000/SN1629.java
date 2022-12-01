package indi.xm.ds_algo.leetcode.sn.SN2000;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN2000
 * @ClassName: SN1629
 * @Author: albert.fang
 * @Description: 1629. 按键持续时间最长的键
 * @Date: 2022/1/10 18:44
 */
public class SN1629 {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] ans = new int[26];
        char[] chars = keysPressed.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == 0){
                ans[chars[i] - 'a'] = releaseTimes[i];
            }
            else {
                ans[chars[i] - 'a'] = Math.max(releaseTimes[i] - releaseTimes[i - 1],ans[chars[i] - 'a']);
            }
        }
        int max = 0;
        for (int i = 1; i < ans.length; i++) {
            max = ans[i] >= ans[max] ? i : max;
        }
        return (char)(max + 'a');
    }

    @Test
    public void test(){
        int[] ans = {19, 22, 28, 29, 66, 81, 93, 97};
        String str = "fnfaaxha";
        System.out.println(slowestKey(ans, str));
    }

}
