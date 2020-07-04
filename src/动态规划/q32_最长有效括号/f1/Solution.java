package 动态规划.q32_最长有效括号.f1;

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
     * @Description 动态规划
     * @Author zph
     * @Date 2020/7/4 23:26
     * @Param [s]
     * @return int
     */
    public int longestValidParentheses(String s) {
        if(s==null||s.length()==0||s.length()==1){
            return 0;
        }
        char[] chars = s.toCharArray();
        int length=chars.length;
        int ans=0;
        int[] dp=new int[length];
        for(int i=1;i<length;i++){
            if(chars[i]==')'){
                if(chars[i-1]=='('){
                    dp[i]=(i>=2?dp[i-2]:0)+2;
                }else if((i-dp[i-1])>0&&chars[i-dp[i-1]-1]=='('){
                    int len=(i-dp[i-1])>=2?dp[i-dp[i-1]-2]:0;
                    dp[i]=dp[i-1]+2+len;
                }
                ans=Math.max(ans,dp[i]);
            }

        }
        return  ans;


    }


}
