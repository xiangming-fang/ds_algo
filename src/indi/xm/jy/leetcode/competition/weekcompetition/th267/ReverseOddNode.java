package indi.xm.jy.leetcode.competition.weekcompetition.th267;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th267
 * @ClassName: ResverseOddNode
 * @Author: albert.fang
 * @Description: 5927. 反转偶数长度组的节点
 * @Date: 2021/11/14 10:54
 */
public class ReverseOddNode {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        reverseEven(fast,slow,1);
        return head;
    }

    // tempArray 可能没填满，增加tempIndex进行判断
    private void reverseEven(ListNode fast, ListNode slow, int steps) {
        int[] tempArray = new int[steps + 1];
        int tempIndex = 0;
        for (int i = 0; i <= steps; i++) {
            if (fast == null){
                break;
            }
            fast = fast.next;
            if (fast == null){
                break;
            }
            tempArray[i] = fast.val;
            tempIndex = i;
        }
        // 要进行翻转
        if ((tempIndex + 1) % 2 == 0){
            for (int i = tempIndex; i >= 0; i--){
                if (slow == null){
                    return;
                }
                slow = slow.next;
                if (slow == null){
                    return;
                }
                slow.val = tempArray[i];
            }
        }else {
            for (int i = 0; i <= tempIndex; i++) {
                if (slow == null){
                    return;
                }
                slow = slow.next;
            }
        }
        reverseEven(fast,slow,steps + 1);
    }


    private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    @Test
    public void test(){
    }
}
