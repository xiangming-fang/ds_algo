package indi.xm.jy.leetcode.competition.weekcompetition.th270;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SN0001 {

    public int[] findEvenNumbers(int[] digits) {
        HashSet<Integer> res = new HashSet<>();
        StringBuilder path = new StringBuilder();
        boolean[] visited = new boolean[digits.length];
        findEvenNumbers(res,path,digits,visited);
        int[] resArr = new int[res.size()];
        ArrayList<Integer> list = new ArrayList<>(res);
        for (int i = 0; i < list.size(); i++) {
            resArr[i] = list.get(i);
        }
        Arrays.sort(resArr);
        return resArr;
    }

    private void findEvenNumbers(HashSet<Integer> res, StringBuilder path, int[] digits,boolean[] visited) {
        if (checkLegal(path)){
            res.add(Integer.valueOf(path.toString()));
            return;
        }
        if (path.length() >= 3){
            return;
        }
        for (int i = 0; i < digits.length; i++) {

            if (visited[i]){
                continue;
            }
            if (digits[i] == 0 && path.length() == 0){
                continue;
            }
            path.append(digits[i]);
            visited[i] = true;
            findEvenNumbers(res,path,digits,visited);
            path.deleteCharAt(path.length() - 1);
            visited[i] = false;
        }
    }


    private boolean checkLegal(StringBuilder sb){
        if (sb.length() == 3){
            int ans = Integer.parseInt(sb.toString());
            return (ans & 1) == 0;
        }
        return false;
    }

    @Test
    public void test(){
//        System.out.println(Arrays.toString(findEvenNumbers(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(findEvenNumbers(new int[]{2,1,3,0})));
        System.out.println(Arrays.toString(findEvenNumbers(new int[]{2,2,8,8,2})));
        System.out.println(Arrays.toString(findEvenNumbers(new int[]{3,7,5})));
    }


}
