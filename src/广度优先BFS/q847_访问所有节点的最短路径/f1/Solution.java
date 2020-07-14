package 广度优先BFS.q847_访问所有节点的最短路径.f1;

import java.sql.PseudoColumnUsage;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
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
     * @Description 广度遍历
     * @Author zph
     * @Date 2020/7/13 17:45
     * @Param [graph]
     * @return int
     */
    public int shortestPathLength(int[][] graph) {
        int len=graph.length;
        if(graph==null || graph.length==0){
            return 0;
        }
        boolean[][] visited=new boolean[len][1<<len]; // 标记是否访问过,用于避免重复访问
        int finishState=(1<<len)-1;  // 用于检查是否访问完所有的节点,每个位代表一个节点的状态,形如1111
        Queue<int[]> queue=new LinkedList<>(); // 队列里的数组,第一个记录的是标号,第二个是状态
        for(int i=0; i<len; i++){
            queue.offer(new int[]{i,1<<i});
        }
        int step=0;
        while(!queue.isEmpty()){
            for(int i=queue.size(); i>0; i--){
                int[] node=queue.poll();
                if(finishState==node[1]){ // 如果标记的节点访问状态是结束,那么返回步长
                    return step;
                }
                for(int next:graph[node[0]]){
                    int nextState=node[1]|(1<<next); // 2个节点相或,标记着访问了这条边的2个点
                    if(visited[next][nextState]){
                        continue;
                    }
                    visited[next][nextState]=true;
                    queue.offer(new int[]{next,nextState}); // 将该节点和边的信息加入bfs对列
                }
            }
            step++;
        }
        return step;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] graph = {{1, 2, 3}, {0}, {0}, {0}};
        int i = solution.shortestPathLength(graph);
        System.out.println(i);


    }




}
