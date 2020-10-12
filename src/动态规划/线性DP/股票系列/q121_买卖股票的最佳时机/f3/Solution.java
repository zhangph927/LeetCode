package 动态规划.线性DP.股票系列.q121_买卖股票的最佳时机.f3;

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
     * @Description 使用差分数组
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

        // 差分数组比原始数组的长度少 1
        int[] diff = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            diff[i] = prices[i + 1] - prices[i];
        }

        // dp[i] 以 diff[i] 结尾的子序列的和的最大值
        int[] dp = new int[len - 1];
        dp[0] = diff[0];
        for (int i = 1; i < len - 1; i++) {
            dp[i] = Math.max(diff[i], dp[i - 1] + diff[i]);
        }

        // 还是要考虑到 [7 , 6, 5, 4, 3] 这种不交易的情况
        // 初值应该赋值成 0
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }


}
