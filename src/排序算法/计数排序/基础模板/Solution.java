package 排序算法.计数排序.基础模板;

import java.util.Arrays;

/**
 * @ClassName : Solution
 * @Description :
 * @Author : zph
 * @Date: 2020-07-25 23:06
 * @Version : V1.0
 */
public class Solution {
    // 计数排序

    private static final int OFFSET = 50000;

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        // 由于 -50000 <= A[i] <= 50000
        // 因此"桶" 的大小为 50000 - (-50000) = 10_0000
        // 并且设置偏移 OFFSET = 50000，目的是让每一个数都能够大于等于 0
        // 这样就可以作为 count 数组的下标，查询这个数的计数
        int size = 10_0000;

        // 计数数组
        int[] count = new int[size];
        // 计算计数数组
        for (int num : nums) {
            count[num + OFFSET]++;
        }

        // 把 count 数组变成前缀和数组
        for (int i = 1; i < size; i++) {
            count[i] += count[i - 1];
        }

        // 先把原始数组赋值到一个临时数组里，然后回写数据
        int[] temp = new int[len];
        System.arraycopy(nums, 0, temp, 0, len);

        // 为了保证稳定性，从后向前赋值
        for (int i = len - 1; i >= 0; i--) {
            int index = count[temp[i] + OFFSET] - 1;
            nums[index] = temp[i];
            count[temp[i] + OFFSET]--;
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
