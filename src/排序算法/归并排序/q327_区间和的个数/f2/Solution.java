package 排序算法.归并排序.q327_区间和的个数.f2;

/**
 * @ClassName : Solution
 * @Description :327. 区间和的个数
 * 给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 * <p>
 * 说明:
 * 最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [-2,5,-1], lower = -2, upper = 2,
 * 输出: 3
 * 解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
 * @Author : zph
 * @Date: 2020-08-09 14:55
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title countRangeSum
     * @Description n^2暴力解法
     * @Author zph
     * @Date 2020/8/9 15:28
     * @Param [nums, lower, upper]
     * @return int
     */

    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int count = 0;
        long[] res = new long[nums.length];
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(lower<= nums[i] && nums[i]<=upper){//单个数值在所给区间范围
                count++;
            }
            sum += nums[i];
            res[i] = sum;
        }
        for(int i = 1; i < nums.length; i++){
            if(lower<= res[i] && res[i]<=upper){//从第0个到第i个元素之和在所给区间范围
                count++;
            }
            for(int j = 0; j < i-1; j++){
                long z = res[i] - res[j];
                if(lower<= z && z<=upper){ //从第i(i>0)个到第j个元素之和在所给区间范围
                    count++;
                }
            }
        }
        return count;
    }

}
