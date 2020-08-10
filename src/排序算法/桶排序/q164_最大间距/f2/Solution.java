package 排序算法.桶排序.q164_最大间距.f2;

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
     * @Description 非比较排序，计数排序
     * @Author zph
     * @Date 2020/8/9 23:24
     * @Param [nums]
     * @return int
     */
    public int maximumGap(int[] nums) {
        //计数
        if (nums.length < 2) return 0;
        int max = nums[0], min = nums[0], bias = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        bias = 0 - min;
        int[] counter = new int[max - min + 1];
        for (int num : nums) {
            counter[num + bias]++;
        }
        //求最大差值，pre记录前一个元素
        int ans = 0;
        int pre = -1;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                if (pre != -1) {
                    ans = Math.max(ans, i - pre);
                    pre = i;
                } else {
                    pre = i;
                }
            }
        }
        return ans;
    }
}
