package 二分法.q面试题0803魔术索引.f2;

/**
 * @ClassName : Solution
 * @Description :面试题 08.03. 魔术索引
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 * <p>
 * 示例1:
 * <p>
 * 输入：nums = [0, 2, 3, 4, 5]
 * 输出：0
 * 说明: 0下标的元素为0
 * 示例2:
 * <p>
 * 输入：nums = [1, 1, 1]
 * 输出：1
 * 说明:
 * <p>
 * nums长度在[1, 1000000]之间
 * 此题为原书中的 Follow-up，即数组中可能包含重复元素的版本
 * @Author : zph
 * @Date: 2020-07-31 21:06
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return int
     * @Title findMagicIndex
     * @Description 二分剪枝
     * @Author zph
     * @Date 2020/7/31 21:28
     * @Param [nums]
     */
    public int findMagicIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return getAnswer(nums, 0, nums.length - 1);
    }

    private int getAnswer(int[] num, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        int leftAnswer = getAnswer(num, left, mid - 1);
        if (leftAnswer != -1) {
            return leftAnswer;
        }
        if (num[mid] == mid) {
            return mid;
        }
        return getAnswer(num, mid + 1, right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
      int[]  nums = {1, 1, 1};
        int magicIndex = solution.findMagicIndex(nums);
        System.out.println(magicIndex);



    }

}
