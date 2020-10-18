package 数组.q剑指_Offer_03_数组中重复的数字;

/**
 * @ClassName : Solution
 * @Description :剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 *
 * 限制：
 *
 * 2 <= n <= 100000
 * @Author : zph
 * @Date: 2020-10-17 22:56
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title findRepeatNumber
     * @Description 把数组视为哈希表（有一类问题是这么做的，但是会修改数组）
     * @Author zph
     * @Date 2020/10/17 22:58
     * @Param [nums]
     * @return int
     */
    public int findRepeatNumber(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            // 如果当前的数 nums[i] 没有在下标为 i 的位置上，就把它交换到下标 i 上
            // 交换过来的数还得做相同的操作，因此这里使用 while
            // 可以在此处将数组输出打印，观察程序运行流程
            // System.out.println(Arrays.toString(nums));

            while (nums[i] != i) {

                if (nums[i] == nums[nums[i]]) {
                    // 如果下标为 nums[i] 的数值 nums[nums[i]] 它们二者相等
                    // 正好找到了重复的元素，将它返回
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        throw new IllegalArgumentException("数组中不存在重复数字！");
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
