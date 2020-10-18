package 动态规划.背包dp.q01背包问题汇总.q416_分割等和子集.f1;

/**
 * @ClassName : Solution
 * @Description :416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 注意:
 * <p>
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * <p>
 * 输入: [1, 5, 11, 5]
 * <p>
 * 输出: true
 * <p>
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1, 2, 3, 5]
 * <p>
 * 输出: false
 * <p>
 * 解释: 数组不能分割成两个元素和相等的子集.
 * @Author : zph
 * @Date: 2020-10-11 23:11
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return boolean
     * @Title canPartition
     * @Description 动态规划
     * @Author zph
     * @Date 2020/10/11 23:26
     * @Param [nums]
     */
    public boolean canPartition(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return false;
        }
        int total = 0;
        int maxNum = 0;
        for (int num : nums) {
            total += num;
            maxNum = Math.max(maxNum, num);
        }
        if (total % 2 != 0) {
            return false;
        }
        int target = total / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[][] dp = new boolean[length][target + 1];
        for (int i = 0; i < length; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < length; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];

                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }

        }


        return dp[length - 1][target];

    }
}
