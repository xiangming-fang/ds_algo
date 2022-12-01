package indi.xm.ds_algo.leetcode.company.meituan.campaus.ques1;

import java.util.Scanner;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.company.meituan.campaus.ques1
 * @ClassName: Ques1
 * @Author: albert.fang
 * @Description:
 * 输入： - 输入第一行包含一个正整数 T，表示需要检验的用户名数量。 - 接下来有 T 行，每行一个字符串 s，表示输入的用户名。
 * 输出： - 对于每一个输入的用户名 s，请输出一行，即按题目要求输出一个字符串。   来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/BaR9fy 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2021/12/23 20:20
 */
public class Solution {

    private static void ques1(){
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        while (row -- != 0 ){
            String name = scanner.next();
            System.out.println(check(name));
        }
        scanner.close();
    }

    private static String check(String name){
        if (name == null){
            return "Wrong";
        }
        char f = name.charAt(0);
        int numCount = 0;
        int letterCount = 0;
        if ( !(f - 'a' >= 0 && f - 'z' <= 0)){
            if ( !(f - 'A' >= 0 && f - 'Z' <= 0)){
                return "Wrong";
            }
        }
        letterCount ++;
        for (int i = 1; i < name.length(); i++) {
            if ( numCount == 0 &&  name.charAt(i) - '0' >= 0 && name.charAt(i) - '9' <= 0 ){
                numCount ++;
            }
            if ( !(name.charAt(i) - '0' >= 0 && name.charAt(i) - '9' <= 0)){
                if ( !(name.charAt(i) - 'a' >= 0 && name.charAt(i) - 'z' <= 0)){
                    if ( !(name.charAt(i) - 'A' >= 0 && name.charAt(i) - 'Z' <= 0)){
                        return "Wrong";
                    }
                }
            }
        }
        return letterCount == 1 && numCount == 1 ? "Accept" : "Wrong";
    }


    public static void main(String[] args) {
        ques1();
    }

}
