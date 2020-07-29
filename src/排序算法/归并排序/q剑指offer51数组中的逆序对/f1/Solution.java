package 排序算法.归并排序.q剑指offer51数组中的逆序对.f1;

/**
 * @ClassName : Solution
 * @Description :剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 * @Author : zph
 * @Date: 2020-07-28 22:25
 * @Version : V1.0
 */
public class Solution {
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

        if (nums[mid] <= nums[mid + 1]) {
            return leftNum + rightNum;
        }
        int crossNum = mergeAndCount(nums, left, mid, right, temp);

        return leftNum + rightNum + crossNum;


    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {

        System.arraycopy(nums, left, temp, left, right - left + 1);

        int count = 0;
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
                count += (mid - i + 1);
            }
        }
        return count;
    }


    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums={7,5,6,4};
        int i = solution.reversePairs(nums);
        System.out.println(i);
    }


}
