package 动态规划.线性DP.股票系列.q121_买卖股票的最佳时机.f4;

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
     * @Description 使用差分数组,压缩空间
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

        int pre = prices[1] - prices[0];
        // 还是要考虑到 [7 , 6, 5, 4, 3] 这种不交易的情况
        // 初值应该考虑 0
        int res = Math.max(0, pre);
        int diff;
        int cur;

        for (int i = 1; i < len - 1; i++) {
            diff = prices[i + 1] - prices[i];
            cur = Math.max(diff, pre + diff);
            res = Math.max(res, cur);
            pre = cur;
        }
        return res;
    }





}
