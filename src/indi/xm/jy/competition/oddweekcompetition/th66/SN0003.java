package indi.xm.jy.competition.oddweekcompetition.th66;

import org.junit.Test;

public class SN0003 {

    // 2081ms
    public int minimumBuckets(String street) {
        if (street.equals("H") || street.startsWith("HH") || street.endsWith("HH") || street.contains("HHH")){
            return -1;
        }
        int ret = 0;

        int index = 0;

        while (index < street.length()){

            // 如果这个字符串表示房屋
            if (street.charAt(index) == 'H'){
                // 首先尝试在该字符右边放置水桶
                if (index + 1 < street.length() && street.charAt(index + 1) == '.'){
                    // 检查一下左边有没有水桶（左边有就可以不要放了呀）
                    if (index - 1 < 0 || (street.charAt(index - 1) != 'X')){
                        street = concat(street,index + 1,'X');
                        ret ++;
                    }
                }

                // 再尝试在该字符左边放置水桶
                if (index - 1 >= 0 && street.charAt(index - 1) == '.'){
                    // 检查一下右边有没有水桶（右边有就可以不要放了呀）
                    if (index + 1 >= street.length() || (street.charAt(index + 1) != 'X')){
                        street = concat(street,index - 1,'X');
                        ret ++;
                    }
                }
            }
            index ++;
        }

        return ret;
    }

    private String concat(String s,int index,char c){
        s = s.substring(0,index) + c + s.substring(index + 1);
        return s;
    }

    // 题解过来的 7ms
    public int minimumBuckets02(String street) {
        if ("H".equals(street) || street.startsWith("HH") || street.endsWith("HH") || street.contains("HHH")) {
            return -1;
        }

        int res = 0;
        for (char c : street.toCharArray()) {
            if (c == 'H') {
                ++res;
            }
        }
        // 很巧妙
        for (int i = 0; i < street.length() - 2; ++i) {
            if (street.charAt(i) == 'H' && street.charAt(i+1)=='.' && street.charAt(i+2)=='H') {
                --res;
                i += 2;
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(minimumBuckets("H.H.H.H.H.H"));
        System.out.println(minimumBuckets02("H.H.H.H.H.H"));
    }

}
