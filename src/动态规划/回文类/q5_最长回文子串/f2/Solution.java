package 动态规划.回文类.q5_最长回文子串.f2;

/**
 * @ClassName : Solution
 * @Description :5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * @Author : zph
 * @Date: 2020-08-17 23:40
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return java.lang.String
     * @Title longestPalindrome
     * @Description 动态规划
     * @Author zph
     * @Date 2020/8/17 23:57
     * @Param [s]
     */
    public String longestPalindrome(String s) {
        if(s==null||s.length()<2){
            return s;
        }
        char[] chars = s.toCharArray();
        int length=chars.length;
        boolean[][] dp=new boolean[length][length];
        //初始化
        for(int i=0;i<length;i++){
            dp[i][i]=true;
        }
        int start=0;
        int maxLen=1;
        for(int j=1;j<length;j++){
            for(int i=0;i<j;i++){
                if(chars[i]!=chars[j]){
                    dp[i][j]=false;
                }else {
                    if(j-i<3){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                if(dp[i][j]&&j-i+1>maxLen){
                    maxLen=j-i+1;
                    start=i;
                }
            }
        }
        return s.substring(start,start+maxLen);

    }



}
