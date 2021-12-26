package indi.xm.jy.leetcode.util;

import java.util.Random;

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
        replaceChar(str,new char[]{'[',']','"','\n'},
                new char[]{'{','}','\'',' '});
    }

    public static void replaceMid(String str){
        replaceChar(str,new char[]{'[',']','\n'},
                new char[]{'{','}',' '});
    }


    /**
     * 生成随机字符串
     *
     * @param possibilities
     * @param size
     * @return
     */
    public static String getRandomString(int possibilities, int size) {
        char[] ans = new char[(int) (Math.random() * size) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (char) ((int) (Math.random() * possibilities) + 'a');
        }
        return String.valueOf(ans);
    }
}
