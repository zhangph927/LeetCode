package 排序算法.归并排序.q493_翻转对.f1;

/**
 * @ClassName : Solution
 * @Description :493. 翻转对
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * <p>
 * 你需要返回给定数组中的重要翻转对的数量。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * 注意:
 * <p>
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 * @Author : zph
 * @Date: 2020-07-28 23:50
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return int
     * @Title reversePairs
     * @Description 归并排序
     * @Author zph
     * @Date 2020/7/29 0:23
     * @Param [nums]
     */
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int left, int right) {
        if (right <= left) {
            return 0;
        }
        int mid = (left + right) >> 1;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        // 中间数组用于合并
        int[] cache = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0, tmp = left;
        while (j <= right) {
            while (tmp <= mid && nums[tmp] <= 2 * (long) nums[j]) tmp++;
            while (i <= mid && nums[i] < nums[j]) cache[k++] = nums[i++];
            cache[k++] = nums[j++];
            count += mid - tmp + 1;
        }
        while (i <= mid) cache[k++] = nums[i++];
        System.arraycopy(cache, 0, nums, left, right - left + 1);
        return count;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = {-5, -5};
        int i = solution.reversePairs(nums);
        System.out.println(i);
    }
}
