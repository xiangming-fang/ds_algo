package indi.xm.ds_algo.leetcode.sn.SN1000;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1000
 * @ClassName: SN0754
 * @Author: albert.fang
 * @Description: 到达终点数字
 * @Date: 2022/11/4 14:28
 */
public class SN0754 {

    // 灵神题解：https://leetcode.cn/problems/reach-a-number/solutions/1947254/fen-lei-tao-lun-xiang-xi-zheng-ming-jian-sqj2/
    // 主要点：
    // 1、如果第n步恰好到target，那就是n步
    // 2、如果越过target，看看 距离target的距离 记为 dt
    // 3、如果dt是偶数，那么步数也为n，我们只需要将 第 dt/2 步反着走就好。
    // 4、如果dt为奇数，则再多走一步，此时 dt = dt + 多走的一步
    // 5、再对此时的dt进行判断，如果为偶数，则总共需要走n+1
    // 6、如果依然为奇数，则再走一步，必然是偶数，因为是1，2，3，4……这样走的，此时结果应该是n+2
    public int reachNumber(int target) {
        target = Math.abs(target);
        int ans = 0,n = 0;
        while (ans < target || (ans - target & 1) == 1){
            n ++;
            ans += n;
        }
        return n;
    }

}
