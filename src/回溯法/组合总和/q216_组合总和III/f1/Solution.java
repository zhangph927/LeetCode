package 回溯法.组合总和.q216_组合总和III.f1;

import java.util.*;

/**
 * @ClassName : Solution
 * @Description :216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，
 * 并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * @Author : zph
 * @Date: 2020-09-03 11:26
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title combinationSum3
     * @Description 回溯
     * @Author zph
     * @Date 2020/9/3 16:38
     * @Param [k, n]
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates={1,2,3,4,5,6,7,8,9};
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if(k<=0){
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(candidates, len, 0, n, path, res,k);
        return res;
    }



    /**
     * @param candidates 候选数组
     * @param len        冗余变量
     * @param begin      从候选数组的 begin 位置开始搜索
     * @param target     表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
     * @param path       从根结点到叶子结点的路径
     * @param res
     */
    private void dfs(int[] candidates, int len, int begin,
                     int target, Deque<Integer> path,
                     List<List<Integer>> res,int totalCount) {
        if(totalCount==0){
            if (target == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
            return;
        }
        for (int i = begin; i < len; i++) {
            // 大剪枝
            if (target - candidates[i] < 0) {
                break;
            }

            path.addLast(candidates[i]);
            // 调试语句 ①
            // System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));

            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfs(candidates, len, i + 1,
                    target - candidates[i], path, res,totalCount-1);

            path.removeLast();
            // 调试语句 ②
            // System.out.println("递归之后 => " + path + "，剩余 = " + (target - candidates[i]));
        }
    }
}
