package 动态规划.q343_整数拆分.f1;

/**
 * @ClassName : Solution
 * @Description :343. 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 * @Author : zph
 * @Date: 2020-07-30 00:13
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title integerBreak
     * @Description 动态规划
     * @Author zph
     * @Date 2020/7/30 0:16
     * @Param [n]
     * @return int
     */
    public int integerBreak(int n) {
        int[] dp=new int[n+1];

        for(int i=2;i<=n;i++){
            int max=0;
            for(int j=1;j<i;j++){
                max=Math.max(max,Math.max(j*(i-j),j*dp[i-j]));
            }
            dp[i]=max;
        }
        return dp[n];

    }
}
