package 堆相关.q347_前K个高频元素.f2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @ClassName : Solution
 * @Description :347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 *
 * 提示：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 * @Author : zph
 * @Date: 2020-09-07 23:38
 * @Version : V1.0
 */
public class Solution {
    
    /**
     * @Title topKFrequent
     * @Description 二叉搜索树
     * @Author zph
     * @Date 2020/9/7 23:38
     * @Param [nums, k]
     * @return int[]
     */
    public int[] topKFrequent(int[] nums, int k) {
        // 统计每个数字出现的次数
        Map<Integer, Integer> counterMap = IntStream.of(nums).boxed().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        // 定义二叉搜索树：key 是数字出现的次数，value 是出现了key次的数字列表。
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        // 维护一个有 k 个数字的二叉搜索树：
        // 不足 k 个直接将当前数字加入到树中；否则判断当前树中的最小次数是否小于当前数字的出现次数，若是，则删掉树中出现次数最少的一个数字，将当前数字加入树中。
        int count = 0;
        for(Map.Entry<Integer, Integer> entry: counterMap.entrySet()) {
            int num = entry.getKey();
            int cnt = entry.getValue();
            if (count < k) {
                treeMap.computeIfAbsent(cnt, ArrayList::new).add(num);
                count++;
            } else {
                Map.Entry<Integer, List<Integer>> firstEntry = treeMap.firstEntry();
                if (cnt > firstEntry.getKey()) {
                    treeMap.computeIfAbsent(cnt, ArrayList::new).add(num);
                    List<Integer> list = firstEntry.getValue();
                    if (list.size() == 1) {
                        treeMap.pollFirstEntry();
                    } else {
                        list.remove(list.size() - 1);
                    }
                }
            }
        }
        // 构造返回结果
        int[] res = new int[k];
        int idx = 0;
        for (List<Integer> list: treeMap.values()) {
            for (int num: list) {
                res[idx++] = num;
            }
        }
        return res;

    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int []nums = {1,1,1,2,2,3};
        int k = 2;
        int[] ints = solution.topKFrequent(nums, k);
        System.out.println(ints);

    }
}
