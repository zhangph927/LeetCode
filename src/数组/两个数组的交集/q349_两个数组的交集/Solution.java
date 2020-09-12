package 数组.两个数组的交集.q349_两个数组的交集;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName : Solution
 * @Description :349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * @Author : zph
 * @Date: 2020-07-13 23:17
 * @Version : V1.0
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        Set<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        set2.retainAll(set1);
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        if (set1.size() > set2.size()) {
            return setIntersectoin(set1, set2);

        } else {
            return setIntersectoin(set2, set1);
        }


    }

    private int[] setIntersectoin(Set<Integer> set1, Set<Integer> set2) {
        int[] res = new int[set2.size()];
        int i = 0;
        for (int num : set2) {
            if (set1.contains(num)) {
                res[i] = num;
                i++;
            }
        }
        //防止出现0
        return Arrays.copyOf(res, i);
    }
}
