package indi.xm.ds_algo.competition.oddweekcompetition.th92.sn3;

/**
 * t3
 */
public class Solution {

    public int bestClosingTime(String customers) {
        int ans = Integer.MAX_VALUE,minTime = Integer.MAX_VALUE;
        for (int i = 0; i < customers.length(); i++) {
            int cost = 0;
            for (int j = 0; j < customers.length(); j++) {
                if (j>=i && customers.charAt(j) == 'Y') cost ++;
                if (j < i && customers.charAt(j) == 'N') cost ++;
            }
            if (cost < ans) {
                ans = cost;
                minTime = i;
            }
        }
        int cost = 0;
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'N') cost ++;
        }
        if (cost < ans) {
            ans = cost;
            minTime = customers.length();
        }
        return minTime;
    }

}
