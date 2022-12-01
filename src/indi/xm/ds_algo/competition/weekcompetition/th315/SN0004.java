package indi.xm.ds_algo.competition.weekcompetition.th315;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

public class SN0004 {

    // 1、找到nums小于mink或者大于maxk的所有元素下标
    // 2、以第一步找到的所有下标可以将nums数组分割成若干区间
    // 3、筛选合法区间，合法区间的条件是：区间必须要有一个minK并且只要要有一个maxK
    // 4、计算每个合法区间有几个定界子数组
        // 4.1 以每个合法区间的元素为最后元素
        // 4.2 minK上一次出现的位置是minI;maxK上一次出现的位置是maxI.
        // 4.3 若遍历到当前位置已经存在minI并且存在maxI了，那么定界子数组的个数是min(minI,maxI) + 1
    public long countSubarrays(int[] nums, int minK, int maxK) {
        AtomicLong res = new AtomicLong();
        ArrayList<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK){
                indexs.add(i);
            }
        }
        int pre = -1;
        // 装合法区间：key -> value
        HashMap<Integer, Integer> legalArea = new HashMap<>();
        for (Integer index : indexs) {
            if (index - pre > 1 && containMinKAndMaxK(nums, pre + 1, index - 1, minK, maxK)) {
                legalArea.put(pre + 1, index - 1);
            }
            pre = index;
        }
        if (nums.length - pre > 1 && containMinKAndMaxK(nums,pre + 1, nums.length - 1,minK,maxK)){
            legalArea.put(pre + 1,nums.length -1);
        }
        if (indexs.isEmpty()){
            legalArea.put(0,nums.length - 1);
        }
        // 计算每个合法区间有几个定界子数组
        legalArea.forEach((start,end) -> {
            int minI = -1,maxI = -1;
            for (int j = start; j <= end; j ++){
                if (nums[j] == minK) {
                    minI = j;
                }
                if (nums[j] == maxK){
                    maxI = j;
                }
                if (maxI != -1 && minI != -1){
                    res.addAndGet(Math.min(maxI, minI) - start + 1);
                }
            }
        });
        return res.get();
    }

    public boolean containMinKAndMaxK(int[] arr,int startIdx,int endIdx,int minK,int maxK){
        boolean flagMinK = false,flagMaxK = false;
        for (int i = startIdx; i <= endIdx; i ++){
            if (flagMaxK && flagMinK){
                break;
            }
            if (arr[i] == minK){
                flagMinK = true;
            }
            if (arr[i] == maxK){
                flagMaxK = true;
            }
        }
        return flagMaxK && flagMinK;
    }

    @Test
    public void test(){
//        System.out.println(countSubarrays(new int[]{1, 3, 5,2,7,5}, 1, 5));
        System.out.println(countSubarrays(new int[]{1,1,1,1}, 1, 1));
    }

}
