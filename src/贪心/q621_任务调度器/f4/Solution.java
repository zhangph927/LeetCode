package 贪心.q621_任务调度器.f4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : Solution
 * @Description :621. 任务调度器
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 *
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 *
 * 你需要计算完成所有任务所需要的最短时间。
 *
 *
 *
 * 示例 ：
 *
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 *      在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
 *
 *
 * 提示：
 *
 * 任务的总个数为 [1, 10000]。
 * n 的取值范围为 [0, 100]。
 * @Author : zph
 * @Date: 2020-10-21 22:36
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title leastInterval
     * @Description 桶思想（与官方题解三异曲同工之妙）
     * 思路
     * 桶思想，每个桶固定大小为 n+1（除最后一个桶之外），这样可以确保相同的任务可以分在不同的桶中
     * 当然，每个任务在桶中的次序是固定的，比如说 A 在桶底，那么在每个桶中 A 都在底部，这样可以确保相同任务的间隔时间都不小于 n
     * 桶的数量由 拥有最多任务数的那个任务决定，只要他保证了冷却时间，其他的一定可以
     * 结果就是 (n+1) * (count - 1) + 最后一个桶的大小，count 为桶的数量，因为最后一个桶无需固定大小
     * count 很好求，那最后一个桶大小如何求呢，很明显就是 拥有最多数任务的个数，比如AAABBBCCCDDEE，那最后一个桶的大小就是 3，因为 A B C 都是拥有 3 个任务数
     * 如果冷却时间过短，任务数过多，也就是说桶不够用了，比如说 AAABBBCCCDDEE 且 n = 2 这种情况，此时 桶的大小为 3，桶的数量为 3。第一个桶 ABC ，第二个 ABC，第三个 ABC，此时的 D 和 E 我们可以理解为按照一定次序放在桶之上就行 ，也就是不用放到桶中，这样不会影响桶内元素
     * 由于 D 和 E 的出现次数是一定小于桶的数量的，所以最多每个桶上放一个相同任务，这样 D 和 E 按次序排布是一定符合要求的
     * 此时的答案就是 任务总数 了，因为所有的桶都满了，并且多出来的也是任务，没有待命时间
     * 故答案就是 两个时间 的最大值
     * @Author zph
     * @Date 2020/10/21 22:44
     * @Param [tasks, n]
     * @return int
     */
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> task_map = new HashMap<>();
        // 记录 单个任务出现的最多的次数
        int max_count = 0;
        // 记录 有最多任务数的 任务个数
        int difference = 0;
        for (Character task : tasks) {
            int count = task_map.getOrDefault(task, 0) + 1;
            task_map.put(task, count);
            max_count = Math.max(max_count,count);
        }
        for(Map.Entry<Character, Integer> entry:task_map.entrySet()){
            if(entry.getValue() == max_count) difference++;
        }
        int number1 = (n + 1) * (max_count - 1) + difference;
        int number2 = tasks.length;
        return Math.max(number1,number2);
    }


}
