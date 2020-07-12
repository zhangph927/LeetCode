package 深度优先DFS.q778_水位上升的泳池中游泳.f2;

import java.util.*;

/**
 * @ClassName : Solution
 * @Description :778. 水位上升的泳池中游泳
 * 在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。
 * <p>
 * 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
 * <p>
 * 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[0,2],[1,3]]
 * 输出: 3
 * 解释:
 * 时间为0时，你位于坐标方格的位置为 (0, 0)。
 * 此时你不能游向任意方向，因为四个相邻方向平台的高度都大于当前时间为 0 时的水位。
 * <p>
 * 等时间到达 3 时，你才可以游向平台 (1, 1). 因为此时的水位是 3，坐标方格中的平台没有比水位 3 更高的，所以你可以游向坐标方格中的任意位置
 * 示例2:
 * <p>
 * 输入: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
 * 输出: 16
 * 解释:
 * 0  1  2  3  4
 * 24 23 22 21  5
 * 12 13 14 15 16
 * 11 17 18 19 20
 * 10  9  8  7  6
 * <p>
 * 最终的路线用加粗进行了标记。
 * 我们必须等到时间为 16，此时才能保证平台 (0, 0) 和 (4, 4) 是连通的
 * <p>
 * <p>
 * 提示:
 * <p>
 * 2 <= N <= 50.
 * grid[i][j] 位于区间 [0, ..., N*N - 1] 内。
 * @Author : zph
 * @Date: 2020-07-12 17:18
 * @Version : V1.0
 */
public class Solution {

    /**
     * @return int
     * @Title swimInWater
     * @Description 二分+深度遍历
     * @Author zph
     * @Date 2020/7/12 17:36
     * @Param [grid]
     */
    public int swimInWater(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int N = grid.length;
        int left = grid[0][0];
        int right = N * N;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (!possible(mid, grid)) {
                left = mid + 1;

            } else {
                right = mid;

            }

        }
        return left;
    }

    private boolean possible(int T, int[][] grid) {
        int N = grid.length;
        Set<Integer> seenSet = new HashSet<>();
        seenSet.add(0);
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int ans = 0;
        while (!stack.isEmpty()) {
            int num = stack.removeLast();
            int r = num / N;
            int c = num % N;
            ans = Math.max(ans, grid[r][c]);
            if (r == N - 1 && c == N - 1) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int newR = r + dr[i];
                int newC = c + dc[i];
                int ck = newR * N + newC;
                if (newR >= 0 && newR < N && newC >= 0 &&
                        newC < N && !seenSet.contains(ck) && grid[newR][newC] <= T) {
                    seenSet.add(ck);
                    stack.addLast(ck);
                }
            }
        }
        return false;


    }


}
