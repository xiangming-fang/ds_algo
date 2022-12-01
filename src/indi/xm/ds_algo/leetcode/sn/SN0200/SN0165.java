package indi.xm.ds_algo.leetcode.sn.SN0200;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0165
 * @Author: albert.fang
 * @Description: 比较版本号
 * @Date: 2021/9/1 9:40
 */
public class SN0165 {

    public int compareVersion(String version1, String version2) {
        int len1 = version1.split("\\.").length;
        int len2 = version2.split("\\.").length;
        int len  = Math.max(len1,len2);
        String[] s1 = new String[len];
        String[] s2 = new String[len];
        System.arraycopy(version1.split("\\."),0,s1,0,len1);
        System.arraycopy(version2.split("\\."),0,s2,0,len2);
        for (int i = 0; i < len; i++) {
            if (s1[i] == null){
                s1[i] = "0";
            }
            if (s2[i] == null){
                s2[i] = "0";
            }
            int res = isEqual(s1[i], s2[i]);
            if ( res != 0) {
                return res;
            }
        }
        return 0;
    }

    // 忽略前导0的判断
    // s1 > s2 1
    // s1 < s2 -1
    // s1 = s2 0
    private int isEqual(String s1,String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int first = 0;
        int second = 0;
        while (first < s1.length()){
            if (c1[first] != '0'){
                break;
            }
            first ++;
        }
        if(first == s1.length()){
            s1 = "0";
        }else {
            s1 = s1.substring(first);
        }
        while (second < s2.length()){
            if (c2[second] != '0'){
                break;
            }
            second ++;
        }
        if(second == s2.length()){
            s2 = "0";
        }else {
            s2 = s2.substring(second);
        }
        return Integer.parseInt(s1) > Integer.parseInt(s2) ? 1 : Integer.valueOf(s1).equals(Integer.valueOf(s2)) ? 0 : -1;
    }


    @Test
    public void test(){
        System.out.println(compareVersion("01.0010.00010.00000", "01.10.10"));
        System.out.println(compareVersion("01.001.00010.00000", "01.10.10"));
        System.out.println(compareVersion("0010", "001"));
        System.out.println(compareVersion("0000", "000.0.0.0"));
//        System.out.println(Arrays.toString("01.001.00010.00000".split("\\.")));
    }
}
