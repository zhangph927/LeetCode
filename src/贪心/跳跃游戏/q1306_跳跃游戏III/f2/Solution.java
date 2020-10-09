package 贪心.跳跃游戏.q1306_跳跃游戏III.f2;

import java.util.LinkedList;

/**
 * @ClassName : Solution
 * @Description :1306. 跳跃游戏 III
 * 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
 *
 * 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
 *
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [4,2,3,0,3,1,2], start = 5
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 5 -> 下标 4 -> 下标 1 -> 下标 3
 * 下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
 * 示例 2：
 *
 * 输入：arr = [4,2,3,0,3,1,2], start = 0
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 0 -> 下标 4 -> 下标 1 -> 下标 3
 * 示例 3：
 *
 * 输入：arr = [3,0,2,1,2], start = 2
 * 输出：false
 * 解释：无法到达值为 0 的下标 1 处。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 5 * 10^4
 * 0 <= arr[i] < arr.length
 * 0 <= start < arr.length
 * @Author : zph
 * @Date: 2020-10-06 23:14
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title canReach1st
     * @Description bfs
     * @Author zph
     * @Date 2020/10/6 23:17
     * @Param [arr, start]
     * @return boolean
     */
    public boolean canReach(int[] arr, int start) {
        LinkedList<Integer> queue = new LinkedList<>();
        int n = arr.length;
        boolean[] visited = new boolean[n];
        queue.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curPos = queue.removeFirst();
                int curValue = arr[curPos];
                if (curValue == 0) return true;
                int leftPos = curPos - curValue;
                if (leftPos >= 0 && !visited[leftPos]) {
                    visited[leftPos] = true;
                    queue.addFirst(leftPos);
                }
                int rightPos = curPos + curValue;
                if (rightPos < n && !visited[rightPos]) {
                    visited[rightPos] = true;
                    queue.addFirst(rightPos);
                }
            }
        }
        return false;
    }


}
