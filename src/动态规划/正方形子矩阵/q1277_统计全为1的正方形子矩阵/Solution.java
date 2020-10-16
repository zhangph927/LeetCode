package 动态规划.正方形子矩阵.q1277_统计全为1的正方形子矩阵;

/**
 * @ClassName : Solution
 * @Description :1277. 统计全为 1 的正方形子矩阵
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * 输出：15
 * 解释：
 * 边长为 1 的正方形有 10 个。
 * 边长为 2 的正方形有 4 个。
 * 边长为 3 的正方形有 1 个。
 * 正方形的总数 = 10 + 4 + 1 = 15.
 * 示例 2：
 *
 * 输入：matrix =
 * [
 *   [1,0,1],
 *   [1,1,0],
 *   [1,1,0]
 * ]
 * 输出：7
 * 解释：
 * 边长为 1 的正方形有 6 个。
 * 边长为 2 的正方形有 1 个。
 * 正方形的总数 = 6 + 1 = 7.
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 300
 * 1 <= arr[0].length <= 300
 * 0 <= arr[i][j] <= 1
 * @Author : zph
 * @Date: 2020-10-15 00:16
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title countSquares
     * @Description 动态规划
     * dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
     *
     * @Author zph
     * @Date 2020/10/15 0:19
     * @Param [matrix]
     * @return int
     */
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ans = 0;
        // 预处理每一行和每一列
        for (int i = 0; i < m; i++) {
            ans += dp[i][0] = matrix[i][0];
        }
        for (int j = 0; j < n; j++) {
            ans += dp[0][j] = matrix[0][j];
        }
        // 上述过程(0, 0)判断了两次, 如果matrix[0][0] == 1，说明ans多算了一个
        if (matrix[0][0] == 1) {
            ans--;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    ans += dp[i][j];
                }
            }
        }
        return ans;
    }

}
