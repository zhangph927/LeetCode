package 栈.全局单调栈.q1124_表现良好的最长时间段;

import java.util.Stack;

/**
 * @ClassName : Solution
 * @Description :1124. 表现良好的最长时间段
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 *
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 *
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 *
 * 请你返回「表现良好时间段」的最大长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：hours = [9,9,6,0,6,6,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 *
 *
 * 提示：
 *
 * 1 <= hours.length <= 10000
 * 0 <= hours[i] <= 16
 * @Author : zph
 * @Date: 2020-09-14 01:16
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title longestWPI
     * @Description 前缀和+单调栈
     * @Author zph
     * @Date 2020/9/14 1:27
     * @Param [hours]
     * @return int
     */
    public int longestWPI(int[] hours) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        int[] prefixSrc = new int[hours.length + 1];
        //大于8的置为1，否则置为-1
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                max = 1;
                hours[i] = 1;
            } else {
                hours[i] = -1;
            }
            //初始化前缀和数组
            prefixSrc[0] = 0;
            prefixSrc[i + 1] = prefixSrc[i] + hours[i];
        }
        for (int i = 0; i < prefixSrc.length - 1; i++) {
            //实现单调栈
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (prefixSrc[i] < prefixSrc[stack.peek()]) {
                    stack.push(i);
                }
            }
        }
        //开始寻找,从后往前遍历
        for (int i = prefixSrc.length - 1; i >= 0; i--) {
            int last = i;
            while (!stack.isEmpty() && prefixSrc[i] > prefixSrc[stack.peek()]) {
                last = stack.pop();
            }
            if (last != i) {
                int width = i - last;
                max = Math.max(max, width);
            }
        }
        return max;

    }
}
