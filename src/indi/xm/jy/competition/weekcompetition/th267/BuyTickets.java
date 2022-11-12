package indi.xm.jy.competition.weekcompetition.th267;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th267
 * @ClassName: BuyTickets
 * @Author: albert.fang
 * @Description: 5926. 买票需要的时间
 * @Date: 2021/11/14 10:38
 */
public class BuyTickets {

    int res = 0;
    public int timeRequiredToBuy(int[] tickets, int k) {
        int pendingBuyTickets = tickets[k];
        dfs(tickets,pendingBuyTickets,k);
        return res;
    }

    private void dfs(int[] tickets, int pendingBuyTickets,int k) {
        if (pendingBuyTickets == 0) {
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] > 0){
                tickets[i] --;
                res ++;
                // 判断k位置是否已经为0了
                if (tickets[k] == 0){
                    return;
                }
            }
        }
        dfs(tickets,--pendingBuyTickets,k);
    }

    @Test
    public void test(){
//        System.out.println(timeRequiredToBuy(new int[]{2, 3, 2}, 2));
//        System.out.println(timeRequiredToBuy(new int[]{5,1,1,1}, 0));
        System.out.println(timeRequiredToBuy(new int[]{1,1,2,1}, 2));
    }
}
