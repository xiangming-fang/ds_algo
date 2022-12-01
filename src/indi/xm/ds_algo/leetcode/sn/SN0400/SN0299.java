package indi.xm.ds_algo.leetcode.sn.SN0400;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0299
 * @Author: albert.fang
 * @Description: 猜数字游戏
 * @Date: 2021/11/8 9:32
 */
public class SN0299 {

    public String getHint01(String secret, String guess) {
        char[] secretArray = secret.toCharArray();
        char[] guessArray = guess.toCharArray();
        int len = secret.length();
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < len; i++) {
            if (secretArray[i] == guessArray[i]){
                // 给一个标示就好，不必非得是x
                secretArray[i] = 'x';
                guessArray[i] = 'x';
                // 对应位置相等，公牛数加1
                bulls ++;
            }
        }
        ArrayList<Character> secretList = new ArrayList<>();
        ArrayList<Character> guessList = new ArrayList<>();
        for (char c : secretArray) {
            secretList.add(c);
        }
        for (char c : guessArray) {
            guessList.add(c);
        }
        for (Character character : guessList) {
            // 要和上面指定的标示一致
            if (character == 'x'){
                continue;
            }
            if (secretList.contains(character)) {
                // 如果包含的话，移除，奶牛数 + 1
                secretList.remove(character);
                cows ++;
            }
        }
        return bulls + "A" + cows + "B";
    }


    public String getHint(String secret, String guess){
        int[] secretArray = new int[10];
        int[] guessArray = new int[10];
        int len = secret.length();
        int bulls = 0,cows = 0;
        for (int i = 0; i < len; i++) {
            int secretNum = secret.charAt(i) - '0';
            int guessNum = guess.charAt(i) - '0';
            if (secretNum == guessNum) {
                bulls ++;
            }else {
                secretArray[secretNum] ++;
                guessArray[guessNum] ++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretArray[i],guessArray[i]);
        }
        return bulls + "A" + cows + "B";
    }

    @Test
    public void test(){
        System.out.println(getHint("1807", "7810"));
        System.out.println(getHint("1123", "0111"));
    }
}
