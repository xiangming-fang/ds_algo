package indi.xm.ds_algo.competition.weekcompetition.th83.sn2;

/**
 * t2
 */
public class Solution {

    public String maskPII(String s) {
        StringBuilder ans = new StringBuilder();
        if (s.contains("@")){
            String[] email = s.split("@");
            ans.append(Character.toLowerCase(email[0].charAt(0))).append("*****").append(Character.toLowerCase(email[0].charAt(email[0].length() - 1)));
            ans.append("@");
            for (int i = 0; i < email[1].length(); i++) {
                ans.append(Character.toLowerCase(email[1].charAt(i)));
            }
        }else {
            int tmp = 10;
            int gn = 0;
            for (int length = s.length() - 1; length >= 0; length--) {
                if (tmp > 0 && s.charAt(length) >= '0' && s.charAt(length) <= '9') {
                    tmp --;
                }
                else if (s.charAt(length) >= '0' && s.charAt(length) <= '9'){
                    gn ++;
                }
            }
            if (gn == 1){
                ans.append("+*-***-***-");
            }
            else if (gn == 2){
                ans.append("+**-***-***-");
            }
            else if (gn == 3){
                ans.append("+***-***-***-");
            }
            else {
                ans.append("***-***-");
            }
            int i = 0;
            char[] f = new char[4];
            for (int length = s.length() - 1; length >= 0; length--) {
                if (i >= 4) break;
                if (s.charAt(length) >= '0' && s.charAt(length) <= '9') {
                    f[i++] = s.charAt(length);
                }
            }
            for (int j = f.length - 1; j >= 0; j--) {
                ans.append(f[j]);
            }
        }

        return ans.toString();
    }
}
