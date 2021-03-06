package 动态规划.q673_最长递增子序列的个数;

import java.util.Arrays;

/**
 * @ClassName : Solution_673
 * @Description :673. 最长递增子序列的个数
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * 示例 2:
 *
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 * 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
 * @Author : zph
 * @Date: 2020-07-01 17:11
 * @Version : V1.0
 */
public class Solution {

    public int findNumberOfLIS(int[] nums) {
        int length=nums.length;
        //以i结尾的最长递增子序列
        int[] dp=new int[length];
        //以i结尾的最长递增子序列个数
        int[] counter=new int[length];
        Arrays.fill(dp,1);
        Arrays.fill(counter,1);
        for(int i=0;i<length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if((dp[j]+1)>dp[i]){
                        dp[i]=Math.max(dp[j]+1,dp[i]);
                        counter[i]=counter[j];
                    }else if((dp[j]+1)==dp[i]){
                        counter[i]+=counter[j];
                    }
                }
            }
        }
        int maxLength=0;
        for(int len: dp){
            maxLength=Math.max(len,maxLength);
        }
        int totalCount=0;
        for(int i=0;i<length;i++){
            if(dp[i]==maxLength){
                totalCount+=counter[i];
            }
        }
        return  totalCount;





    }
}
