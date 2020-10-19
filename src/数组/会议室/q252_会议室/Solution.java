package 数组.会议室.q252_会议室;

import java.util.Arrays;

/**
 * @ClassName : Solution
 * @Description :
 * @Author : zph
 * @Date: 2020-10-18 15:41
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title canAttendMeetings
     * @Description 解题思路
     *   本题的目的是判断所有数组是否存在交集。
     *
     *   1、先对每个时间数组按照开始时间从小到大排序；
     *
     *   2、从第 0 个到第 n-2 个依次遍历，看当前时间区间的结束时间是否大于下一个时间区间的开始，如果大于，说明存在交集；
     * @Author zph
     * @Date 2020/10/18 15:44
     * @Param [intervals]
     * @return boolean
     */
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) return false;
        }
        return true;
    }
}
