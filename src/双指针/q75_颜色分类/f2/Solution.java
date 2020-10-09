package 双指针.q75_颜色分类.f2;

/**
 * @ClassName : Solution
 * @Description :75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * @Author : zph
 * @Date: 2020-10-07 21:43
 * @Version : V1.0
 */
public class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        // all in [0, zero] = 0
        // all in (zero, i) = 1
        // all in (two, len - 1] = 2

        // 为了保证初始化的时候 [0, zero] 为空，设置 zero = -1，
        // 所以下面遍历到 0 的时候，先加，再交换
        int zero = -1;

        // 为了保证初始化的时候 (two, len - 1] 为空，设置 two = len - 1
        // 所以下面遍历到 2 的时候，先交换，再减
        int two = len - 1;
        int i = 0;
        // 当 i == two 的时候，还有一个元素还没有看，
        // 因此，循环可以继续的条件是 i <= two
        while (i <= two) {
            if (nums[i] == 0) {
                zero++;
                swap(nums, i, zero);
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, two);
                two--;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


}
