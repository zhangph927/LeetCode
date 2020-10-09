package 数组.q56_合并区间;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName : Solution
 * @Description :56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * intervals[i][0] <= intervals[i][1]
 * @Author : zph
 * @Date: 2020-09-09 15:22
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return int[][]
     * @Title merge
     * @Description 合并 n 个区间
     * @Author zph
     * @Date 2020/10/6 23:47
     * @Param [intervals]
     */
    public int[][] merge(int[][] intervals) {

        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }

}
