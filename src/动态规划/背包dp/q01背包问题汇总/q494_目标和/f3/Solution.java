package 动态规划.背包dp.q01背包问题汇总.q494_目标和.f3;

/**
 * @ClassName : Solution
 * @Description :494. 目标和
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * <p>
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * 一共有5种方法让最终目标和为3。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 数组非空，且长度不会超过 20 。
 * 初始的数组的和不会超过 1000 。
 * 保证返回的最终结果能被 32 位整数存下。
 * @Author : zph
 * @Date: 2020-10-20 21:48
 * @Version : V1.0
 */
public class Solution {

    /**
     * @return int
     * @Title findTargetSumWays
     * @Description 动态规划
     * sum(A) - sum(B) = target
     * sum(A) = target + sum(B)
     * sum(A) + sum(A) = target + sum(B) + sum(A)
     * 2 * sum(A) = target + sum(nums)
     * <p>
     * 综上，可以推出 sum(A) = (target + sum(nums)) / 2，
     * 也就是把原问题转化成：nums 中存在几个子集 A，
     * 使得 A 中元素的和为 (target + sum(nums)) / 2？
     * @Author zph
     * @Date 2020/10/20 21:51
     * @Param [nums, target]
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum < target || (sum + target) % 2 == 1) {
            return 0;
        }

        return subsets(nums, (sum + target) / 2);

    }

    /**
     * 计算 nums 中有几个子集的和为 sum
     */
    private int subsets(int[] nums, int target) {
        int n = nums.length;

        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= 0; j--) {
                if (j >= nums[i - 1]) {
                    dp[j] = dp[j] + dp[j - nums[i - 1]];
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[target];
    }


}
