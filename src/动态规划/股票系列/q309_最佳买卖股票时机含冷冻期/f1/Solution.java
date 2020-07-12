package 动态规划.股票系列.q309_最佳买卖股票时机含冷冻期.f1;

/**
 * @ClassName : Solution
 * @Description :
 * @Author : zph
 * @Date: 2020-07-10 23:58
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title maxProfit
     * @Description 动态规划
     * @Author zph
     * @Date 2020/7/10 23:59
     * @Param [prices]
     * @return int
     */
    public int maxProfit(int[] prices) {
        int length=prices.length;
        if(length<2){
            return 0;
        }
        int[][] dp=new int[length][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        dp[1][0]=Math.max(dp[0][0],dp[0][1]+prices[1]);
        dp[1][1]=Math.max(-prices[1],dp[0][1]);
        for(int i=2;i<length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-2][0]-prices[i],dp[i-1][1]);
        }
        return Math.max(dp[length-1][0],dp[length-1][1]);


    }
}
