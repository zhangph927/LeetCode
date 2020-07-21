package 深度优先DFS.q329_矩阵中的最长递增路径.f1;

/**
 * @ClassName : Solution
 * @Description :329. 矩阵中的最长递增路径
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * <p>
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 * 示例 2:
 * <p>
 * 输入: nums =
 * [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * @Author : zph
 * @Date: 2020-07-16 23:55
 * @Version : V1.0
 */
public class Solution {
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    private static int m;
    private static int n;

    /**
     * @return int
     * @Title longestIncreasingPath
     * @Description 记忆化+深度遍历
     * @Author zph
     * @Date 2020/7/17 17:29
     * @Param [matrix]
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        m = matrix.length;
        n = matrix[0].length;
        int[][] cache = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, cache));

            }

        }
        return ans;

    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >=0 && x < m && y >=0 && y < n && matrix[x][y] > matrix[i][j]) {
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, cache));
            }

        }
        cache[i][j]++;
        return cache[i][j];

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums =
                {
                        {9, 9, 4},
                        {6, 6, 8},
                        {2, 1, 1}
                };
        int i = solution.longestIncreasingPath(nums);
        System.out.println(i);


    }
}
