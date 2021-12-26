package indi.xm.jy.leetcode.competition.weekcompetition.th273;

import org.junit.Test;

import java.util.Arrays;

public class SN0002 {

    int rows,cols;

    // 上右下左
    int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    public int[] executeInstructions(int n, int[] startPos, String s) {
        rows = n;
        cols = n;
        int[] ret = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ret[i] = validateExecuteNums(startPos,s,i);
        }
        return ret;
    }

    private int validateExecuteNums(int[] startPos,String s,int startIndex){
        int res = 0;
        int[] newStartPos = new int[2];
        int[] temp = startPos;

        for (int i = startIndex; i < s.length(); i++) {
            switch (s.charAt(startIndex)){
                case 'U':
                    newStartPos[0] = temp[0] + directions[0][0];
                    newStartPos[1] = temp[1] + directions[0][1];
                    break;
                case 'R':
                    newStartPos[0] = temp[0] + directions[1][0];
                    newStartPos[1] = temp[1] + directions[1][1];
                    break;
                case 'D':
                    newStartPos[0] = temp[0] + directions[2][0];
                    newStartPos[1] = temp[1] + directions[2][1];
                    break;
                case 'L':
                    newStartPos[0] = temp[0] + directions[3][0];
                    newStartPos[1] = temp[1] + directions[3][1];
                    break;
                default:
                    throw new RuntimeException("exception");
            }
            if (isIllegalPos(newStartPos)){
                break;
            }
            temp = newStartPos;
            res ++;
        }
        return res;
    }

    private boolean isIllegalPos(int[] startPos){
        int row = startPos[0],col = startPos[1];
        return row < 0 || row >= rows || col < 0 || col >= cols;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(executeInstructions(3, new int[]{0, 1}, "RRDDLU")));
    }

}
