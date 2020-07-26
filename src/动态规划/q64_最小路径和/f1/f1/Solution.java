package 动态规划.q64_最小路径和.f1.f1;

/**
 * @ClassName : Solution
 * @Description :64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
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
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        //初始化
        dp[0][0] = grid[0][0];
        //第一行
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        //第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {

        int[][] nums = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        Solution solution = new Solution();
        int i = solution.minPathSum(nums);
        System.out.println(i);


    }
}
