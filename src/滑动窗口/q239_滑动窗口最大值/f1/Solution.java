package 滑动窗口.q239_滑动窗口最大值.f1;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 *
 *
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * @Author : zph
 * @Date: 2020-10-15 12:31
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title maxSlidingWindow
     * @Description 双端队列存索引值
     * @Author zph
     * @Date 2020/10/15 12:35
     * @Param [nums, k]
     * @return int[]
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        // 特判
        if (len == 0) {
            return new int[]{};
        }
        // 结果集
        List<Integer> res = new ArrayList<>();
        // 滑动窗口，注意：保存的是索引值
        ArrayDeque<Integer> deque = new ArrayDeque<>(k);

        for (int i = 0; i < len; i++) {
            // 当元素从左边界滑出的时候，如果它恰恰好是滑动窗口的最大值
            // 那么将它弹出
            if (i >= k && i - k == deque.getFirst()) {
                deque.pollFirst();
            }

            // 如果滑动窗口非空，新进来的数比队列里已经存在的数还要大
            // 则说明已经存在数一定不会是滑动窗口的最大值（它们毫无出头之日）
            // 将它们弹出
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
            // 队首一定是滑动窗口的最大值的索引
            if (i >= k - 1) {
                res.add(nums[deque.peekFirst()]);
            }
        }

        int size = res.size();
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = res.get(i);
        }
        return result;
    }

}
