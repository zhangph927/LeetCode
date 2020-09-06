package 回溯法.分割回文串.q132_分割回文串II.f2;

/**
 * @ClassName : Solution
 * @Description :132. 分割回文串 II
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回符合要求的最少分割次数。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出: 1
 * 解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * @Author : zph
 * @Date: 2020-09-05 19:33
 * @Version : V1.0
 */
public class Solution {


    /**
     * @return int
     * @Title minCut
     * @Description 动态规划
     * @Author zph
     * @Date 2020/9/5 21:01
     * @Param [s]
     */
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();

        //动态规划 空间换时间
        boolean[][] checkPalindrome = new boolean[length][length];
        //初始化
        for (int i = 0; i < length; i++) {
            checkPalindrome[i][i] = true;
        }
        char[] chars = s.toCharArray();

        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    checkPalindrome[i][j] = false;
                } else {
                    //不构成区间 j-1-(i+1)+1<2
                    //j-i<3
                    if (j - i < 3) {
                        checkPalindrome[i][j] = true;
                    } else {
                        checkPalindrome[i][j] = checkPalindrome[i + 1][j - 1];
                    }
                }

            }
        }


        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = i;
        }
        for (int i = 1; i < length; i++) {
            if (checkPalindrome[0][i]) {
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (checkPalindrome[j + 1][i]){
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }


            }

        }
        return dp[length - 1];


    }


}
