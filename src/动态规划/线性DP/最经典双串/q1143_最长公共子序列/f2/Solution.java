package 动态规划.线性DP.最经典双串.q1143_最长公共子序列.f2;

/**
 * @ClassName : Solution
 * @Description :1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * <p>
 * 若这两个字符串没有公共子序列，则返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 * <p>
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 * <p>
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符。
 * @Author : zph
 * @Date: 2020-10-10 00:05
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title longestCommonSubsequence
     * @Description 动态规划
     * @Author zph
     * @Date 2020/10/10 0:07
     * @Param [text1, text2]
     * @return int
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        char[] char1 = text1.toCharArray();
        char[] char2 = text2.toCharArray();
        int length1 = text1.length();
        int length2 = text2.length();
        int[] dp = new int[length2 + 1];
        //标识dp[i-1][j]
        int temp = 0;


        for (int i = 1; i <= length1; i++) {
            //标识dp[i-1][j-1]
            int last = 0;
            for (int j = 1; j <= length2; j++) {
                //
                temp = dp[j];
                if (char1[i - 1] == char2[j - 1]) {
                    dp[j] = Math.max(dp[j], last + 1);
                } else {
                    dp[j] = Math.max(temp, dp[j - 1]);
                }
                last = temp;
            }

        }
        return dp[length2];


    }
}
