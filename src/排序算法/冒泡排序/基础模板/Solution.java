package 排序算法.冒泡排序.基础模板;

import java.util.Arrays;

/**
 * @ClassName : Solution
 * @Description :
 * @Author : zph
 * @Date: 2020-07-25 23:06
 * @Version : V1.0
 */
public class Solution {
    // 冒泡排序：超时

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            // 先默认数组是有序的，只要发生一次交换，就必须进行下一轮比较，
            // 如果在内层循环中，都没有执行一次交换操作，说明此时数组已经是升序数组
            boolean sorted = true;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        Solution solution = new Solution();
        int[] res = solution.sortArray(nums);
        System.out.println(Arrays.toString(res));
    }
}
