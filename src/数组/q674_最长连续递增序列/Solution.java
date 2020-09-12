package 数组.q674_最长连续递增序列;

import java.util.Arrays;

/**
 * @ClassName : Solution
 * @Description 674. 最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 示例 2:
 *
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 *
 *
 * 注意：数组长度不会超过10000。
 *
 * 通过次数29,002提交次数64,199
 * @Author : zph
 * @Date: 2020-07-01 16:44
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title findNumberOfLIS
     * @Description 动态规划
     * @Author zph
     * @Date 2020/7/1 17:05
     * @Param [nums]
     * @return int
     */
    public int findNumberOfLIS(int[] nums) {
        if(nums==null||nums.length==0){
            return  0;
        }
        int length=nums.length;
        int maxLength=0;
        int[] dp=new int[length];
        Arrays.fill(dp,1);

        for(int i=1;i<length;i++){
            if(nums[i]>nums[i-1]) {
                dp[i] = dp[i - 1] + 1;
                maxLength=Math.max(maxLength,dp[i]);
            }
        }
        return  maxLength;


    }

    /**
     * @Title findNumberOfLIS
     * @Description 滑动窗口
     * @Author zph
     * @Date 2020/7/1 17:05
     * @Param [nums]
     * @return int
     */
    public int findNumberOfLIS2(int[] nums) {
        if(nums==null||nums.length==0){
            return  0;
        }
        int length=nums.length;
        int index=0;
        int maxLength=0;
        for(int i=0;i<length;i++){
            if(i>0&&nums[i-1]>=nums[i]){
                index=i;
            }
            maxLength=Math.max(maxLength,i-index+1);
        }
        return  maxLength;


    }


}
