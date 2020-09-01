package 回溯法.全排列.q47_全排列II;

import java.util.*;

/**
 * @ClassName : Solution
 * @Description :47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * @Author : zph
 * @Date: 2020-08-29 22:22
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title permute
     * @Description 回溯
     * @Author zph
     * @Date 2020/8/29 22:45
     * @Param [nums]
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);

        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;

            dfs(nums, len, depth + 1, path, used, res);

            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.permuteUnique(nums);
        System.out.println(lists);
    }

}
