package 动态规划.状态压缩dp.qLCP13_寻宝;

import java.util.*;

/**
 * @ClassName : Solution
 * @Description :LCP 13. 寻宝
 * 我们得到了一副藏宝图，藏宝图显示，在一个迷宫中存在着未被世人发现的宝藏。
 * <p>
 * 迷宫是一个二维矩阵，用一个字符串数组表示。它标识了唯一的入口（用 'S' 表示），和唯一的宝藏地点（用 'T' 表示）。但是，宝藏被一些隐蔽的机关保护了起来。在地图上有若干个机关点（用 'M' 表示），只有所有机关均被触发，才可以拿到宝藏。
 * <p>
 * 要保持机关的触发，需要把一个重石放在上面。迷宫中有若干个石堆（用 'O' 表示），每个石堆都有无限个足够触发机关的重石。但是由于石头太重，我们一次只能搬一个石头到指定地点。
 * <p>
 * 迷宫中同样有一些墙壁（用 '#' 表示），我们不能走入墙壁。剩余的都是可随意通行的点（用 '.' 表示）。石堆、机关、起点和终点（无论是否能拿到宝藏）也是可以通行的。
 * <p>
 * 我们每步可以选择向上/向下/向左/向右移动一格，并且不能移出迷宫。搬起石头和放下石头不算步数。那么，从起点开始，我们最少需要多少步才能最后拿到宝藏呢？如果无法拿到宝藏，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入： ["S#O", "M..", "M.T"]
 * <p>
 * 输出：16
 * <p>
 * 解释：最优路线为： S->O, cost = 4, 去搬石头 O->第二行的M, cost = 3, M机关触发 第二行的M->O, cost = 3, 我们需要继续回去 O 搬石头。 O->第三行的M, cost = 4, 此时所有机关均触发 第三行的M->T, cost = 2，去T点拿宝藏。 总步数为16。 图片.gif
 * <p>
 * 示例 2：
 * <p>
 * 输入： ["S#O", "M.#", "M.T"]
 * <p>
 * 输出：-1
 * <p>
 * 解释：我们无法搬到石头触发机关
 * <p>
 * 示例 3：
 * <p>
 * 输入： ["S#O", "M.T", "M.."]
 * <p>
 * 输出：17
 * <p>
 * 解释：注意终点也是可以通行的。
 * <p>
 * 限制：
 * <p>
 * 1 <= maze.length <= 100
 * 1 <= maze[i].length <= 100
 * maze[i].length == maze[j].length
 * S 和 T 有且只有一个
 * 0 <= M的数量 <= 16
 * 0 <= O的数量 <= 40，题目保证当迷宫中存在 M 时，一定存在至少一个 O 。
 * @Author : zph
 * @Date: 2020-07-29 23:34
 * @Version : V1.0
 */
public class Solution {
    private int[][] dist;
    private Queue<Point> queue;
    private int[] dir = {-1, 0, 1, 0, -1};  // 压缩方向数组，二维变一维, {-1,0},{0,1},{1,0},{0,-1}
    private int n;
    private int m;
    private int[][] tsDist; // trigger to stone dist
    private int[][] ttDist;  // trigger to trigger dist
    private int[][] f;
    private int INF = 0x3f3f3f3f;

    /**
     * @Title minimalSteps
     * @Description 动态规划
     * @Author zph
     * @Date 2020/7/30 0:05
     * @Param [maze]
     * @return int
     */
    public int minimalSteps(String[] maze) {
        this.n = maze.length;
        this.m = maze[0].length();
        dist = new int[150][150];
        tsDist = new int[20][45];
        ttDist = new int[20][20];
        f = new int[20][1 << 16];
        queue = new LinkedList<>();

        Point startPoint = null;
        Point endPoint = null;
        List<Point> stones = new ArrayList<>();
        List<Point> triggers = new ArrayList<>();

        // 为了方便, string maze -> matrix
        char[][] mat = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = maze[i].charAt(j);
            }
        }
        // init maze
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 'S') {
                    startPoint = new Point(i, j);
                    mat[i][j] = '.';
                    continue;
                }
                if (mat[i][j] == 'T') {
                    endPoint = new Point(i, j);
                    mat[i][j] = '.';
                    continue;
                }
                if (mat[i][j] == 'O') {
                    stones.add(new Point(i, j));
                    mat[i][j] = '.';
                    continue;
                }
                if (mat[i][j] == 'M') {
                    triggers.add(new Point(i, j));
                    mat[i][j] = '.';
                }
            }
        }

        // 起点(S) -> 石堆 -> 机关 -> 石堆 -> 机关 ... -> 石堆 -> 机关 -> 终点(T)
        // 更为统一的: 把起点认为是机关, 终点认为是石堆, 比较方便
        // 机关(S) -> 石堆 -> 机关 -> 石堆 -> 机关 ... -> 石堆 -> 机关 -> 石堆
        triggers.add(startPoint);
        stones.add(endPoint);

        int p = stones.size() - 1;
        int q = triggers.size() - 1;

        // 初始化 tsDist 数组: 计算任意一个机关(trigger) i 到任意一个石堆(stone) j 的距离
        for (int i = 0; i <= q; i++) {
            for (int j = 0; j <= p; j++) {
                tsDist[i][j] = bfs(triggers.get(i), stones.get(j), mat);
            }
        }

        // 初始化 ttDist 数组：当前位于第 i 个机关，下一步要开启第 j 个机关，最少要走多少步
        // 即第 i 个机关走向某个石堆 k，再从该石堆走向机关 j 的步数, floyd
        for (int i = 0; i <= q; i++) {
            for (int j = 0; j <= q; j++) {
                ttDist[i][j] = INF;
                // 枚举石堆, 不算终点
                for (int k = 0; k < p; k++) {
                    if (tsDist[i][k] == -1 || tsDist[j][k] == -1) continue;
                    int cost = tsDist[i][k] + tsDist[j][k];
                    ttDist[i][j] = Math.min(ttDist[i][j], cost);
                }
            }
        }

        // 初始化 dp 数组
        for (int[] a : f) {
            Arrays.fill(a, -1);
        }
        // 最后一个起点0表示未开启。
        f[q][0] = 0;

        // 枚举机关所有状态 staus
        int lim = 1 << q;
        for (int s = 0; s < lim; s++) {
            // 枚举位于第 i 个机关
            for (int i = 0; i <= q; i++) {
                if (f[i][s] == -1) continue;
                // 枚举下一步开启机关 j
                for (int j = 0; j < q; j++) {
                    // 相同机关, 继续
                    if (i == j) continue;
                    // 机关被开启了, 继续
                    if (((s >> j) & 1) != 0) continue;
                    // 第i个机关到第j个机关走不通, 继续
                    if (ttDist[i][j] == INF) continue;
                    int cost = ttDist[i][j];
                    int ns = s | (1 << j);
                    if (f[j][ns] == -1 || f[j][ns] > f[i][s] + cost) {
                        f[j][ns] = f[i][s] + cost;
                    }
                }
            }
        }

        int res = INF;
        for (int i = 0; i <= q; i++) {
            if (f[i][lim - 1] == -1) {
                continue;
            }
            if (tsDist[i][p] == -1) {
                continue;
            }
            int cur = f[i][lim - 1] + tsDist[i][p];
            res = Math.min(res, cur);
        }
        return res == INF ? -1 : res;
    }


    /**
     * BFS: 从给定起点到给定终点最少需要走多少步
     *
     * @param from 起点
     * @param to   终点
     * @return 步数
     */
    private int bfs(Point from, Point to, char[][] maze) {
        // 特判: 如果是墙壁, 返回-1
        if (maze[from.x][from.y] == '#') {
            return -1;
        }
        // 初始化 dist 数组
        for (int[] a : dist) {
            Arrays.fill(a, -1);
        }
        queue.offer(from);
        dist[from.x][from.y] = 0;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i];
                int ny = y + dir[i + 1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || maze[nx][ny] == '#') continue;
                if (dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
        return dist[to.x][to.y];
    }

}

class Point {
    int x, y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] str = {"S#O", "M.T", "M.."};
        int i = solution.minimalSteps(str);
        System.out.println(i);

    }
}
