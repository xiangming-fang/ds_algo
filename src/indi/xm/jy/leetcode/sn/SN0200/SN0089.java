package indi.xm.jy.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0089
 * @Author: albert.fang
 * @Description: 格雷编码
 * @Date: 2021/11/19 15:16
 */
public class SN0089 {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            res.add(gray(i));
        }
        return res;
    }

    private int gray(int num){
        return num ^ (num >> 1);
    }

    @Test
    public void test(){
        // 左移1位，扩大2倍
        System.out.println(2 << 3 );
        // 右移1位，缩小1/2
        System.out.println(16 >> 3 );
    }
}
