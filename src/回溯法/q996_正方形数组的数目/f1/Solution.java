package 回溯法.q996_正方形数组的数目.f1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : Solution
 * @Description :996. 正方形数组的数目
 * 给定一个非负整数数组 A，如果该数组每对相邻元素之和是一个完全平方数，则称这一数组为正方形数组。
 * <p>
 * 返回 A 的正方形排列的数目。两个排列 A1 和 A2 不同的充要条件是存在某个索引 i，使得 A1[i] != A2[i]。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,17,8]
 * 输出：2
 * 解释：
 * [1,8,17] 和 [17,8,1] 都是有效的排列。
 * 示例 2：
 * <p>
 * 输入：[2,2,2]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 12
 * 0 <= A[i] <= 1e9
 * @Author : zph
 * @Date: 2020-08-30 18:05
 * @Version : V1.0
 */
public class Solution {


    Map<Integer, Integer> count;
    Map<Integer, List<Integer>> graph;

    /**
     * @return int
     * @Title numSquarefulPerms
     * @Description 回溯
     * 构造一张图，包含所有的边 ii 到 jj ，如果满足 A[i] + A[j]A[i]+A[j] 是一个完全平方数。我们的目标就是求这张图的所有哈密顿路径，即经过图中所有点仅一次的路径。
     * @Author zph
     * @Date 2020/8/31 14:08
     * @Param [A]
     */
    public int numSquarefulPerms(int[] A) {
        int N = A.length;
        count = new HashMap();
        graph = new HashMap();

        // count.get(v) : 数组 A 中值为 v 的节点数量
        for (int x : A)
            count.put(x, count.getOrDefault(x, 0) + 1);

        // graph.get(v) : 在 A 中的值 w 满足 v + w 是完全平方数
        //                (ie., "vw" is an edge)
        for (int x : count.keySet())
            graph.put(x, new ArrayList());

        for (int x : count.keySet())
            for (int y : count.keySet()) {
                int r = (int) (Math.sqrt(x + y) + 0.5);
                if (r * r == x + y)
                    graph.get(x).add(y);
            }

        // 增加从 x 开始的可行路径数量
        int ans = 0;
        for (int x : count.keySet())
            ans += dfs(x, N - 1);
        return ans;
    }

    public int dfs(int x, int todo) {
        count.put(x, count.get(x) - 1);
        int ans = 1;
        if (todo != 0) {
            ans = 0;
            for (int y : graph.get(x))
                if (count.get(y) != 0) {
                    ans += dfs(y, todo - 1);
                }
        }
        count.put(x, count.get(x) + 1);
        return ans;
    }


    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] a = {17};
        int i = solution.numSquarefulPerms(a);
        System.out.println(i);

    }

}
