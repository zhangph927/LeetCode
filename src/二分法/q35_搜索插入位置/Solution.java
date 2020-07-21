package 二分法.q35_搜索插入位置;

/**
 * @ClassName : Solution
 * @Description :35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * @Author : zph
 * @Date: 2020-07-17 16:31
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return int
     * @Title searchInsert
     * @Description 二分查找
     * @Author zph
     * @Date 2020/7/17 16:31
     * @Param [nums, target]
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {

            //标识数据为空
            return -1;
        }
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        if (target < nums[left]) {
            return left;
        }
        if (nums[right] < target) {
            return length;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
            return left;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
       int[] nums= {1,3,5,6};
       int target=2;
        int i = solution.searchInsert(nums, target);

        System.out.println(i);

    }
}
