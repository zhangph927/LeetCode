package 回溯法.子集.q90_子集II.f3;

import java.util.*;

/**
 * @ClassName : Solution
 * @Description :90. 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * @Author : zph
 * @Date: 2020-09-06 16:03
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @Title subsetsWithDup
     * @Description 位操作
     * @Author zph
     * @Date 2020/9/6 16:08
     * @Param [nums]
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int subsetNum = 1 << nums.length;
        for (int i = 0; i < subsetNum; i++) {
            List<Integer> list = new ArrayList<>();
            boolean illegal = false;
            for (int j = 0; j < nums.length; j++) {
                //当前位是 1
                if ((i >> j & 1) == 1) {
                    //当前是重复数字，并且前一位是 0，跳过这种情况
                    if (j > 0 && nums[j] == nums[j - 1] && (i >> (j - 1) & 1) == 0) {
                        illegal = true;
                        break;
                    } else {
                        list.add(nums[j]);
                    }
                }
            }
            if (!illegal) {
                lists.add(list);
            }

        }
        return lists;

    }

}
