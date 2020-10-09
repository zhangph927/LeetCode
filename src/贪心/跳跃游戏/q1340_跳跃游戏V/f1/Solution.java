package 贪心.跳跃游戏.q1340_跳跃游戏V.f1;

import java.util.*;

/**
 * @ClassName : Solution
 * @Description :1340. 跳跃游戏 V
 * 给你一个整数数组 arr 和一个整数 d 。每一步你可以从下标 i 跳到：
 *
 * i + x ，其中 i + x < arr.length 且 0 < x <= d 。
 * i - x ，其中 i - x >= 0 且 0 < x <= d 。
 * 除此以外，你从下标 i 跳到下标 j 需要满足：arr[i] > arr[j] 且 arr[i] > arr[k] ，其中下标 k 是所有 i 到 j 之间的数字（更正式的，min(i, j) < k < max(i, j)）。
 *
 * 你可以选择数组的任意下标开始跳跃。请你返回你 最多 可以访问多少个下标。
 *
 * 请注意，任何时刻你都不能跳到数组的外面。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：arr = [6,4,14,6,8,13,9,7,10,6,12], d = 2
 * 输出：4
 * 解释：你可以从下标 10 出发，然后如上图依次经过 10 --> 8 --> 6 --> 7 。
 * 注意，如果你从下标 6 开始，你只能跳到下标 7 处。你不能跳到下标 5 处因为 13 > 9 。你也不能跳到下标 4 处，因为下标 5 在下标 4 和 6 之间且 13 > 9 。
 * 类似的，你不能从下标 3 处跳到下标 2 或者下标 1 处。
 * 示例 2：
 *
 * 输入：arr = [3,3,3,3,3], d = 3
 * 输出：1
 * 解释：你可以从任意下标处开始且你永远无法跳到任何其他坐标。
 * 示例 3：
 *
 * 输入：arr = [7,6,5,4,3,2,1], d = 1
 * 输出：7
 * 解释：从下标 0 处开始，你可以按照数值从大到小，访问所有的下标。
 * 示例 4：
 *
 * 输入：arr = [7,1,7,1,7,1], d = 2
 * 输出：2
 * 示例 5：
 *
 * 输入：arr = [66], d = 1
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 10^5
 * 1 <= d <= arr.length
 * @Author : zph
 * @Date: 2020-10-06 23:32
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title maxJumps
     * @Description 带记忆的深度优先搜索
     * @Author zph
     * @Date 2020/10/6 23:41
     * @Param [arr, d]
     * @return int
     */
    public int maxJumps(int[] arr, int d) {
        if (arr == null || arr.length == 0)
            return 0;
        if (arr.length == 1)
            return 1;
        int n = arr.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        int res = 1;
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue).reversed());
        for (int i = 0; i < n; i++) {
            queue.add(new Pair(i, arr[i]));
        }
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (memo[pair.index] == -1) {
                res = Math.max(res, dfs(arr, n, d, pair.index, memo));
            }
        }
        return res;
    }

    private static class Pair {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private int dfs(int[] arr, int n, int d, int start, int[] memo) {
        if (memo[start] != -1) {
            return memo[start];
        }
        int left = Math.max(0, start-d);
        int right = Math.min(n-1, start+d);
        List<Integer> nextRightIndex = new LinkedList<>();
        int value = Integer.MIN_VALUE;
        for (int j = start+1; j <= right; j++) {
            if (arr[j] < arr[start]) {
                if (arr[j] > value) {
                    value = arr[j];
                    nextRightIndex.clear();
                    nextRightIndex.add(j);
                } else if (arr[j] == value) {
                    nextRightIndex.add(j);
                }
            } else {
                break;
            }
        }
        List<Integer> nextLeftIndex = new LinkedList<>();
        value = Integer.MIN_VALUE;
        for (int j = start-1; j >= left; j--) {
            if (arr[j] < arr[start]) {
                if (arr[j] > value) {
                    value = arr[j];
                    nextLeftIndex.clear();
                    nextLeftIndex.add(j);
                } else if (arr[j] == value) {
                    nextLeftIndex.add(j);
                }
            } else {
                break;
            }
        }

        if (nextLeftIndex.isEmpty() && nextRightIndex.isEmpty()) {
            memo[start] = 1;
            return 1;
        } else {
            int res = 1;
            for (int index : nextLeftIndex) {
                res = Math.max(res, 1+dfs(arr, n, d, index, memo));
            }
            for (int index : nextRightIndex) {
                res = Math.max(res, 1+dfs(arr, n, d, index, memo));
            }
            memo[start] = res;
            return res;
        }
    }

}
