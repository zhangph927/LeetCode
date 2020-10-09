package 回溯法.子集.q78_子集.f2;

import java.nio.channels.SelectionKey;
import java.util.*;

/**
 * @ClassName : Solution
 * @Description :78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * @Author : zph
 * @Date: 2020-09-05 22:34
 * @Version : V1.0
 */
public class Solution {
    List<List<Integer>> output = new ArrayList<>();
    int n;
    int k;

    /**
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @Title subsets
     * @Description 回溯
     * @Author zph
     * @Date 2020/9/6 15:25
     * @Param [nums]
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return output;
        }
         n = nums.length;
        for (k = 0; k <= n; k++) {
            backTracking(0, new ArrayDeque<>(), nums);
        }
        return output;
    }

    private void backTracking(int first, Deque<Integer> path, int[] nums) {
        if (path.size() == k) {
            output.add(new ArrayList<>(path));
            return;
        }
        for (int i = first; i < n; i++) {
            path.addLast(nums[i]);
            backTracking(i + 1, path, nums);
            path.removeLast();
        }

    }





    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println(subsets.toString());

    }
}
