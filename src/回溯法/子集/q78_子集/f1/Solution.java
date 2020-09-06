package 回溯法.子集.q78_子集.f1;

import 王争算法课程代码.q09_queue.ArrayQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * @Author : zph
 * @Date: 2020-09-05 22:34
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title subsets
     * @Description 递归
     * @Author zph
     * @Date 2020/9/6 15:25
     * @Param [nums]
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        for(int num:nums){
            List<List<Integer>> subsets = new ArrayList<>();
            for(List<Integer> curr: output){
                List<Integer> list = new ArrayList<>(curr);
                list.add(num);
                subsets.add(list);
            }
            for(List<Integer> sub:subsets){
                output.add(sub);
            }
        }
        return output;


    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Solution solution = new Solution();
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println(subsets.toString());

    }
}
