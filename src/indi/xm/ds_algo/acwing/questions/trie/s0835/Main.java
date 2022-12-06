package indi.xm.ds_algo.acwing.questions.trie.s0835;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: albert.fang
 * @Description: Trie 字符串统计
 * @Date: 2022/12/5 16:53
 */
public class Main {


    public static void main(String[] args) throws IOException {
        Trie trie = new Trie();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0){
            String[] s = br.readLine().split(" ");
            if ("I".equals(s[0])) {
                trie.add(s[1]);
            }else {
                System.out.println(trie.getCount(s[1]));
            }
        }
    }


    static class Trie{

        class Node{
            int count;
            Map<Character,Node> next;

            public Node(){
                this.count = 0;
                this.next = new HashMap<>();
            }
        }

        Node dm = new Node();

        public void add(String s){
            Node cur = dm;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (cur.next.get(c) == null) cur.next.put(c,new Node());
                cur = cur.next.get(c);
            }
            cur.count ++;
        }

        public int getCount(String s){
            Node cur = dm;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (cur.next.get(c) == null) return 0;
                else cur = cur.next.get(c);
            }
            return cur.count;
        }
    }


}
