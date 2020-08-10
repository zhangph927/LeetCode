package 排序算法.归并排序.q327_区间和的个数.f4;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @ClassName : Solution
 * @Description :327. 区间和的个数
 * 给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 * <p>
 * 说明:
 * 最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [-2,5,-1], lower = -2, upper = 2,
 * 输出: 3
 * 解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
 * @Author : zph
 * @Date: 2020-08-09 14:55
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title countRangeSum
     * @Description 树状数组
     * @Author zph
     * @Date 2020/8/9 15:28
     * @Param [nums, lower, upper]
     * @return int
     */

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        //前缀和
        long[] prefix = new long[n + 1];
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            prefix[i] += prefix[i - 1] + nums[i - 1];
        }

        //离散化
        for (long val : prefix) {
            set.add(val - lower);
            set.add(val);
            set.add(val - upper);
        }
        HashMap<Long, Integer> map = new HashMap<>();
        int rank = 1;
        while (!set.isEmpty()) {
            map.put(set.pollFirst(), rank++);
        }
        //树状数组
        BIT bit = new BIT(rank);
        int ans = 0;
        for (long val : prefix) {
            int high_rank = map.get(val - lower);
            int low_rank = map.get(val - upper);
            rank = map.get(val);
            ans += bit.prefix(high_rank) - bit.prefix(low_rank - 1);
            bit.update(rank, 1);
        }
        return ans;
    }

    class BIT {
        int[] bit;
        int n;

        BIT(int n) {
            this.n = n + 1;
            bit = new int[n + 1];
        }

        public int lowBit(int i) {
            return i & (-i);
        }

        public void update(int i, int val) {
            while (i < n) {
                bit[i] += val;
                i += lowBit(i);
            }
        }

        public int prefix(int i) {
            int ans = 0;
            while (i > 0) {
                ans += bit[i];
                i -= lowBit(i);
            }
            return ans;
        }
    }



}
