package 图.q785_判断二分图.f3;

/**
 * @ClassName : Solution
 * @Description :785. 判断二分图
 * 给定一个无向图graph，当这个图为二分图时返回true。
 * <p>
 * 如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
 * <p>
 * graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。
 * <p>
 * <p>
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
 * <p>
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
 * <p>
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
     * @return boolean
     * @Title isBipartite
     * @Description 并查集
     * @Author zph
     * @Date 2020/7/16 22:53
     * @Param [graph]
     */
    public boolean isBipartite(int[][] graph) {
        int row = graph.length;
        UnionFind unionFind = new UnionFind(row);

        for (int i = 0; i < row; i++) {
            int[] adjs = graph[i];
            for (int j : adjs) {
                if (unionFind.isConnected(i, j)) {
                    return false;
                }
                unionFind.union(adjs[0], j);

            }


        }
        return true;


    }

    class UnionFind {
        int[] parent;

        public UnionFind(int length) {
            parent = new int[length];
            for (int i = 0; i < length; i++) {
                parent[i] = i;
            }

        }

        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            parent[i] = find(parent[i]);
            return parent[i];
        }

        public boolean isConnected(int p, int q) {
            return parent[p] == parent[q];
        }

        //合并
        public void union(int p, int q) {
            parent[find(p)] = find(q);
        }

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        boolean bipartite = solution.isBipartite(graph);

        System.out.println(bipartite);


    }
}
