package indi.xm.jy.leetcode.sn.SN0400;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0273
 * @Author: albert.fang
 * @Description: 整数转换英文表示
 * @Date: 2021/10/11 10:12
 */
public class SN0273 {
    String[] oneToTwenty = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ",
            "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen ", "Twenty "};
    String[] tens = {"", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    String[] thousands = {"", "Thousand ", "Million ", "Billion "};//""，千，百万，十亿

    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        if (num < 1000){
            return lessThousand(num);
        }
        StringBuilder res = new StringBuilder();
        int thousandIndex = 0;
        while (num > 0){
            // 每三位截取
            if (num % 1000 != 0){
                res.insert(0,lessThousand(num % 1000) + thousands[thousandIndex]);
            }
            num = num / 1000;
            thousandIndex ++;
        }
        return res.toString().trim();
    }

    // 1000 以下单独处理
    private String lessThousand(int num){
        if (num == 0){
            return "";
        }
        if (num <= 20){
            return oneToTwenty[num];
        }
        else if (num < 100){
            return tens[num/10] + lessThousand(num%10);
        }
        else{
            return oneToTwenty[num/100] + "Hundred " + lessThousand(num%100);
        }
    }
}
