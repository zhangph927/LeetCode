package 深度优先DFS.q417_太平洋大西洋水流问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :417. 太平洋大西洋水流问题
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 * <p>
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * <p>
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 给定下面的 5x5 矩阵:
 * <p>
 * 太平洋 ~   ~   ~   ~   ~
 * ~  1   2   2   3  (5) *
 * ~  3   2   3  (4) (4) *
 * ~  2   4  (5)  3   1  *
 * ~ (6) (7)  1   4   5  *
 * ~ (5)  1   1   2   4  *
 * *   *   *   *   * 大西洋
 * <p>
 * 返回:
 * <p>
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 * @Author : zph
 * @Date: 2020-07-17 23:59
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title pacificAtlantic
     * @Description 深度遍历
     * 这里需要定义一个 ans 来存放最后的目标坐标
     * <p>
     * 然后需要定义两个洋的数组，来定义上边界和右边界一组，左边界和下边界为一组进行遍历
     * <p>
     * 然后使用逆流思维，从低处往高处遍历，直到两数组寻找到同一坐标即可放入 ans 作为最终结果
     * @Author zph
     * @Date 2020/7/18 0:00
     * @Param [matrix]
     * @return java.util.List<java.util.List < java.lang.Integer>>
     */
    private int[] dx = new int[]{1, -1, 0, 0};
    private int[] dy = new int[]{0, 0, 1, -1};
    private int m;
    private int n;
    private int[][] matrix;


    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        m = matrix.length;
        n = matrix[0].length;
        this.matrix = matrix;
        //太平洋
        boolean[][] canReachP = new boolean[m][n];
        //大西洋
        boolean[][] canReachA = new boolean[m][n];
        for (int i = 0; i < n; i++) {

            dfs(0, i, canReachP);
            dfs(m - 1, i, canReachA);
        }
        for (int i = 0; i < m; i++) {
            dfs(i, 0, canReachP);
            dfs(i, n - 1, canReachA);
        }

        //判断相交的位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachA[i][j] && canReachP[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }

            }

        }


        return res;


    }

    /**
     * 换一种思路，从边界往里面走，只能走到比自己更高或者等高的地方。边界能走到的地方，就是能流入对应海洋的地方。
     */
    private void dfs(int x, int y, boolean[][] temp) {
        temp[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (isIn(newX, newY) && matrix[x][y] <= matrix[newX][newY] && !temp[newX][newY]) {
                dfs(newX, newY, temp);
            }

        }

    }

    private boolean isIn(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
