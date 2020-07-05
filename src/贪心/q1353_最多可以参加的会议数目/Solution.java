package 贪心.q1353_最多可以参加的会议数目;

import 树的遍历.q94_二叉树的中序遍历.TreeNode;

import java.util.*;

/**
 * 1353. 最多可以参加的会议数目
 * 给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 endDayi 。
 * <p>
 * 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。注意，一天只能参加一个会议。
 * <p>
 * 请你返回你可以参加的 最大 会议数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：events = [[1,2],[2,3],[3,4]]
 * 输出：3
 * 解释：你可以参加所有的三个会议。
 * 安排会议的一种方案如上图。
 * 第 1 天参加第一个会议。
 * 第 2 天参加第二个会议。
 * 第 3 天参加第三个会议。
 * 示例 2：
 * <p>
 * 输入：events= [[1,2],[2,3],[3,4],[1,2]]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：events = [[1,4],[4,4],[2,2],[3,4],[1,1]]
 * 输出：4
 * 示例 4：
 * <p>
 * 输入：events = [[1,100000]]
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：events = [[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]]
 * 输出：7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= events.length <= 10^5
 * events[i].length == 2
 * 1 <= events[i][0] <= events[i][1] <= 10^5
 */
public class Solution {


    /**
     * @Title maxEvents
     * @Description 贪心算法
     * @Author zph
     * @Date 2020/7/5 18:49
     * @Param [events]
     * @return int
     */
    public int maxEvents(int[][] events) {
        //首先排序：开始时间小的在前。这样是方便我们顺序遍历，把开始时间一样的都放进堆
        Arrays.sort(events, (o1, o2) -> o1[0] - o2[0]);
        //小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //结果、开始时间、events下标、有多少组数据
        int res = 0, last = 1, i = 0, n = events.length;
        while (i < n || !pq.isEmpty()) {
            //将start相同的会议都放进堆里
            while (i < n && events[i][0] == last) {
                pq.offer(events[i++][1]);
            }
            //pop掉当前天数之前的
            while (!pq.isEmpty() && pq.peek() < last) {
                pq.poll();
            }
            //顶上的就是俺们要参加的
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
            last++;
        }
        return res;


    }

}
