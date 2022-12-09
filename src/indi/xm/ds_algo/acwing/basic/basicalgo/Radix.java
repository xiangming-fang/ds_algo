package indi.xm.ds_algo.acwing.basic.basicalgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: albert.fang
 * @Description: 进制转换
 * @Date: 2022/12/9 16:28
 */
public class Radix {

    // 短除法
    // 将十进制的num转成radix进制的数
    public List<Integer> convertRadix(int num,int radix){
        List<Integer> ans = new ArrayList<>();
        while (num != 0){
            ans.add(num%radix);
            num /= radix;
        }
        Collections.reverse(ans);
        return ans;
    }
}
