package indi.xm.jy.leetcode.competition.weekcompetition.th314;

public class SN0002 {

    public int[] findArray(int[] pref) {
        int[] arr = new int[pref.length];
        arr[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            arr[i] = pref[i - 1] ^ pref[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(3 << 32);
    }

}
