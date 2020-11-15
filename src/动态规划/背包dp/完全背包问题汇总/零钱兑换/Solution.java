package 动态规划.背包dp.完全背包问题汇总.零钱兑换;

/**
 * @ClassName : Solution
 * @Description :
 * @Author : zph
 * @Date: 2020-11-08 14:14
 * @Version : V1.0
 */
public class Solution {


    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;
        int total=amount+1;
        for(int coin:coins){
            for(int i=coin;i<total;i++){
                dp[i]+=dp[i-coin];
            }
        }
        return dp[amount];



    }
}
