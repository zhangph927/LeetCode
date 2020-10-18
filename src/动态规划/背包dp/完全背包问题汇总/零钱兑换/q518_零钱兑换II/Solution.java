package 动态规划.背包dp.完全背包问题汇总.零钱兑换.q518_零钱兑换II;

/**
 * @ClassName : Solution
 * @Description :518. 零钱兑换 II
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 *
 *
 *
 * 示例 1:
 *
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 *
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 *
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 *
 *
 * 注意:
 *
 * 你可以假设：
 *
 * 0 <= amount (总金额) <= 5000
 * 1 <= coin (硬币面额) <= 5000
 * 硬币种类不超过 500 种
 * 结果符合 32 位符号整数
 * @Author : zph
 * @Date: 2020-10-17 21:40
 * @Version : V1.0
 */
public class Solution {


    /**
     * @Title change
     * @Description 动态规划
     * 对于每个 x，计算组合数：dp[x] += dp[x - coin]
     * @Author zph
     * @Date 2020/10/17 21:52
     * @Param [amount, coins]
     * @return int
     */
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
