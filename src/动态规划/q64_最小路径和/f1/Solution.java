package 动态规划.q64_最小路径和.f1;

/**
 * @ClassName : Solution
 * @Description :64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * @Author : zph
 * @Date: 2020-07-12 23:03
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return int
     * @Title minPathSum
     * @Description 动态规划  m*n
     * @Author zph
     * @Date 2020/7/12 23:05
     * @Param [grid]
     */
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j != n - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (j == n - 1 && i != m - 1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else if (j != n - 1 && i != m - 1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                } else {
                    dp[i][j] = grid[i][j];
                }

            }
        }
        return dp[0][0];

    }
}
