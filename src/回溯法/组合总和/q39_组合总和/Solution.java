package 回溯法.组合总和.q39_组合总和;

import java.util.*;

/**
 * @ClassName : Solution
 * @Description :39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 * @Author : zph
 * @Date: 2020-07-26 23:19
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @Title combinationSum
     * @Description 回溯+减枝
     * @Author zph
     * @Date 2020/7/26 23:28
     * @Param [candidates, target]
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        int length = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        //排序
        Arrays.sort(candidates);
        dfs(candidates, length, target, 0, new ArrayDeque<>(), res);
        return res;

    }


    /**
     * @return void
     * @Title dfs
     * @Description TODO
     * @Author zph
     * @Date 2020/7/26 23:33
     * @Param [candidates 数组输入,
     * length 输入数组的长度，冗余变量, residue 剩余数值,
     * begin 本轮搜索的起点下标,
     * path 从根结点到任意结点的路径, res 结果集变量]
     */

    private void dfs(int[] candidates, int length, int residue,
                     int begin, Deque<Integer> path, List<List<Integer>> res) {

        if (residue == 0) {
            // 由于 path 全局只使用一份，到叶子结点的时候需要做一个拷贝
            res.add(new ArrayList<>(path));
        }
        for (int i = begin; i < length; i++) {
            // 在数组有序的前提下，剪枝
            if (residue - candidates[i] < 0) {
                break;
            }
            path.addLast(candidates[i]);
            dfs(candidates, length, residue - candidates[i], i, path, res);

            path.removeLast();
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

       int[] candidates = {2,3,5};
       int target = 8;
        List<List<Integer>> lists = solution.combinationSum(candidates, target);
        System.out.println(lists.toString());

    }
}
