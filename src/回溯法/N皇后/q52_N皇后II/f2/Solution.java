package 回溯法.N皇后.q52_N皇后II.f2;

import java.util.*;

/**
 * @ClassName : Solution
 * @Description :52. N皇后 II
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N-1 步，可进可退。（引用自 百度百科 - 皇后 ）
 * @Author : zph
 * @Date: 2020-08-30 17:48
 * @Version : V1.0
 */
public class Solution {


    int count = 0;
    private Set<Integer> col;
    private Set<Integer> master;
    private Set<Integer> slave;
    private int n;

    public int totalNQueens(int n) {
        if (n <= 0) {
            return count;
        }
        this.n = n;


        col = new HashSet<>();
        master = new HashSet<>();
        slave = new HashSet<>();
        dfs(0);

        return count;
    }


    private void dfs(int row) {
        if (row == n) {
            count++;
            return;
        }

        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !master.contains(row + i) && !slave.contains(row - i)) {
                col.add(i);
                master.add(row + i);
                slave.add(row - i);

                dfs(row + 1);

                slave.remove(row - i);
                master.remove(row + i);
                col.remove(i);
            }
        }
    }


}
