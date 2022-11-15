package indi.xm.jy.acwing.questions.singlelinkedlist.s1560;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.singlelinkedlist.s1560
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 翻转链表
 * @Date: 2022/11/15 14:48
 */
public class Main {

    static class Struct{
        String address;
        int data;
        String next;

        public Struct(String address,int data,String next){
            this.address = address;
            this.data = data;
            this.next = next;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] f = br.readLine().split(" ");
        String faddr = f[0];
        int N = Integer.parseInt(f[1]);
        int K = Integer.parseInt(f[2]);
        HashMap<String, Struct> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            String addr = line[0];
            int data = Integer.parseInt(line[1]);
            String next = line[2];
            Struct struct = new Struct(addr, data, next);
            map.put(addr,struct);
        }
        List<Struct> linkedList = new ArrayList<>();
        while (map.get(faddr) != null){
            Struct struct = map.get(faddr);
            linkedList.add(struct);
            faddr = struct.next;
        }
        int i = 0;
        int lastEnd = 0;
        while (i + K - 1 < linkedList.size()){
            int mid = (K-1)/2;
            for (int j = 0; j <= mid; j++) {
                Collections.swap(linkedList,i + j,i + K - 1 - j);
            }
            for (int j = lastEnd; j < lastEnd + K; j++) {
                linkedList.get(j).next = linkedList.get(j+1).address;
            }
            lastEnd = i;
            i = i + K;
        }

        for (int j = lastEnd; j < linkedList.size() ; j++) {
            if (j == linkedList.size() - 1) {
                linkedList.get(j).next = "-1";
                break;
            }
            linkedList.get(j).next = linkedList.get(j+1).address;
        }

        // 输出
        for (Struct struct : linkedList) {
            System.out.println(struct.address + " " + struct.data + " " + struct.next);
        }
    }


    public static void main1(String[] args) {

        List<Integer> linkedList = new ArrayList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        int K = 3;
        int i = 0;
        while (i + K - 1 < linkedList.size()){
            int mid = (K - 1)/2;  ;
            for (int j = 0; j <= mid; j++) {
                Collections.swap(linkedList,i + j,i + K - 1 - j);
            }
            i = i + K;
        }

        for (Integer integer : linkedList) {
            System.out.println(integer);
        }
    }
}
