package 动态规划.股票系列.q309_最佳买卖股票时机含冷冻期.f2;

import java.util.PriorityQueue;

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
     * @Description 动态规划+压缩空间
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
        int dp_i_0=0;
        int dp_i_1=-prices[0];
        int dp_pre_0=0;
        for(int i=0;i<length;i++){
            int temp=dp_i_0;
            dp_i_0=Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1=Math.max(dp_pre_0-prices[i],dp_i_1);
            dp_pre_0=temp;
        }
        return dp_i_0;
    }
}
