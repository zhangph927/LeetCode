package 动态规划.区间型dp.q1278_分割回文串III;

/**
 * @ClassName : Solution
 * @Description :1278. 分割回文串 III
 * 给你一个由小写字母组成的字符串 s，和一个整数 k。
 *
 * 请你按下面的要求分割字符串：
 *
 * 首先，你可以将 s 中的部分字符修改为其他的小写英文字母。
 * 接着，你需要把 s 分割成 k 个非空且不相交的子串，并且每个子串都是回文串。
 * 请返回以这种方式分割字符串所需修改的最少字符数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abc", k = 2
 * 输出：1
 * 解释：你可以把字符串分割成 "ab" 和 "c"，并修改 "ab" 中的 1 个字符，将它变成回文串。
 * 示例 2：
 *
 * 输入：s = "aabbc", k = 3
 * 输出：0
 * 解释：你可以把字符串分割成 "aa"、"bb" 和 "c"，它们都是回文串。
 * 示例 3：
 *
 * 输入：s = "leetcode", k = 8
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= k <= s.length <= 100
 * s 中只含有小写英文字母。
 * @Author : zph
 * @Date: 2020-09-05 22:16
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title palindromePartition
     * @Description 区间dp
     * 1.首先第一部分算出s的每一段substring 变成回文需要修改多少字符串
     * 1.1这部分的状态转移方程是
     * pali[i][j] = pali[i+1][j-1]+1(如果i和j位置的字符串不等)
     * pali[i][j] = pali[i+1][j-1] (如果i和j位置的字符串相等)
     * 注意 如果j-i<=1，即i到j之间有小于等于2个字符串的时候
     * pali[i][j] = 1(如果i和j位置的字符串不等)
     * pali[i][j] = 0(如果i和j位置的字符串相等)
     *
     * 2.计算分割成k个字符串后让每个字符串变成回文字符串的最少修改次数
     * 用dp[i][j]表示，i表示切割成i个 j表示当前字符串的长度
     * 状态转移方程是
     * dp[i][j] = min(dp[i-1][x] + pali[x+1][j])
     * 其中x的取值范围是[i-1, j-1] (i-1表示前i-1个字符串，每一个字母一段，j-1表示最后一个字母一段)
     *
     * todo 未解决问题
     *
     *
     *
     * @Author zph
     * @Date 2020/9/5 22:23
     * @Param [s, k]
     * @return int
     */
    public int palindromePartition(String s, int k) {
        int[][] pali= new int[s.length() + 1][s.length() + 1];
        for(int i = s.length(); i >= 1; i--)
        {
            for(int j = i; j <= s.length(); j++)
            {
                if(j - i >= 2)
                    pali[i][j] = pali[i + 1][j - 1];
                if(s.charAt(i - 1) != s.charAt(j - 1))
                    pali[i][j]++;
            }
        }

        int[][] dp = new int[k + 1][s.length() + 1];
        for(int i = 1; i <= k; i++)
        {
            for(int j = i; j <= s.length(); j++)
            {
                if(i == 1)
                    dp[i][j] = pali[i][j];
                else
                {
                    dp[i][j] = dp[i - 1][i - 1] + pali[i][j];
                    for(int x = i; x < j; x++)
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][x] + pali[x + 1][j]);
                }
            }
        }
        return dp[k][s.length()];
    }

}
