package indi.xm.ds_algo.competition.weekcompetition.th315;

public class SN0003_1 {

    public boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; i++) {
            if (i + reserveNum(i) == num) {
                return true;
            }
        }
        return false;
    }

    public int reserveNum(int num){
        int res = 0;
        while (num != 0){
            res = res * 10 + num % 10;
            num = num / 10;
        }
        return res;
    }

}
