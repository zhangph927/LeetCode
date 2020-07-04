package 动态规划.q32_最长有效括号.f2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName : Solution
 * @Description :32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * @Author : zph
 * @Date: 2020-07-04 22:35
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title longestValidParentheses
     * @Description 使用栈
     * @Author zph
     * @Date 2020/7/4 23:26
     * @Param [s]
     * @return int
     */
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        int length=chars.length;
        // 初始化压入栈一个 -1 的索引，方便计算有效括号长度。
        stack.push(-1);
        int maxLen=0;
        for(int i=0;i<length;i++){
            if(chars[i]=='('){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    maxLen=Math.max(maxLen,i-stack.peek());
                }

            }

        }
        return  maxLen;
    }


}
