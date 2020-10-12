package 位运算.只出现一次的数字.q260_只出现一次的数字III.f2;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : Solution
 * @Description :260. 只出现一次的数字 III
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * 示例 :
 *
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 注意：
 *
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * @Author : zph
 * @Date: 2020-10-11 23:04
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title singleNumber
     * @Description 两个掩码
     * 本文将使用两个按位技巧：
     *
     * 使用异或运算可以帮助我们消除出现两次的数字；我们计算 bitmask ^= x，则 bitmask 留下的就是出现奇数次的位。
     *
     * @Author zph
     * @Date 2020/10/11 23:06
     * @Param [nums]
     * @return int[]
     */
    public int[] singleNumber(int[] nums) {
        // difference between two numbers (x and y) which were seen only once
        int bitmask = 0;
        for (int num : nums) bitmask ^= num;

        // rightmost 1-bit diff between x and y
        int diff = bitmask & (-bitmask);

        int x = 0;
        // bitmask which will contain only x
        for (int num : nums) if ((num & diff) != 0) x ^= num;

        return new int[]{x, bitmask^x};
    }


}
