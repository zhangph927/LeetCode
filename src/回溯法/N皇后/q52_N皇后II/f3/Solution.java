package 回溯法.N皇后.q52_N皇后II.f3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    private int n;

    int count = 0;

    public int totalNQueens(int n) {
        if (n <= 0) {
            return count;
        }
        this.n = n;
        int col = 0;
        int master = 0;
        int slave = 0;

        dfs(0, col, master, slave);

        return count;
    }


    private void dfs(int row, int col, int master, int slave) {
        if (row == n) {
            count++;
            return;
        }

        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (((col >> i) & 1) == 0
                    && ((master >> (row + i)) & 1) == 0
                    && ((slave >> (row - i + n - 1)) & 1) == 0) {
                col ^= (1 << i);
                master ^= (1 << (row + i));
                slave ^= (1 << (row - i + n - 1));

                dfs(row + 1, col, master, slave);

                slave ^= (1 << (row - i + n - 1));
                master ^= (1 << (row + i));
                col ^= (1 << i);
            }
        }
    }


}
