package indi.xm.ds_algo.leetcode.sn.SN0400;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0282
 * @Author: albert.fang
 * @Description: 给表达式添加运算符
 * @Date: 2021/11/22 17:34
 */
public class SN0282 {

    List<String> res = new ArrayList<>();

    // 辅助计算表达式的
    // key - 运算符
    // value - 运算符优先级
    HashMap<Character,Integer> opSet = new HashMap<Character,Integer>(){{
       put('+',0);
       put('-',0);
       put('*',1);
    }};

    public List<String> addOperators(String num, int target) {
        dfs(num,target,new ArrayList<String>());
        return res;
    }

    private void dfs(String num, int target, ArrayList<String> single) {

        if (Objects.equals(num, "") && parseExpression(single) == target){
            res.add(parseStringList(single));
            System.out.println("找到了 " + single);
            return;
        }

        if (Objects.equals(num,"")){
            return;
        }

        for (String op : Stream.of("+","-","*").collect(Collectors.toList())) {
            if (!single.isEmpty() && !Objects.equals(single.get(single.size() - 1), "+")
                    && !Objects.equals(single.get(single.size() - 1), "-")
                    && !Objects.equals(single.get(single.size() - 1), "*")){
                single.add(op);
            }
            for (int i = 1; i < num.length(); i++) {
                if (!Objects.equals(single.get(single.size() - 1), "+")
                        && !Objects.equals(single.get(single.size() - 1), "-")
                        && !Objects.equals(single.get(single.size() - 1), "*")){
                    continue;
                }
                single.add(num.substring(0,i));
                System.out.println(single);
                dfs(num.substring(i),target,single);
                single.remove(single.size() - 1);
                System.out.println("回溯 " + single);
            }
        }
    }

    // expression 解析表达式 eg： ["1","+","2"]
    private int parseExpression(List<String> expression){
        if (expression.size() == 0){
            return 0;
        }
        // opNumStack 操作数栈
        Stack<Integer> opNumStack = new Stack<>();
        // opStack 运算符
        Stack<Character> opStack = new Stack<>();
        for (String s : expression) {
            if (opSet.containsKey(s.charAt(0))) {
                if (!opStack.isEmpty()) {
                    // 当前要入栈的运算符优先级
                    Character cur = s.charAt(0);
                    Integer curPriority = opSet.get(cur);
                    // 如果当前要入栈的运算符优先级小于栈顶元素
                    // 栈顶要先出栈，并计算
                    while (curPriority < opSet.get(opStack.peek())) {
                        Integer num1 = opNumStack.pop();
                        Integer num2 = opNumStack.pop();
                        // 只是做出栈操作，在这肯定为 *
                        Character op = opStack.pop();
                        opNumStack.push(num1 * num2);
                    }
                    opStack.push(cur);
                } else {
                    // opStack 为空 直接加入
                    opStack.push(s.charAt(0));
                }
            } else {
                // 数字的话，直接加入opNum
                opNumStack.push(Integer.parseInt(s));
            }
        }
        while (!opStack.isEmpty()){
            Character op = opStack.pop();
            Integer lastInt = opNumStack.pop();
            Integer secondLastInt = opNumStack.pop();
            if (op == '+'){
                opNumStack.push(lastInt + secondLastInt);
            }
            if (op == '-'){
                opNumStack.push(secondLastInt - lastInt);
            }
            if (op == '*'){
                opNumStack.push(lastInt * secondLastInt);
            }
        }

        return opNumStack.pop();
    }

    // 将single拼接转成String
    private String parseStringList(ArrayList<String> single){
        StringBuilder sb = new StringBuilder();
        for (String s : single) {
            sb.append(s);
        }
        return sb.toString();
    }


    @Test
    public void test(){
        System.out.println(addOperators("123", 6));
//        System.out.println(addOperators("123", 8));
//        System.out.println(parseExpression(Stream.of("1", "+", "2", "*", "30").collect(Collectors.toList())));
//        System.out.println(parseExpression(Stream.of("1", "+", "2", "*", "30","*","2","+","4").collect(Collectors.toList())));
//        System.out.println(parseExpression(Stream.of("11", "+", "4", "*", "30","*","2","+","4").collect(Collectors.toList())));
//        System.out.println(parseExpression(Stream.of("123").collect(Collectors.toList())));
//        System.out.println(parseExpression(Stream.of("1","*","2","*","3").collect(Collectors.toList())));
    }
}
