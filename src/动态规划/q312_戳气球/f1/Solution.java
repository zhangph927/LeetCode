package 动态规划.q312_戳气球.f1;

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
    private int[][] rec;
    private int[] temp;
    /**
     * @Title maxCoins
     * @Description 记忆化搜索
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
        temp=new int[length+2];
        for(int i=1;i<=length;i++){
            temp[i]=nums[i-1];
        }
        temp[0]=temp[length+1]=1;
        rec=new int[length+2][length+2];
        for (int i=0;i<length+2;i++){
            Arrays.fill(rec[i],-1);
        }
        return helper(0,length+1);
    }
    private int helper(int left,int right){
        if(left>=right-1){
            return 0;
        }
        if(rec[left][right]!=-1){
            return rec[left][right];
        }
        for(int i=left+1;i<right;i++){
            int sum=temp[left]*temp[i]*temp[right];
            sum+=helper(left,i)+helper(i,right);
            rec[left][right]=Math.max(rec[left][right],sum);
        }
        return rec[left][right];

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={3,1,5,8};
        int i = solution.maxCoins(nums);
        System.out.println(i);
    }
}
