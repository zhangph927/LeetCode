package 数组.会议室.q253_会议室II;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName : Solution
 * @Description :
 * @Author : zph
 * @Date: 2020-10-18 15:41
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return int
     * @Title minMeetingRooms
     * @Description 解题思路
     *   假设一开始一个会议室都没开放，且会议室开放后不会关闭，可以重复使用。
     * <p>
     *   按照我们日常的逻辑，先对所有的会议安排按照开始时间升序排列。
     * <p>
     *   安排第一个会议，此时一个会议室都没有，直接开放一间会议室使用；
     * <p>
     *   安排第 i 个会议，查看当前有没有会议室是已开放且空闲的，没有则接着开放新的会议室；
     * <p>
     *   查看是否有会议室已开放且空闲，是看当前正在使用会议室的会议中，最早结束的那场会议的结束时间，如果现在还没结束，说明其他会议更不可能结束，直接开放新的会议室。
     * <p>
     *   若在以开放的会议室中，最早结束的那场会议以及结束，说明现在存在空闲会议室，直接加入即可。
     * <p>
     *   先对所有的会议时间按开始时间从小到大排序。
     * <p>
     *   接着定义一个小顶堆作为会议室，每个节点的值是会议的结束时间。
     * <p>
     *   小顶堆在我的代码中是用优先队列。无论加入多少个队列，小顶堆的堆顶就是当前使用会议室中最早的结束时间，并且小顶堆的元素个数即会议室当前占用的间数。
     * <p>
     *   最早开始的会议的结束时间 add 到小顶堆中。
     * <p>
     *   接着对 [1, size-1] 个会议依次进行以下操作：
     * <p>
     *   1、对比当前会议的开始时间和小顶堆的堆顶元素值，若小于，说明当前所有会议室正在进行的会议中，最早结束的都还没结束，只能新建会议室了；
     * <p>
     *   2、若当前会议的开始时间大于小顶堆的堆顶元素值，说明会议室正在进行的会议中，最早结束的会议已经结束，可以把它从小顶堆删除，自己进入小顶堆（重复利用会议室）。
     * <p>
     *   等最后一个会议时间进入小顶堆，此时的小顶堆元素个数即至少需要的会议室数量。
     * @Author zph
     * @Date 2020/10/18 15:45
     * @Param [intervals]
     */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // 最小堆
        PriorityQueue<Integer> allocator = new PriorityQueue<Integer>(intervals.length, (a, b) -> a - b);

        // 对时间表按照开始时间从小到大排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // 添加第一场会议的结束时间
        allocator.add(intervals[0][1]);

        // 遍历除第一场之外的所有会议
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= allocator.peek()) {
                // 如果当前会议的开始时间大于前面已经开始的会议中最晚结束的时间
                // 说明有会议室空闲出来了，可以直接重复利用
                // 当前时间已经是 intervals[i][0]，因此把已经结束的会议删除
                allocator.poll();
            }
            // 把当前会议的结束时间加入最小堆中
            allocator.add(intervals[i][1]);
        }

        // 当所有会议遍历完毕，还在最小堆里面的，说明会议还没结束，此时的数量就是会议室的最少数量
        return allocator.size();
    }


}
