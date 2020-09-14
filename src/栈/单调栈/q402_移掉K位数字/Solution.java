package 栈.单调栈.q402_移掉K位数字;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName : Solution
 * @Description :402. 移掉K位数字
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>
 * 注意:
 * <p>
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 * <p>
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 * <p>
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 * <p>
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 * @Author : zph
 * @Date: 2020-09-11 00:13
 * @Version : V1.0
 */
public class Solution {

    /**
     * @return java.lang.String
     * @Title removeKdigits
     * @Description 单调栈+贪心算法
     * @Author zph
     * @Date 2020/9/11 0:45
     * @Param [num, k]
     */
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = num.toCharArray();
        for (char ch : chars) {
            while (stack.size() > 0 && k > 0 && stack.peekLast() > ch) {
                stack.removeLast();
                k--;
            }
            stack.addLast(ch);
        }
        for (int i = 0; i < k; i++) {
            stack.removeLast();
        }
        StringBuilder builder = new StringBuilder();
        boolean flag = true;
        for (char digit : stack) {
            if (flag && digit == '0') {
                continue;
            }
            flag = false;
            builder.append(digit);
        }

        if (builder.length() == 0) {
            return "0";
        }
        return builder.toString();
    }


}
