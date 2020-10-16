package 数组.求众数.q169_多数元素.f2;

/**
 * @ClassName : Solution
 * @Description :169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * @Author : zph
 * @Date: 2020-10-13 22:59
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title majorityElement
     * @Description Boyer-Moore 投票算法
     * @Author zph
     * @Date 2020/10/13 23:02
     * @Param [nums]
     * @return int
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }


}
