package indi.xm.ds_algo.leetcode.offer.sn0067;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: albert.fang
 * @Description: 最大异或对
 * @Date: 2022/12/6 13:30
 */
public class Solution {
    
    public int findMaximumXOR(int[] nums) {
        int max = -1;
        Trie trie = new Trie();
        for (int num : nums) {
            trie.add(fillZero(Integer.toBinaryString(num)));
        }
        for (int num : nums) {
            max = Math.max(max, binaryToInt(trie.getXor(fillZero(Integer.toBinaryString(num)))));
        }
        return max;
    }

    public String fillZero(String s){
        int n = 32 - s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('0');
        }
        sb.append(s);
        return sb.toString();
    }

    public int binaryToInt(String binary){
        int x = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') x += (1 << (31-i));
        }
        return x;
    }

    class Trie{

        class Node{
            Map<Character, Node> next;

            public Node(){
                this.next = new HashMap<>();
            }
        }

        Node dm = new Node();

        char one = '1';
        char zero = '0';

        public void add(String s){
            Node cur = dm;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (cur.next.get(c) == null) cur.next.put(c,new Node());
                cur = cur.next.get(c);
            }
        }

        public String getXor(String s){
            StringBuilder sb = new StringBuilder();
            Node cur = dm;
            int i = 0;
            while (!cur.next.isEmpty()){
                char c = s.charAt(i++);
                if (c == one && cur.next.get(zero) != null) {
                    cur = cur.next.get(zero);
                    sb.append(one);
                }
                else if (c == zero && cur.next.get(one) != null) {
                    cur = cur.next.get(one);
                    sb.append(one);
                }
                else {
                    cur = cur.next.get(c);
                    sb.append(zero);
                }
            }
            return sb.toString();
        }
    }
    
}
