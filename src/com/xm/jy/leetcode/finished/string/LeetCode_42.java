package com.xm.jy.leetcode.finished.string;

/**
 * @author: albert.fang
 * @date: 2020/7/27 9:46
 * @description: 1108. IP 地址无效化
 * @description: 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 */
public class LeetCode_42 {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }

    public String defangIPaddr2(String address) {
        StringBuilder builder = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.'){
                builder.append("[.]");
            }else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
