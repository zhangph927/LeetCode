package 排序算法.归并排序.q327_区间和的个数.f7;

import java.util.HashMap;
import java.util.Random;
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
     * @Description 平衡二叉搜索树(自己实现树结构)
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

        BalancedTree treap = new BalancedTree();
        int ret = 0;
        for (long x : preSum) {
            long numLeft = treap.lowerBound(x - upper);
            int rankLeft = (numLeft == Long.MAX_VALUE ? (int) (treap.getSize() + 1) : treap.rank(numLeft)[0]);
            long numRight = treap.upperBound(x - lower);
            int rankRight = (numRight == Long.MAX_VALUE ? (int) treap.getSize() : treap.rank(numRight)[0] - 1);
            ret += rankRight - rankLeft + 1;
            treap.insert(x);
        }
        return ret;
    }
}

class BalancedTree {
    private class BalancedNode {
        long val;
        long seed;
        int count;
        int size;
        BalancedNode left;
        BalancedNode right;

        BalancedNode(long val, long seed) {
            this.val = val;
            this.seed = seed;
            this.count = 1;
            this.size = 1;
            this.left = null;
            this.right = null;
        }

        BalancedNode leftRotate() {
            int prevSize = size;
            int currSize = (left != null ? left.size : 0) + (right.left != null ? right.left.size : 0) + count;
            BalancedNode root = right;
            right = root.left;
            root.left = this;
            root.size = prevSize;
            size = currSize;
            return root;
        }

        BalancedNode rightRotate() {
            int prevSize = size;
            int currSize = (right != null ? right.size : 0) + (left.right != null ? left.right.size : 0) + count;
            BalancedNode root = left;
            left = root.right;
            root.right = this;
            root.size = prevSize;
            size = currSize;
            return root;
        }
    }

    private BalancedNode root;
    private int size;
    private Random rand;

    public BalancedTree() {
        this.root = null;
        this.size = 0;
        this.rand = new Random();
    }

    public long getSize() {
        return size;
    }

    public void insert(long x) {
        ++size;
        root = insert(root, x);
    }

    public long lowerBound(long x) {
        BalancedNode node = root;
        long ans = Long.MAX_VALUE;
        while (node != null) {
            if (x == node.val) {
                return x;
            }
            if (x < node.val) {
                ans = node.val;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return ans;
    }

    public long upperBound(long x) {
        BalancedNode node = root;
        long ans = Long.MAX_VALUE;
        while (node != null) {
            if (x < node.val) {
                ans = node.val;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return ans;
    }

    public int[] rank(long x) {
        BalancedNode node = root;
        int ans = 0;
        while (node != null) {
            if (x < node.val) {
                node = node.left;
            } else {
                ans += (node.left != null ? node.left.size : 0) + node.count;
                if (x == node.val) {
                    return new int[]{ans - node.count + 1, ans};
                }
                node = node.right;
            }
        }
        return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
    }

    private BalancedNode insert(BalancedNode node, long x) {
        if (node == null) {
            return new BalancedNode(x, rand.nextInt());
        }
        ++node.size;
        if (x < node.val) {
            node.left = insert(node.left, x);
            if (node.left.seed > node.seed) {
                node = node.rightRotate();
            }
        } else if (x > node.val) {
            node.right = insert(node.right, x);
            if (node.right.seed > node.seed) {
                node = node.leftRotate();
            }
        } else {
            ++node.count;
        }
        return node;
    }




}
