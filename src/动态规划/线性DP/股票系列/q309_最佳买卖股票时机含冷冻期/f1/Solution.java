package 动态规划.线性DP.股票系列.q309_最佳买卖股票时机含冷冻期.f1;

/**
 * @ClassName : Solution
 * @Description :309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * @Author : zph
 * @Date: 2020-07-10 23:58
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title maxProfit
     * @Description 动态规划
     * 每次 sell 之后要等一天才能继续交易。只要把这个特点融入上一题的状态转移方程即可：
     *
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
     * 解释：第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。
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
