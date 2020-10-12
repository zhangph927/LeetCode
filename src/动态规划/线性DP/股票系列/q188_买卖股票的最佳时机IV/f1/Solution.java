package 动态规划.线性DP.股票系列.q188_买卖股票的最佳时机IV.f1;

/**
 * @ClassName : Solution
 * @Description :188. 买卖股票的最佳时机 IV
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [2,4,1], k = 2
 * 输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2:
 *
 * 输入: [3,2,6,5,0,3], k = 2
 * 输出: 7
 * 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * @Author : zph
 * @Date: 2020-10-09 00:07
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title maxProfit
     * @Description 动态规划
     * 有了上一题 k = 2 的铺垫，这题应该和上一题的第一个解法没啥区别。
     * 但是出现了一个超内存的错误，原来是传入的 k 值会非常大，dp 数组太大了。
     * 现在想想，交易次数 k 最多有多大呢？
     *
     * 一次交易由买入和卖出构成，至少需要两天。
     * 所以说有效的限制 k 应该不超过 n/2，如果超过，就没有约束作用了，
     * 相当于 k = +infinity。这种情况是之前解决过的。
     * @Author zph
     * @Date 2020/10/10 17:57
     * @Param [k, prices]
     * @return int
     */
    public int maxProfit(int k, int[] prices) {
        int length=prices.length;
        if(k>length/2){
            return maxProfit_inf(prices);
        }

        int[][][] dp=new int[length][k+1][2];

        for(int i=0;i<length;i++){
            for(int j=k;j>=1;j--){
                if((i-1)==-1){
                    dp[i][j][0]=0;
                    dp[i][j][1]=-prices[i];
                }else{
                    dp[i][j][0]=Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                    dp[i][j][1]=Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
                }
            }
        }
        return dp[length-1][k][0];
    }
    private int maxProfit_inf(int[] prices){
        int length=prices.length;
        int dp_i_0=0;
        int dp_i_1=Integer.MIN_VALUE;
        for(int i=0;i<length;i++){
            dp_i_0=Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1=Math.max(dp_i_1,dp_i_0-prices[i]);

        }
        return dp_i_0;
    }



}
