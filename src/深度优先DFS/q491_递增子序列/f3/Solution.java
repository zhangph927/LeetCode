package 深度优先DFS.q491_递增子序列.f3;

import jdk.nashorn.internal.objects.NativeUint8Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName : Solution
 * @Description :491. 递增子序列
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * <p>
 * 示例:
 * <p>
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 说明:
 * <p>
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 * @Author : zph
 * @Date: 2020-08-26 00:40
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @Title findSubsequences
     * @Description 递归枚举 + 减枝
     * @Author zph
     * @Date 2020/8/27 1:04
     * @Param [nums]
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    private List<Integer> temp = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();

    private void dfs(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);

        }
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums);
        }

    }


    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = {4, 6, 6, 6, 7, 7};
        List<List<Integer>> subsequences = solution.findSubsequences(nums);
        System.out.println(subsequences.toString());
    }

}
