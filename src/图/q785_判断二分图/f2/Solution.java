package 图.q785_判断二分图.f2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : Solution
 * @Description :785. 判断二分图
 * 给定一个无向图graph，当这个图为二分图时返回true。
 *
 * 如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
 *
 * graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。
 *
 *
 * 示例 1:
 * 输入: [[1,3], [0,2], [1,3], [0,2]]
 * 输出: true
 * 解释:
 * 无向图如下:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * 我们可以将节点分成两组: {0, 2} 和 {1, 3}。
 *
 * 示例 2:
 * 输入: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * 输出: false
 * 解释:
 * 无向图如下:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * 我们不能将节点分割成两个独立的子集。
 * 注意:
 *
 * graph 的长度范围为 [1, 100]。
 * graph[i] 中的元素的范围为 [0, graph.length - 1]。
 * graph[i] 不会包含 i 或者有重复的值。
 * 图是无向的: 如果j 在 graph[i]里边, 那么 i 也会在 graph[j]里边。
 * @Author : zph
 * @Date: 2020-07-16 22:53
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title isBipartite
     * @Description 深度遍历
     * @Author zph
     * @Date 2020/7/16 22:53
     * @Param [graph]
     * @return boolean
     */
    public boolean isBipartite(int[][] graph) {
        int row=graph.length;
        //1和-1表示两种不同颜色
       int[] visited= new int[row];
       for(int i=0;i<row;i++){
           if(visited[i]==0&&!dfs(visited,i,1,graph)){
               return false;
           }
       }
       return true;



    }

    private boolean dfs(int[] visited,int j,int color,int[][] graph){
        // 如果要对某顶点染色时，发现它已经被染色了，则判断它的颜色是否与本次要染的颜色相同，如果矛盾，说明此无向图无法被正确染色，返回 false。
        if(visited[j]!=0){
            return visited[j]==color;
        }
        visited[j]=color;
        for(int k:graph[j]){
            if(!dfs(visited,k,-color,graph)){
                return false;
            }

        }
        return true;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] graph= {{1,3}, {0,2}, {1,3}, {0,2}};
        boolean bipartite = solution.isBipartite(graph);

        System.out.println(bipartite);


    }
}
