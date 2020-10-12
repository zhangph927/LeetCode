package 动态规划.线性DP.股票系列.q121_买卖股票的最佳时机.f1;

/**
 * @ClassName : Solution
 * @Description :121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * @Author : zph
 * @Date: 2020-10-10 00:11
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title maxProfit
     * @Description 动态规划
     * @Author zph
     * @Date 2020/10/10 0:22
     * @Param [prices]
     * @return int
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 0：用户手上不持股所能获得的最大利润，特指卖出股票以后的不持股，非指没有进行过任何交易的不持股
        // 1：用户手上持股所能获得的最大利润

        // 注意：因为题目限制只能交易一次，因此状态只可能从 1 到 0，不可能从 0 到 1
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }



}
