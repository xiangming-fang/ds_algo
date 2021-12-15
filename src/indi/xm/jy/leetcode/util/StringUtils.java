package indi.xm.jy.leetcode.util;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.util
 * @ClassName: StringUtils
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/16 20:26
 */
public class StringUtils {

    public static void replaceChar(String str,char[] oldChar,char[] newChar){
        for (int i = 0; i < oldChar.length; i++) {
            str = str.replace(oldChar[i], newChar[i]);
        }
        System.out.println(str);
    }

    public static void replaceArr(String str){
        replaceChar(str,new char[]{'[',']'},
                new char[]{'{','}'});
    }
}
