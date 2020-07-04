package 动态规划.q32_最长有效括号.f3;

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
     * @Description 不需要额外的空间
     * @Author zph
     * @Date 2020/7/4 23:26
     * @Param [s]
     * @return int
     */
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int length=chars.length;
        int maxLen=0;
        int left=0;
        int right=0;
        for(int i=0;i<length;i++){
            if(chars[i]=='('){
                left++;
            }else{
                right++;
            }
            if(left==right){
                maxLen=Math.max(maxLen,right*2);
            }else if(left<right){
                left=0;
                right=0;
            }
        }
        left=0;
        right=0;
        for(int i=length-1;i>=0;i--){
            if(chars[i]=='('){
                left++;
            }else{
                right++;
            }
            if(left==right){
                maxLen=Math.max(maxLen,right*2);
            }else if(left>right){
                left=0;
                right=0;
            }
        }
        return  maxLen;

    }


}
