package 数组操作.两数之和.q16_最接近的三数之和;

import java.util.Arrays;

/**
 * @ClassName : Solution
 * @Description :16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 *
 * 提示：
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * @Author : zph
 * @Date: 2020-09-02 18:17
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title threeSumClosest
     * @Description 排序 + 双指针
     * @Author zph
     * @Date 2020/9/2 18:19
     * @Param [nums, target]
     * @return int
     */
    public int threeSumClosest(int[] nums, int target) {
        //先排序
        Arrays.sort(nums);
        int length=nums.length;
        //最接近的值
        int best=nums[0]+nums[1]+nums[2];

        for(int i=0;i<length;i++){

            int k=length-1;

            int j=i+1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];

                if(Math.abs(sum-target)<Math.abs(best-target)){
                    best=sum;
                }

                if(sum>target){
                    k--;
                }else if(sum<target){
                    j++;
                }else{
                    return best;
                }
            }
        }

        return best;
    }
}
