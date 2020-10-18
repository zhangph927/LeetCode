package 数组.q448_找到所有数组中消失的数字.f4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :448. 找到所有数组中消失的数字
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 * @Author : zph
 * @Date: 2020-10-17 22:34
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title findDisappearedNumbers
     * @Description 位图
     * @Author zph
     * @Date 2020/10/17 22:38
     * @Param [nums]
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        int map = 1 << len;

        // 调试代码
        // System.out.println(Integer.toBinaryString(map));
        for (int num : nums) {
            map |= 1 << (num - 1);
            // 调试代码
            // System.out.println(Integer.toBinaryString(map));
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (((map >> i) & 1) == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

}
