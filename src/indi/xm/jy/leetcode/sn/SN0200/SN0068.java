package indi.xm.jy.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0068
 * @Author: albert.fang
 * @Description: 文本左右对齐
 * @Date: 2021/9/9 9:35
 */
public class SN0068 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int idx = 0;
        List<String> row = new ArrayList<>();
        row.add(words[idx]);
        while (true){
            if (idx + 1 < words.length && getLen(row) + 1 + words[idx + 1].length() <= maxWidth){
                row.add(words[++idx]);
            }
            else if (idx + 1 < words.length && getLen(row) + 1 + words[idx + 1].length() > maxWidth){
                res.add(getRow(row,maxWidth));
                row.clear();
                row.add(words[++idx]);
            }
            if (idx == words.length - 1) {
                res.add(getLastRow(row,maxWidth));
                break;
            }
        }
        return res;
    }

    private String getLastRow(List<String> row,int maxLen){
        StringBuilder res = new StringBuilder();
        for (String s : row) {
            res.append(s);
            if (res.length() < maxLen){
                res.append(" ");
            }
        }
        int len = maxLen - res.length();
        res.append(concat(len));
        return res.toString();
    }

    private String getRow(List<String> row,int maxLen){
        int wordNum = row.size();
        int len = getLen(row);
        // 空格数量
        int spaceNum = maxLen - len + row.size() - 1;
        if (wordNum == 1){
            return row.get(0) + concat(spaceNum);
        }
        // 需要放入空格的区域数量
        int needSpace = row.size() - 1;
        // 平分的话，每个区域放几个空格
        int singleSpaceNum = spaceNum / needSpace;
        // 平分之后剩余几个
        int remainNums = spaceNum % needSpace;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < row.size(); i++) {
            res.append(row.get(i));
            if (i != row.size() - 1){
                // 尽可能的让空格平均
                if (i <= remainNums - 1){
                    res.append(concat(singleSpaceNum + 1));
                }else {
                    res.append(concat(singleSpaceNum));
                }
            }
        }
        return res.toString();
    }

    private String concat(int len){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            res.append(" ");
        }
        return res.toString();
    }


    private int getLen(List<String> row){
        int res = row.size() - 1;
        for (String s : row) {
            res += s.length();
        }
        return res;
    }

    // 不加空格的做法（和题目不符）
    public List<String> fullJustify01(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(words[idx]);
        while (true){
            if (idx + 1 < words.length && sb.length() + words[idx + 1].length() <= maxWidth){
                sb.append(words[++idx]);
            }
            else if (idx + 1 < words.length && sb.length() + words[idx + 1].length() > maxWidth){
                res.add(sb.toString());
                sb = new StringBuilder();
                sb.append(words[++idx]);
            }
            if (idx == words.length - 1) {
                res.add(sb.toString());
                break;
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
        System.out.println(fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16));
        System.out.println(fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20));
        System.out.println(fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20));
    }

}
