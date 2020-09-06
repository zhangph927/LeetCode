package 回溯法.子集.q90_子集II.f1;

import java.util.*;

/**
 * @ClassName : Solution
 * @Description :90. 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * @Author : zph
 * @Date: 2020-09-06 16:03
 * @Version : V1.0
 */
public class Solution {
    List<List<Integer>> output = new ArrayList<>();
    int n;
    int k;

    /**
     * @Title subsetsWithDup
     * @Description 回溯
     * @Author zph
     * @Date 2020/9/6 16:08
     * @Param [nums]
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return output;
        }
        n = nums.length;
        Arrays.sort(nums);
        for (k = 0; k <= n; k++) {
            boolean[] used = new boolean[n];
            backTracking(0, new ArrayDeque<>(), nums,used);
        }
        return output;
    }

    private void backTracking(int first, Deque<Integer> path, int[] nums, boolean[] used) {
        if (path.size() == k) {
            output.add(new ArrayList<>(path));
            return;
        }
        for (int i = first; i < n; i++) {
            if(used[i]){
                continue;
            }
            //和上个数字相等就跳过
            if (i > first && nums[i] == nums[i - 1]) {
                continue;
            }

            used[i]=true;
            path.addLast(nums[i]);
            backTracking(i + 1, path, nums,used);
            used[i]=false;
            path.removeLast();
        }

    }






}
