package 二分法.q剑指Offer11旋转数组的最小数字;

/**
 * @ClassName : Solution
 * @Description :剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[2,2,2,0,1]
 * 输出：0
 * @Author : zph
 * @Date: 2020-07-22 23:18
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return int
     * @Title minArray
     * @Description 二分查找
     * @Author zph
     * @Date 2020/7/22 23:18
     * @Param [numbers]
     */
    public int minArray(int[] numbers) {
        int length = numbers.length;
        if (length == 0) {
            return 0;
        }
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                right--;

            }

        }
        return numbers[left];

    }

    public static void main(String[] args) {


        Solution solution = new Solution();
        int[] nums = {3, 4, 5, 1, 2};
        int i = solution.minArray(nums);
        System.out.println(i);

    }
}
