package 分治法.q剑指Offer51数组中的逆序对.f1;

import java.util.ArrayList;
import java.util.List;

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
 * @Date: 2020-07-12 12:05
 * @Version : V1.0
 */
public class Solution {

    /**
     * @return int
     * @Title reversePairs
     * @Description 归并排序
     * @Author zph
     * @Date 2020/7/12 14:47
     * @Param [nums]
     */
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] temp = new int[length];
        return mergeAndReversePairs(nums,0,length-1,temp);

    }

    /**
     * @return void
     * @Title mergeAndCountSmaller
     * @Description 归并排序
     * @Author zph
     * @Date 2020/7/11 23:21
     * @Param [nums, left, right]
     */
    private int mergeAndReversePairs(int[] nums, int left, int right,int[] temp) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftCount = mergeAndReversePairs(nums, left, mid,temp);
        int rightCount = mergeAndReversePairs(nums, mid + 1, right,temp);
        if (nums[mid] <= nums[mid + 1]) {
            return leftCount + rightCount;

        }
        int crossCount = mergeOfTwoSortArrayReversePairs(nums, left, mid, right,temp);
        return leftCount + rightCount + crossCount;
    }

    /**
     * @return void
     * @Title mergeOfTwoSortArrayCountSmaller
     * @Description 合并两个数组
     * @Author zph
     * @Date 2020/7/11 23:26
     * @Param []
     */
    private int mergeOfTwoSortArrayReversePairs(int[] nums, int left, int mid, int right,int[] temp) {

        System.arraycopy(nums, left, temp, left, right - left + 1);

        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
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
        int[] nums = new int[]{7,5,6,4};
        Solution solution = new Solution();
        int count = solution.reversePairs(nums);
        System.out.println(count);
    }
}
