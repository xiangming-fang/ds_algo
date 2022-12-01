package indi.xm.ds_algo.leetcode.sn.SN1000;

import indi.xm.ds_algo.leetcode.util.StringUtils;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1000
 * @ClassName: SN0686
 * @Author: albert.fang
 * @Description: 686. 重复叠加字符串匹配
 * @Date: 2021/12/22 9:40
 */
public class SN0686 {

    public int repeatedStringMatch(String a, String b) {
        int res = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        while (sb.length() < 2 * a.length() + b.length()){
//            int subString = isSubString(sb.toString(), b);
            int subString = sb.toString().indexOf(b);
            if (subString != -1) {
                return res;
            }
            res ++;
            sb.append(a);
        }
        return -1;
    }

    // 伪KMP
    private int isSubString(String p,String s){

        if (s.length() > p.length()){
            return -1;
        }
        char c = s.charAt(0);
        ArrayList<Integer> firstIndexs = new ArrayList<>();
        for (int i = 0; i <= p.length() - s.length(); i++) {
            if (p.charAt(i) == c){
                firstIndexs.add(i);
            }
        }

        for (Integer index : firstIndexs) {
            int count = 0;
            int tmpIndex = index;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != p.charAt(tmpIndex++)){
                    break;
                }
                count ++;
            }
            if (count == s.length()){
                return index;
            }
        }

        return -1;
    }


    public boolean detector(){
        String str1 = StringUtils.getRandomString(5, 20);
        String str2 = StringUtils.getRandomString(5, 5);
        if (isSubString(str1,str2) != str1.indexOf(str2)) {
            System.out.println(str1);
            System.out.println(str2);
            return false;
        }
        return true;
    }

    @Test
    public void test(){

        for (int i = 0; i < 5000000; i++) {
            if (!detector()) {
                System.out.println(i);
                throw new RuntimeException("伪KMP写错了");
            }
        }
        System.out.println("伪KMP写的完全正确");
    }

    @Test
    public void testDet(){
        System.out.println(repeatedStringMatch("abcd", "cdabcdab"));
        System.out.println(repeatedStringMatch("a", "aa"));
        System.out.println(repeatedStringMatch("a", "a"));
        System.out.println(repeatedStringMatch("abc", "xyz"));
    }

}
