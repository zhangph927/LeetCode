package 数组操作.两个数组的交集.q350两个数组的交集II.f1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : Solution
 * @Description :350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * @Author : zph
 * @Date: 2020-07-13 23:32
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return int[]
     * @Title intersect
     * @Description 哈希表
     * @Author zph
     * @Date 2020/7/14 0:12
     * @Param [nums1, nums2]
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums1) {
            Integer count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int index = 0;

        int[] res = new int[nums1.length];
        for (int num : nums2) {
            Integer count = map.getOrDefault(num, 0);
            if (count > 0) {
                res[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }

        return Arrays.copyOfRange(res, 0, index);
    }


}
