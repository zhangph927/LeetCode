package 回溯法.q996_正方形数组的数目.f2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : Solution
 * @Description :996. 正方形数组的数目
 * 给定一个非负整数数组 A，如果该数组每对相邻元素之和是一个完全平方数，则称这一数组为正方形数组。
 *
 * 返回 A 的正方形排列的数目。两个排列 A1 和 A2 不同的充要条件是存在某个索引 i，使得 A1[i] != A2[i]。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,17,8]
 * 输出：2
 * 解释：
 * [1,8,17] 和 [17,8,1] 都是有效的排列。
 * 示例 2：
 *
 * 输入：[2,2,2]
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 12
 * 0 <= A[i] <= 1e9
 * @Author : zph
 * @Date: 2020-08-30 18:05
 * @Version : V1.0
 */
public class Solution {


    /**
     * @Title numSquarefulPerms
     * @Description 动态规划
     * 现在，我们令 dfs(node, visited) 等于从 node 节点出发访问剩余的节点的可行方法数。这里，visited 是一个掩码：(visited >> i) & 1 为真，当且仅当第 i 个节点已经被访问过了。
     *
     * 这样计算之后，对于 A 中拥有相同值的节点我们会重复计算。考虑这个因素，对于 A 中的值 x，如果 A 中包含 k 个值为 x 的节点，我们令最终答案除以 k!。
     *
     *
     * @Author zph
     * @Date 2020/8/31 14:08
     * @Param [A]
     * @return int
     */
    int N;
    Map<Integer, List<Integer>> graph;
    Integer[][] memo;

    //// TODO: 2020/9/2 状态压缩dp 后期在考虑
    public int numSquarefulPerms(int[] A) {
        N = A.length;
        graph = new HashMap();
        memo = new Integer[N][1 << N];

        for (int i = 0; i < N; ++i)
            graph.put(i, new ArrayList());

        for (int i = 0; i < N; ++i)
            for (int j = i+1; j < N; ++j) {
                int r = (int) (Math.sqrt(A[i] + A[j]) + 0.5);
                if (r * r == A[i] + A[j]) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }


        int[] factorial = new int[20];
        factorial[0] = 1;
        for (int i = 1; i < 20; ++i)
            factorial[i] = i * factorial[i-1];

        int ans = 0;
        for (int i = 0; i < N; ++i)
            ans += dfs(i, 1 << i);

        Map<Integer, Integer> count = new HashMap();
        for (int x: A)
            count.put(x, count.getOrDefault(x, 0) + 1);
        for (int v: count.values())
            ans /= factorial[v];

        return ans;
    }

    public int dfs(int node, int visited) {
        if (visited == (1 << N) - 1)
            return 1;
        if (memo[node][visited] != null)
            return memo[node][visited];

        int ans = 0;
        for (int nei: graph.get(node))
            if (((visited >> nei) & 1) == 0)
                ans += dfs(nei, visited | (1 << nei));
        memo[node][visited] = ans;
        return ans;
    }

}
