package 动态规划.q312_戳气球.f2;

import java.util.Arrays;

/**
 * @ClassName : Solution
 * @Description :312. 戳气球
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *
 * 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 * 说明:
 *
 * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 示例:
 *
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * @Author : zph
 * @Date: 2020-07-19 21:54
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title maxCoins
     * @Description 动态规划
     * @Author zph
     * @Date 2020/7/19 22:11
     * @Param [nums]
     * @return int
     */
    public int maxCoins(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int length=nums.length;
         int[] temp=new int[length+2];
        for(int i=1;i<=length;i++){
            temp[i]=nums[i-1];
        }
        temp[0]=temp[length+1]=1;
        int[][] dp=new int[length+2][length+2];
        for (int i=0;i<length+2;i++){
            Arrays.fill(dp[i],-1);
        }

        for(int i=length-1;i>=0;i--){
            for(int j=i+1;j<=length+1;j++){
                for(int k=i+1;k<j;k++){
                    int sum=temp[i]*temp[k]*temp[j];
                    sum+=dp[i][k]+dp[k][j];
                    dp[i][j]=Math.max(dp[i][j],sum);
                }

            }

        }
        return dp[0][length+1];
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={3,1,5,8};
        int i = solution.maxCoins(nums);
        System.out.println(i);
    }
}
