package 二分法.q287_寻找重复数.f1;

/**
 * @ClassName : Solution
 * @Description :287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * @Author : zph
 * @Date: 2020-07-25 17:35
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title findDuplicate
     * @Description 二分法
     * @Author zph
     * @Date 2020/7/25 17:36
     * @Param [nums]
     * @return int
     */
    public int findDuplicate(int[] nums) {
        int length=nums.length;
        int left=0;
        int right=length-1;
        int count=0;
        while (left<right){
            int mid=left+(right-left)/2;
            count=0;
            for (int num:nums){
                if(num<=mid){
                    count++;
                }
            }
            if(count>mid){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return left;

        
    }
}
