package 广度优先BFS.q847_访问所有节点的最短路径.f2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : Solution
 * @Description :847. 访问所有节点的最短路径
 * 给出 graph 为有 N 个节点（编号为 0, 1, 2, ..., N-1）的无向连通图。
 * <p>
 * graph.length = N，且只有节点 i 和 j 连通时，j != i 在列表 graph[i] 中恰好出现一次。
 * <p>
 * 返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[1,2,3],[0],[0],[0]]
 * 输出：4
 * 解释：一个可能的路径为 [1,0,2,0,3]
 * 示例 2：
 * <p>
 * 输入：[[1],[0,2,4],[1,3,4],[2],[1,2]]
 * 输出：4
 * 解释：一个可能的路径为 [0,1,4,2,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= graph.length <= 12
 * 0 <= graph[i].length < graph.length
 * @Author : zph
 * @Date: 2020-07-13 17:09
 * @Version : V1.0
 */
public class Solution {


    /**
     * @Title shortestPathLength
     * @Description 动态规划
     * @Author zph
     * @Date 2020/7/13 17:45
     * @Param [graph]
     * @return int
     */
    public int shortestPathLength(int[][] graph) {
        int N = graph.length;
        int dist[][] = new int[1 << N][N];
        for (int[] row: dist) Arrays.fill(row, N*N);
        for (int x = 0; x < N; ++x) dist[1<<x][x] = 0;

        for (int cover = 0; cover < 1 << N; ++cover) {
            boolean repeat = true;
            while (repeat) {
                repeat = false;
                for (int head = 0; head < N; ++head) {
                    int d = dist[cover][head];
                    for (int next: graph[head]) {
                        int cover2 = cover | (1 << next);
                        if (d + 1 < dist[cover2][next]) {
                            dist[cover2][next] = d+1;
                            if (cover == cover2) repeat = true;
                        }
                    }
                }
            }
        }

        int ans = N*N;
        for (int cand: dist[(1<<N) - 1])
            ans = Math.min(cand, ans);
        return ans;

    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] graph = {{1, 2, 3}, {0}, {0}, {0}};
        int i = solution.shortestPathLength(graph);
        System.out.println(i);





    }




}
