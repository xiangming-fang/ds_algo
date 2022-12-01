package indi.xm.ds_algo.leetcode.sn.SN0400;

// 赎金信
public class SN0383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] array = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            array[magazine.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (array[ransomNote.charAt(i) - 'a'] -- <= 0) {
                return false;
            }
        }
        return true;
    }

}
