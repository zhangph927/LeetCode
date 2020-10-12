package 位运算.只出现一次的数字.q137_只出现一次的数字II.f3;

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
     * @Description 位运算符：NOT，AND 和 XOR
     *
     * @Author zph
     * @Date 2020/10/11 23:02
     * @Param [nums]
     * @return int
     */
    public int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
            // first appearence:
            // add num to seen_once
            // don't add to seen_twice because of presence in seen_once

            // second appearance:
            // remove num from seen_once
            // add num to seen_twice

            // third appearance:
            // don't add to seen_once because of presence in seen_twice
            // remove num from seen_twice
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }

        return seenOnce;
    }


}
