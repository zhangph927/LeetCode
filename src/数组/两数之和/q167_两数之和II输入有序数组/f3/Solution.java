package 数组.两数之和.q167_两数之和II输入有序数组.f3;

/**
 * @ClassName : Solution
 * @Description :167. 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * @Author : zph
 * @Date: 2020-07-20 22:47
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return int[]
     * @Title twoSum
     * @Description 双指针
     * @Author zph
     * @Date 2020/7/20 22:55
     * @Param [numbers, target]
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        if (numbers == null || numbers.length == 0) {
            return ans;
        }
        int length = numbers.length;

        int left=0;
        int right=length-1;
        while (left<right){
            int total=numbers[left]+numbers[right];
            if(target==total){
                ans[0]=left+1;
                ans[1]=right+1;
                return ans;
            }else if(target<total){
                right--;
            }else {
                left++;
            }
        }
        return ans;
    }
}
