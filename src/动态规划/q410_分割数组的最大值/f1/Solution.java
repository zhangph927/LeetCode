package 动态规划.q410_分割数组的最大值.f1;

import sun.nio.cs.ext.MacHebrew;

import java.util.Arrays;

/**
 * @ClassName : Solution
 * @Description :410. 分割数组的最大值
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 * <p>
 * 注意:
 * 数组长度 n 满足以下条件:
 * <p>
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 示例:
 * <p>
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 * <p>
 * 输出:
 * 18
 * <p>
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * @Author : zph
 * @Date: 2020-07-25 18:31
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return int
     * @Title splitArray
     * @Description 动态规划
     * @Author zph
     * @Date 2020/7/25 19:36
     * @Param [nums, m]
     */
    public int splitArray(int[] nums, int m) {
        int length = nums.length;
        int[][] dp = new int[length+1][m + 1];
        for (int i = 0; i <= length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        //求前缀和
        int[] sub = new int[length + 1];
        for (int i = 0; i < length; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sub[i] - sub[k]));
                }
            }
        }

        return dp[length][m];
    }




    public static void main(String[] args) {

        Solution solution = new Solution();
       int[] nums = {7,2,5,10,8};
      int   m = 2;
        int i = solution.splitArray(nums, m);
        System.out.println(i);
    }
}
