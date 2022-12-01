package indi.xm.ds_algo.competition.acwing.th78.t3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * t3
 */
public class Main {

    // 思路：单调栈
    // 题意简化：找到最右边比当前位置小的元素位置。我们规定当前位置为i，最右边比当前位置小的为j，那么两位置的中间隔开 j - i - 1 个元素。
    // 1、首先我们分析下为什么可以用单调栈？
    // 1.1 例子1
    // 我们随意输入一组数据：10 8 5 3 50 45
    // 我们先不考虑如何做这道题，我们先直接从这组数据找到最右边比当前值小的元素（注意，这里是元素，并非是元素位置，不存在的话记为-1）
    // 我们可以很容易得到：3 3 3 -1 45 -1，我们可以看见在得到的答案中除了没有答案的，是单调递增的。
    // 1.2 例子2
    // 我们依然可以再随意输入一组数据：10 4 6 3 2 8 15
    // 得到答案：2 2 2 2 -1 -1 -1，忽略没有找到答案的，我们依然可以发现是单调递增的。
    // 1.3 做推广
    // 假设一组数据是 [ 4,5,6,2,3,1,x,3,2,4,5,6,y] 其中如果x和y是答案，那么x，y必然是单调递增的，y肯定比x大，那么x可以作为x左侧的目标值，y可以作为y左侧到x之前的目标值。
    // 所以我们可以遍历数组，维护一个单调递增的栈，这样就可以得到：[x,y]
    // 2、第一步已经分析了单调栈以及如何维护了，但是题目要求是求两个元素之间间隔了几个元素，所以我们单调栈里存放的应该是元素的下标，而非具体元素值
    // 3、再次遍历原素组，用二分法从维护的单调栈中找到目标下标。
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int N = 100010;
        // 维护的单调栈
        int[] stk = new int[N];
        // 单调栈的栈顶
        int tt = 0;
        int[] origin = new int[n];
        // 存储比当前位置小的最右边元素位置
        int[] ans = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            origin[i] = Integer.parseInt(s[i]);
            while (tt > 0 && origin[i] <= origin[stk[tt]]) tt--;
            stk[++tt] = i;
        }
        for (int i = 0; i < n; i++) {
            int l = 1,r = tt;
            while (l < r){
                int mid = l + (r-l + 1)/2;
                // 如果当前元素大于单调栈中间位置的小标对应位置元素，那么 l = mid
                // 因为是维护的栈是单调递增的，所以我们应该尽可能找右边元素，这样才是距离i位置最远的。
                if (origin[i] > origin[stk[mid]]) l = mid;
                else r = mid - 1;
            }
            // 判断找到的位置合法性，要在i右边，并且 小于 当前位置元素
            if (stk[l] > i && origin[stk[l]] < origin[i]) ans[i] = stk[l];
            else ans[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            if (ans[i] == -1) System.out.print(ans[i] + " ");
            else System.out.print(ans[i] - i - 1 + " ");
        }

    }

}
