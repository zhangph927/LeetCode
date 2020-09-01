package 回溯法.全排列.q46_全排列.f1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * @Author : zph
 * @Date: 2020-08-29 22:22
 * @Version : V1.0
 */
public class Solution {
    
    public void backtrack(int n,
                          ArrayList<Integer> output,
                          List<List<Integer>> res,
                          int first) {
        // 所有数都填完了
        if (first == n)
            res.add(new ArrayList<Integer>(output));
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    /**
     * @Title permute
     * @Description 搜索回溯
     * @Author zph
     * @Date 2020/8/29 22:23
     * @Param [nums]
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList();

        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int num : nums)
            output.add(num);

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

}
