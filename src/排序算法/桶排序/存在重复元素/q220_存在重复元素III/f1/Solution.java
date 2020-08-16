package 排序算法.桶排序.存在重复元素.q220_存在重复元素III.f1;

import java.util.Comparator;

/**
 * @ClassName : Solution
 * @Description :在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ķ 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 *
 * @Author : zph
 * @Date: 2020-08-10 18:14
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title containsNearbyAlmostDuplicate
     * @Description 线性搜索
     * @Author zph
     * @Date 2020/8/15 17:33
     * @Param [nums, k, t]
     * @return boolean
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int length=nums.length;
        for(int i=0;i<length;i++){
            for(int j=Math.max(i-k,0);j<i;j++){

                if(Math.abs(nums[i]-nums[j])<=t){
                    return true;
                }
            }
        }
        return false;
    }




}
