package 动态规划.q300_最长上升子序列.f1;

import java.util.Arrays;

/**
 * @ClassName : Solution
 * @Description :300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * @Author : zph
 * @Date: 2020-07-22 00:01
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return int
     * @Title lengthOfLIS
     * @Description 动态规划
     * @Author zph
     * @Date 2020/7/22 0:09
     * @Param [nums]
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length < 2) {
            return 1;
        }
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }

        }

        int res = dp[0];
        for (int i = 0; i < length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums={10,9,2,5,3,7,101,18};
        int length = solution.lengthOfLIS(nums);
        System.out.println(length);


    }
}
