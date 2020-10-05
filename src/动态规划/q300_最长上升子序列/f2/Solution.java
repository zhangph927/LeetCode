package 动态规划.q300_最长上升子序列.f2;

/**
 * @ClassName : Solution
 * @Description :300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * @Author : zph
 * @Date: 2020-07-22 00:01
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return int
     * @Title lengthOfLIS
     * @Description 贪心+二分
     * @Author zph
     * @Date 2020/7/22 0:09
     * @Param [nums]
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length < 2) {
            return 1;
        }
        int[] tail = new int[length + 1];
        tail[0] = nums[0];
        int end = 0;
        for (int i = 0; i < length; i++) {

            if (nums[i] > tail[end]) {
                end++;
                tail[end] = nums[i];
            } else {
                //找到第一个大于nums[i]的值
                int left=0;
                int right=end;
                while (left<right){
                    int mid=left+(right-left)/2;
                    if(tail[mid]<nums[i]){
                        left=mid+1;
                    }else {
                        right=mid;
                    }
                }
                tail[left]=nums[i];
            }
        }
        end++;
        return end;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int length = solution.lengthOfLIS(nums);
        System.out.println(length);


    }
}
