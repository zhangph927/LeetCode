package 回溯法.N皇后.q51_N皇后.f4;

import java.util.*;

/**
 * @ClassName : Solution
 * @Description :51. N皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: [
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
 * 解释: 4 皇后问题存在两个不同的解法。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步，可进可退。（引用自 百度百科 - 皇后 ）
 * @Author : zph
 * @Date: 2020-08-27 20:54
 * @Version : V1.0
 */
public class Solution {

    private List<List<String>> res;
    private int n;

    /**
     * @Title solveNQueens
     * @Description 回溯
     * 使用一个整数表示布尔数组记录状态，这个技巧叫做 状态压缩
     *
     * 使用整数（状态压缩的技巧）分别记录 「列状态」 、 「主对角线状态」 、 「副对角线状态」 。
     *
     * 说明：状态压缩的技巧只适用于「 原始 」布尔数组的长度不超过 32 位或者 64 位的时候，回溯搜索的问题一般复杂度都很高，输入数据不会很大。但具体用多少，是根据测试结果来的。
     *
     * @Author zph
     * @Date 2020/8/30 0:57
     * @Param [n]
     * @return java.util.List<java.util.List<java.lang.String>>
     */
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        int col = 0;
        int master = 0;
        int slave = 0;
        Stack<Integer> stack = new Stack<>();

        dfs(0, col, master, slave, stack);
        return res;
    }

    private void dfs(int row, int col, int master, int slave, Stack<Integer> stack) {
        if (row == n) {
            List<String> board = convert2board(stack, n);
            res.add(board);
            return;
        }

        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (((col >> i) & 1) == 0
                    && ((master >> (row + i)) & 1) == 0
                    && ((slave >> (row - i + n - 1)) & 1) == 0) {
                stack.add(i);
                col ^= (1 << i);
                master ^= (1 << (row + i));
                slave ^= (1 << (row - i + n - 1));

                dfs(row + 1, col, master, slave, stack);

                slave ^= (1 << (row - i + n - 1));
                master ^= (1 << (row + i));
                col ^= (1 << i);
                stack.pop();
            }
        }
    }

    private List<String> convert2board(Stack<Integer> stack, int n) {
        List<String> board = new ArrayList<>();
        for (Integer num : stack) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                stringBuilder.append(".");
            }
            stringBuilder.replace(num, num + 1, "Q");
            board.add(stringBuilder.toString());
        }
        return board;
    }



}
