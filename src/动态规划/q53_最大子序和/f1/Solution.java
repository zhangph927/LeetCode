package 动态规划.q53_最大子序和.f1;

/**
 * @ClassName : Solution
 * @Description :53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * @Author : zph
 * @Date: 2020-10-06 22:44
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title maxSubArray
     * @Description 动态规划
     * @Author zph
     * @Date 2020/10/6 22:45
     * @Param [nums]
     * @return int
     */
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

}
