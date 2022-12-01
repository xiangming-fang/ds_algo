package indi.xm.ds_algo.competition.oddweekcompetition.th91;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description: 根据限制分割消息
 * @Date: 2022/10/21 16:26
 */
public class SN0004 {

    // 思路：找规律 + 数学
    // <1/k>、<2/k>、<3/k>、<4/k>、<5/k>……<k/k>
    // 1、我们可以发现在上面的所有后缀中，有三部分是固定的即："<"、">"、"/"
    // 2、除了第一步固定的三个以外，我们还能看见，每个部分都有个k,这里设k的长度为len(k)
    // 3、还有一部分是：1、2、3、4……k
    //    针对这一部分，我们可以知道，只有一位的有9个数字，分别是1-9
    //    只有两位数的有90个数，分别是10-99
    //    依次类推：3位数的有900个，4位数的有9000个
    //    我们这里是数字是k,长度为len(k)，所以从1……k的总个数是可以推导出来的，设为：x
    // 4、总共k部分，每部分的长度是limit，待分割字符串 message 长度为n,所以满足以下公式即为可以分割
    //    (limit - 3 - len(k)) * k - x >= n
    // 5、1-4 步是这题数学的核心思想
    // 6、因为题目说结果数组越短越好，就说明分割的子串越大越好，说明我们可以使子串从1-n进行分割，第一个符合分割条件的即为结果。
    public String[] splitMessage(String message, int limit) {
        int n = message.length();
        for (int i = 1; i <= n; i++) {
            // 结果数组越短越好，说明分的页数越少越好，这里的i就是页数
            if (get(i,limit) >= n){
                String[] ans = new String[i];
                // 从第j=1页到j=i页
                for(int j = 1,k = 0; k < n && j <= i; j++){
                    String suffix = "<" + j + "/" + i + ">";
                    // 因为最后一个位置长度可以小于等于limit
                    int mesLen = Math.min(limit-suffix.length(),n-k);
                    ans[j-1] = message.substring(k,k + mesLen) + suffix;
                    k = k + mesLen;
                }
                return ans;
            }
        }
        return new String[0];
    }

    public int get(int k,int limit){
        int kLen = String.valueOf(k).length();
        int ans = (limit - 3 - kLen) * k;
        // 计算从1-k，总共有几位数
        int bits = 0;
        int b = 0;
        for (int i = 1; i < kLen; i++) {
            bits += 9 * Math.pow(10, i - 1) * i;
            b += 9 * Math.pow(10, i - 1);
        }
        bits += (k - b) * kLen;
        return ans - bits;
    }


    @Test
    public void test() {
        int x = 1234;
        int len = String.valueOf(x).length();
        int bits = 0;
        int b = 0;
        for (int i = 1; i < len; i++) {
            bits += 9 * Math.pow(10, i - 1) * i;
            b += 9 * Math.pow(10, i - 1);
        }
        bits += (x - b) * len;
        System.out.println(bits);
    }
}
