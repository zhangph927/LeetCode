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
public class Solution1 {
    /**
     * @return int
     * @Title reversePairs
     * @Description 归并排序
     * @Author zph
     * @Date 2020/7/28 23:03
     * @Param [nums]
     */
    public int reversePairs(int[] nums) {

        if (nums == null || nums.length < 2) {
            return 0;
        }

        int length = nums.length;
        int[] temp = new int[length];

        return reversePairs(nums, 0, length - 1, temp);

    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {

        if (left == right) {
            return 0;

        }
        int mid = left + (right - left) / 2;
        int leftNum = reversePairs(nums, left, mid, temp);
        int rightNum = reversePairs(nums, mid + 1, right, temp);

        int i = left;
        int j = mid + 1;
        int count=0;
        while (i <= mid && j <= right) {
            if ((long)nums[i] > 2 * ((long)nums[j])) {
                count += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }//先处理问题
         mergeAndCount(nums, left, mid, right, temp);

        return leftNum + rightNum + count;


    }

    private void mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {

        System.arraycopy(nums, left, temp, left, right - left + 1);

        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;

            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
            }
        }
    }


    public static void main(String[] args) {

        Solution1 solution = new Solution1();

        int[] nums = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        int i = solution.reversePairs(nums);
        System.out.println(i);
    }
}
