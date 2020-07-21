package 动态规划.q97_交错字符串.f2;

/**
 * @ClassName : Solution
 * @Description :97. 交错字符串
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 *
 * 示例 1:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 * @Author : zph
 * @Date: 2020-07-18 18:45
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return boolean
     * @Title isInterleave
     * @Description 动态规划+滚动数组优化空间复杂度
     * @Author zph
     * @Date 2020/7/18 18:45
     * @Param [s1, s2, s3]
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int k = s3.length();
        if (m + n != k) {
            return false;
        }
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        char[] s3Chars = s3.toCharArray();

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int p = i + j - 1;
                if (i > 0) {
                    dp[j] = dp[j] && s1Chars[i - 1] == s3Chars[p];
                }
                if (j > 0) {
                    dp[j] = dp[j] || (dp[j - 1] && s2Chars[j - 1] == s3Chars[p]);
                }
            }

        }
        return dp[n];


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
       String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        boolean interleave = solution.isInterleave(s1, s2, s3);
        System.out.println(interleave);

    }
}
