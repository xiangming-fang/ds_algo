package indi.xm.jy.competition.weekcompetition.th272;


public class SN0001 {

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    private boolean isPalindrome(String str){
        int left = 0;
        int right = str.length() - 1;
        while (left <= right){
            if (str.charAt(left) != str.charAt(right)){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}
