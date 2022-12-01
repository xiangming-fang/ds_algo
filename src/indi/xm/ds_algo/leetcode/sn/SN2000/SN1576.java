package indi.xm.ds_algo.leetcode.sn.SN2000;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN2000
 * @ClassName: SN1576
 * @Author: albert.fang
 * @Description: 1576. 替换所有的问号
 * @Date: 2022/1/5 20:17
 */
public class SN1576 {

    // 太久了
    public String modifyString01(String s) {
        if ("?".equals(s)){
            return "a";
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?'){
                for (int index = 0; index < 26; index++) {
                    char letter = (char)(index + 'a');
                    if (i == 0){
                        if (s.charAt(i + 1) != letter){
                            s = replace(s,i,letter);
                            break;
                        }
                    }
                    else if (i == s.length() - 1){
                        if (s.charAt(i - 1) != letter){
                            s = replace(s,i,letter);
                            break;
                        }
                    }
                    else if (s.charAt(i - 1) != letter && s.charAt(i + 1) != letter ){
                        s = replace(s,i,letter);
                        break;
                    }
                }
            }else {
                s = replace(s,i,s.charAt(i));
            }
        }
        return s;
    }

    private String replace(String s,int index,char c){
        return s.substring(0, index) + c + s.substring(index + 1);
    }

    // 小优化
    public String modifyString(String s){
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            // 最多左右相夹，所以3个字符就够用了
            for (int j = 0; j < 3 && chars[i] == '?'; j++) {
                if (i - 1 >= 0 && j + 'a' == chars[i - 1]) {
                    continue;
                }
                if (i + 1 < len && j + 'a' == chars[i + 1]){
                    continue;
                }
                chars[i] = (char) (j + 'a');
            }
        }
        return String.valueOf(chars);
    }



    @Test
    public void test(){
//        System.out.println(modifyString("j?qg??b"));
        System.out.println(modifyString("?zs"));
    }

}
