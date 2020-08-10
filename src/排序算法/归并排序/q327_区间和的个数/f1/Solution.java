package 排序算法.归并排序.q327_区间和的个数.f1;

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
     * @Description 归并排序
     * @Author zph
     * @Date 2020/8/9 15:28
     * @Param [nums, lower, upper]
     * @return int
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        int count = 0;
        long[] pre_sum = new long[nums.length];
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            pre_sum[i] = sum;  // pre_sum[i]: nums[0:i]的和
        }
        count = merge_sort(pre_sum, 0, nums.length - 1, lower, upper);
        return count;
    }

    public int merge_sort(long[] pre_sum, int left, int right, int lower, int upper) {
        if (left > right)
            return 0;
        if (left == right) {
            if (pre_sum[left] >= lower && pre_sum[right] <= upper)
                return 1;
            else
                return 0;
        }
        int count = 0;
        int mid = left + (right - left) / 2;
        //System.out.println(left+"   "+right);
        count = merge_sort(pre_sum, left, mid, lower, upper) + merge_sort(pre_sum, mid + 1, right, lower, upper);

        int low_bound = mid + 1;
        int up_bound = mid + 1;

        for (int i = left; i <= mid; i++) { // 计数
            while (low_bound <= right && pre_sum[low_bound] - pre_sum[i] < lower) // 退出while后 low_bound是在右边数组中第一个使得pre_sum[low_bound] - pre_sum[i] >= lower的位置
                low_bound++;
            while (up_bound <= right && pre_sum[up_bound] - pre_sum[i] <= upper) // up_bound是在右边数组中第一个使得pre_sum[up_bound] - pre_sum[i] >upper的位置
                up_bound++;

            count += (up_bound - low_bound);
        }


        long[] merged = new long[right - left + 1];
        int l = left, r = mid + 1;
        int index = 0;
        while (l <= mid && r <= right) {   // 归并
            if (pre_sum[l] <= pre_sum[r])
                merged[index++] = pre_sum[l++];
            else
                merged[index++] = pre_sum[r++];
        }
        while (l <= mid)
            merged[index++] = pre_sum[l++];
        while (r <= right)
            merged[index++] = pre_sum[r++];

        System.arraycopy(merged, 0, pre_sum, left, merged.length); // 辅助空间的数据复制到原数组中

        return count;
    }

}
