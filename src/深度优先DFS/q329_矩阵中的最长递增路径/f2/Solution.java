package 深度优先DFS.q329_矩阵中的最长递增路径.f2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * @return int
     * @Title longestIncreasingPath
     * @Description 拓扑排序
     * @Author zph
     * @Date 2020/7/17 17:29
     * @Param [matrix]
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] count = new int[m][n];


        //统计每个点的入度用count数组保存，因为是递增，所以如果在上下左右，每发现一个比当前点小的数，当前点入度+1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] < matrix[i][j]) {
                        count[i][j]++;
                    }
                }

            }

        }
        //count数组中所有入度为0的点加入队列
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (count[i][j] == 0) {
                    queue.offer(new int[]{i, j});

                }
            }

        }
        int ans = 0;
        while (!queue.isEmpty()) {
            ans++;
            int size = queue.size();
            //这个跟课程表I那个题不一样，需要一层一层的出列，而不是一个一个的出，因为课程表那个不关心队列长度
            for (int z = 0; z < size; z++) {
                int[] poll = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int i = poll[0];
                    int j = poll[1];
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                        count[x][y]--;
                        if (count[x][y] == 0) {
                            queue.offer(new int[]{x, y});

                        }
                    }

                }

            }
        }


        return ans;

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
