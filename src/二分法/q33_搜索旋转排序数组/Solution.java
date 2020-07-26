package 二分法.q33_搜索旋转排序数组;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @ClassName : Solution
 * @Description :33. 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * @Author : zph
 * @Date: 2020-07-24 00:14
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return int
     * @Title search
     * @Description 二分法
     * @Author zph
     * @Date 2020/7/24 0:14
     * @Param [nums, target]
     */
    public int search(int[] nums, int target) {
        int length = nums.length;
        if(length==0){
            return -1;
        }
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = left + (right - left+1) / 2;
            if (nums[mid] < nums[right]) {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target && target <= nums[mid - 1]) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }

        }
        if (nums[left] == target) {
            return left;
        }
        return -1;


    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int search = solution.search(nums, target);
        System.out.println(search);

    }
}
