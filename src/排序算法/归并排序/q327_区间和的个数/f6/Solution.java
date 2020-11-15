package 排序算法.归并排序.q327_区间和的个数.f6;

import java.util.HashMap;
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
     * @Description 动态增加节点的线段树
     * @Author zph
     * @Date 2020/8/9 15:28
     * @Param [nums, lower, upper]
     * @return int
     */

    public int countRangeSum(int[] nums, int lower, int upper) {
        long sum = 0;
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            preSum[i + 1] = sum;
        }

        long lbound = Long.MAX_VALUE, rbound = Long.MIN_VALUE;
        for (long x : preSum) {
            lbound = Math.min(Math.min(lbound, x), Math.min(x - lower, x - upper));
            rbound = Math.max(Math.max(rbound, x), Math.max(x - lower, x - upper));
        }

        SegNode root = new SegNode(lbound, rbound);
        int ret = 0;
        for (long x : preSum) {
            ret += count(root, x - upper, x - lower);
            insert(root, x);
        }
        return ret;
    }

    public int count(SegNode root, long left, long right) {
        if (root == null) {
            return 0;
        }
        if (left > root.hi || right < root.lo) {
            return 0;
        }
        if (left <= root.lo && root.hi <= right) {
            return root.add;
        }
        return count(root.lchild, left, right) + count(root.rchild, left, right);
    }

    public void insert(SegNode root, long val) {
        root.add++;
        if (root.lo == root.hi) {
            return;
        }
        long mid = (root.lo + root.hi) >> 1;
        if (val <= mid) {
            if (root.lchild == null) {
                root.lchild = new SegNode(root.lo, mid);
            }
            insert(root.lchild, val);
        } else {
            if (root.rchild == null) {
                root.rchild = new SegNode(mid + 1, root.hi);
            }
            insert(root.rchild, val);
        }
    }
}

class SegNode {
    long lo, hi;
    int add;
    SegNode lchild, rchild;

    public SegNode(long left, long right) {
        lo = left;
        hi = right;
        add = 0;
        lchild = null;
        rchild = null;
    }



}
