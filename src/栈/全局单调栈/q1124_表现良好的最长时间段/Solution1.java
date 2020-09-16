package 栈.全局单调栈.q1124_表现良好的最长时间段;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName : Solution1
 * @Description :
 * @Author : zph
 * @Date: 2020-09-14 18:03
 * @Version : V1.0
 */
public class Solution1 {
    public int longestWPI(int[] hours) {
        if (hours == null || hours.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int length = hours.length;
        int[] prefixSrc = new int[length + 1];
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (hours[i] > 8) {
                hours[i] = 1;
                max = 1;
            } else {
                hours[i] = -1;
            }
            prefixSrc[i + 1] = prefixSrc[i] + hours[i];
        }
        for (int i = 0; i < length; i++) {
            if (stack.isEmpty()) {
                stack.offerLast(i);
            } else {
                if (prefixSrc[i] < prefixSrc[stack.peekLast()]) {
                    stack.offerLast(i);
                }
            }
        }
        for (int i = length; i >= 0; i--) {
            int last = i;
            while (!stack.isEmpty() && prefixSrc[i] > prefixSrc[stack.peekLast()]) {
                last = stack.pollLast();
            }
            if (last != i) {
                max = Math.max(max, i - last);
            }
        }
        return max;


    }
}
