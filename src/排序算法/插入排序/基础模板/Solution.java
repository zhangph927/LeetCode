package 排序算法.插入排序.基础模板;

import java.util.Arrays;

/**
 * @ClassName : Solution
 * @Description :
 * @Author : zph
 * @Date: 2020-07-25 23:06
 * @Version : V1.0
 */
public class Solution {

    // 插入排序：稳定排序，在接近有序的情况下，表现优异

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        // 循环不变量：将 nums[i] 插入到区间 [0, i) 使之成为有序数组
        for (int i = 1; i < len; i++) {
            // 先暂存这个元素，然后之前元素逐个后移，留出空位
            int temp = nums[i];
            int j = i;
            // 注意边界 j > 0
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        Solution solution = new Solution();
        int[] res = solution.sortArray(nums);
        System.out.println(Arrays.toString(res));
    }
}
