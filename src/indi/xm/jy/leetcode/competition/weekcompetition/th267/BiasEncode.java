package indi.xm.jy.leetcode.competition.weekcompetition.th267;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th267
 * @ClassName: BiasEncode
 * @Author: albert.fang
 * @Description: 5928. 解码斜向换位密码
 * @Date: 2021/11/14 11:48
 */
public class BiasEncode {
    public String decodeCiphertext(String encodedText, int rows) {
        int len = encodedText.length();
        int cols = len / rows;
        char[][] board = new char[rows][cols];
        // 填充二维board
        fill(board,encodedText,0,cols);

        // 斜线解密读取
        StringBuilder sb = new StringBuilder();
        for (int col = 0; col < cols; col++) {
            for (int row = 0,j=col; row < rows && j < cols; row++,j++) {
                sb.append(board[row][j]);
            }
        }
        // 去除后置空格
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' '){
            sb.delete(sb.length()-1,sb.length());
        }
        return sb.toString();
    }

    private void fill(char[][] board, String encodedText, int row, int cols) {
        if (row == board.length){
            return;
        }
        String line = encodedText.substring(row * cols, row * cols + cols);
        for (int col = 0; col < cols; col++) {
            board[row][col] = line.charAt(col);
        }
        fill(board,encodedText,row + 1,cols);
    }

    @Test
    public void test(){
//        System.out.println(decodeCiphertext("ch   ie   pr", 3));
//        System.out.println(decodeCiphertext("iveo    eed   l te   olc", 4));
//        System.out.println(decodeCiphertext(" b  ac", 2));
//        System.out.println(decodeCiphertext("coding", 1));
        System.out.println(decodeCiphertext("", 5));
    }
}
