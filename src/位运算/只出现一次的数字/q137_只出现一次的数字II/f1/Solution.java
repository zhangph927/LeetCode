package 位运算.只出现一次的数字.q137_只出现一次的数字II.f1;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName : Solution
 * @Description :137. 只出现一次的数字 II
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 * @Author : zph
 * @Date: 2020-10-11 22:59
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title singleNumber
     * @Description HashSet
     * 将输入数组存储到 HashSet，然后使用 HashSet 中数字和的三倍与数组之和比较。
     *
     * 3 \times (a + b + c) - (a + a + a + b + b + b + c) = 2 c
     * 3×(a+b+c)−(a+a+a+b+b+b+c)=2c
     *
     * @Author zph
     * @Date 2020/10/11 23:02
     * @Param [nums]
     * @return int
     */
    public int singleNumber(int[] nums) {
        Set<Long> set = new HashSet<>();
        long sumSet = 0, sumArray = 0;
        for(int n : nums) {
            sumArray += n;
            set.add((long)n);
        }
        for(Long s : set) sumSet += s;
        return (int)((3 * sumSet - sumArray) / 2);
    }

}
