package 贪心.跳跃游戏.q1345_跳跃游戏IV;

import java.util.*;

/**
 * @ClassName : Solution
 * @Description :1345. 跳跃游戏 IV
 * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
 *
 * 每一步，你可以从下标 i 跳到下标：
 *
 * i + 1 满足：i + 1 < arr.length
 * i - 1 满足：i - 1 >= 0
 * j 满足：arr[i] == arr[j] 且 i != j
 * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
 *
 * 注意：任何时候你都不能跳到数组外面。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
 * 输出：3
 * 解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
 * 示例 2：
 *
 * 输入：arr = [7]
 * 输出：0
 * 解释：一开始就在最后一个元素处，所以你不需要跳跃。
 * 示例 3：
 *
 * 输入：arr = [7,6,9,6,9,6,9,7]
 * 输出：1
 * 解释：你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
 * 示例 4：
 *
 * 输入：arr = [6,1,9]
 * 输出：2
 * 示例 5：
 *
 * 输入：arr = [11,22,7,7,7,7,7,7,7,22,13]
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 5 * 10^4
 * -10^8 <= arr[i] <= 10^8
 * @Author : zph
 * @Date: 2020-10-06 23:20
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title minJumps
     * @Description bfs
     * @Author zph
     * @Date 2020/10/6 23:26
     * @Param [arr]
     * @return int
     */
    public int minJumps(int[] arr) {
        if (arr.length == 1)
            return 0;
        Map<Integer, Set<Integer>> value2Index = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            value2Index.computeIfAbsent(arr[i], k -> new HashSet<>()).add(i);
        }

        int minStep = 0;
        Set<Integer> hasReached = new HashSet<>();
        Queue<Integer> nextStep = new LinkedList<>();
        nextStep.add(arr.length-1);
        hasReached.add(arr.length-1);
        while (!nextStep.isEmpty()) {
            int count = nextStep.size();
            minStep++;
            for (int i = 0; i < count; i++) {
                int index = nextStep.poll();
                value2Index.get(arr[index]).remove(index);
                Set<Integer> temp = new HashSet<>(value2Index.get(arr[index]));
                if (index - 1 >= 0) {
                    temp.add(index-1);
                }
                if (index + 1 < arr.length) {
                    temp.add(index + 1);
                }
                for (int a : temp) {
                    if (a == 0) {
                        return minStep;
                    }
                    if (!hasReached.contains(a)) {
                        hasReached.add(a);
                        nextStep.add(a);
                    }
                }
            }
        }
        return minStep;
    }

}
