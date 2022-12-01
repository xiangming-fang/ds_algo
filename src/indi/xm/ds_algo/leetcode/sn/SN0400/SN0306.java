package indi.xm.ds_algo.leetcode.sn.SN0400;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0306
 * @Author: albert.fang
 * @Description: 累加数
 * @Date: 2021/9/28 14:34
 */
public class SN0306 {

    private List<Long> tempStore = new ArrayList<>();

    // 2021 11 01 回溯哦，难搞哦
    // 2021 11 22 我来啦，回溯哦，多练哦
    public boolean isAdditiveNumber01(String num) {
        return dfs(num);
    }

    private boolean dfs(String num) {
        // num 为空了 && 存储数字的集合size >= 3，说明正确的截取到最后了
        if (tempStore.size() >= 3 && Objects.equals(num, "")){
            System.out.println("找到了~~~");
            return true;
        }

        for (int i = 1; i <= num.length(); i++) {
            String pathStr = num.substring(0, i);
            if (pathStr.length() > 1 && pathStr.startsWith("0")) {
                continue;
            }
            long path = 0L;
            try{
                path = Long.parseLong(pathStr);
            }catch (Exception e){
                // 如果数字太大的话，那么默认不合法，后续优化
                continue;
            }
            if (isMatch(path)){
//                System.out.println(path + "  进来");
                tempStore.add(path);
                if (dfs(num.substring(i))) {
                    return true;
                }
                // 回溯
//                System.out.println("回溯删除 " + tempStore.get(tempStore.size() - 1));
                tempStore.remove(tempStore.size() - 1);
            }
        }

        return false;
    }

    private boolean isMatch(long pathValue){
        int len = tempStore.size();
        if (len <= 1){
            return true;
        }
        return tempStore.get(len - 1) + tempStore.get(len - 2) == pathValue;
    }

    /********************** 2022-01-10 打卡题 ********************/

    private List<String> numList = new ArrayList<>();

    public boolean isAdditiveNumber(String num){
        return isMatch(num);
    }

    private boolean isMatch(String num){

        if (numList.size() >= 3 && "".equals(num)){
            System.out.println(numList);
            return true;
        }

        for (int i = 1; i <= num.length(); i++) {
            String path = num.substring(0, i);
            if (path.length() > 1 && path.startsWith("0")) return false;
            if (stepIsTrue(path)){
                numList.add(path);
                if (isMatch(num.substring(i))) return true;
                numList.remove(numList.size() - 1);
            }
        }

        return false;
    }

    // 切割路径上的值
    private boolean stepIsTrue(String path){
        int size = numList.size();
        if (size <= 1){
            return true;
        }
        return isTwoNumAdd(numList.get(size - 1),numList.get(size - 2),path);
    }

    private boolean isTwoNumAdd(String one,String two,String ret){

        int oneLen = one.length();
        int twoLen = two.length();
        if ( oneLen > ret.length() || twoLen > ret.length()) return false;

        char[] firstChars = oneLen >= twoLen ? one.toCharArray() : two.toCharArray();
        char[] secondChars = oneLen < twoLen ? one.toCharArray() : two.toCharArray();

        int firstLen = Math.max(oneLen, twoLen);
        int secondLen = Math.min(oneLen, twoLen);

        StringBuilder tempRet = new StringBuilder();

        int preCarry = 0;

        while (--firstLen >= 0){

            int fInt = firstChars[firstLen] - '0';
            int sInt = 0;
            if ( --secondLen >= 0 ) {
                sInt = secondChars[secondLen] - '0';
            }
            int num = fInt + sInt + preCarry;
            String onceRet = String.valueOf(num);
            tempRet.insert(0,onceRet.charAt(onceRet.length() - 1));
            if (num >= 10) preCarry = onceRet.charAt(0) - '0';
            else preCarry = 0;
        }

        if (preCarry > 0){
            tempRet.insert(0,preCarry);
        }

        return tempRet.toString().equals(ret);

    }


    @Test
    public void test(){
//        int n = ' ';
//        System.out.println(n);
//        System.out.println(isAdditiveNumber("112358"));
//        System.out.println(isAdditiveNumber("112"));
//        System.out.println(isAdditiveNumber("199100199"));
//        System.out.println(isAdditiveNumber("1991000199299498797"));
//        System.out.println(isAdditiveNumber("11235813213455890144"));
//        System.out.println(isAdditiveNumber("0"));
//        System.out.println(isAdditiveNumber("1"));
//        System.out.println(isAdditiveNumber("10"));
//        System.out.println(isAdditiveNumber("11"));
//        System.out.println(isAdditiveNumber("113"));
//        System.out.println(isAdditiveNumber("1023"));
//        System.out.println(isAdditiveNumber("1203"));
//        System.out.println(isAdditiveNumber("0235813"));
//        System.out.println(isAdditiveNumber("199001200"));
//        System.out.println(isAdditiveNumber("120122436"));
//        System.out.println(isAdditiveNumber("121202436"));
//        System.out.println(isAdditiveNumber("121224036"));
//        System.out.println(isAdditiveNumber("19910011992"));
//        System.out.println(isAdditiveNumber("199100199299"));
//        System.out.println(isAdditiveNumber("1991000199299498797"));
//        System.out.println(isAdditiveNumber("2461016264268110179"));
//        System.out.println(isAdditiveNumber("11235813213455890144"));
//        System.out.println(isAdditiveNumber("101"));
//        System.out.println(isAdditiveNumber("11111111111111111111111111111111111112111111111111111111111111111111111111122"));
//        System.out.println(tempStore);
//        System.out.println(Integer.parseInt("03".substring(0, 2)));
//        System.out.println(isTwoNumAdd("1111111111111111111111111111111111111", "1", "1111111111111111111111111111111111113"));
//        System.out.println(isTwoNumAdd("1", "9999999999999999999999999999999999999", "10000000000000000000000000000000000000"));
//        System.out.println(isAdditiveNumber("1999999999999999999999999999999999999910000000000000000000000000000000000000"));
        System.out.println(isAdditiveNumber("1999999999999999999999999999999999999910000000000000000000000000000000000000"));
    }

}
