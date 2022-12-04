package indi.xm.ds_algo.competition.weekcompetition.th322.sn2;
import java.util.Arrays;

/**
 * t2 划分技能点相等的团队
 */
public class Solution {

    public long dividePlayers(int[] skill) {
        int sum = 0;
        for (int i : skill) {
            sum += i;
        }
        int n = skill.length;
        int avg = sum / (n>>1);
        Arrays.sort(skill);
        int l = 0,r = n - 1;
        long ans = 0;
        while (l < r){
            if (skill[l] + skill[r] != avg) return -1;
            ans += (long) skill[l++] * skill[r--];
        }
        return ans;
    }

}
