package indi.xm.jy.leetcode.sn.SN0400;

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
    public boolean isAdditiveNumber(String num) {
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

    @Test
    public void test(){
//        System.out.println(isAdditiveNumber("112358"));
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
        System.out.println(isAdditiveNumber("11111111111111111111111111111111111112111111111111111111111111111111111111122"));
        System.out.println(tempStore);
//        System.out.println(Integer.parseInt("03".substring(0, 2)));
    }

}
