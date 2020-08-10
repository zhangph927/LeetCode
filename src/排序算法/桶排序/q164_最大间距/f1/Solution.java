package 排序算法.桶排序.q164_最大间距.f1;

import java.util.Arrays;

/**
 * @ClassName : Solution
 * @Description :164. 最大间距
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 *
 * 如果数组元素个数小于 2，则返回 0。
 *
 * 示例 1:
 *
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例 2:
 *
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * 说明:
 *
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 * @Author : zph
 * @Date: 2020-08-09 23:10
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title maximumGap
     * @Description 比较排序
     * @Author zph
     * @Date 2020/8/9 23:24
     * @Param [nums]
     * @return int
     */
    public int maximumGap(int[] nums) {
        int length=nums.length;
        Arrays.sort(nums);
        int ans=0;
        for(int i=0;i<length-1;i++){
            ans=Math.max(ans,nums[i+1]-nums[i]);
        }
        return ans;
    }
}
