package 动态规划.q279_完全平方数.f2;

import java.util.Arrays;

/**
 * @ClassName : Solution
 * @Description :279. 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * @Author : zph
 * @Date: 2020-10-18 15:53
 * @Version : V1.0
 */
public class Solution {


    /**
     * @return int
     * @Title numSquares
     * @Description 动态规划
     * @Author zph
     * @Date 2020/10/18 15:54
     * @Param [n]
     */
    public int numSquares(int n) {
       int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }



}
