package 回溯法.N皇后.q51_N皇后.f3;

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

    private boolean[] col;
    private boolean[] master;
    private boolean[] slave;
    private int n;
    private List<List<String>> res;

    /**
     * @Title solveNQueens
     * @Description 回溯
     * 使用 布尔数组 记录状态
     *
     * 使用布尔数组分别记录 「列状态」 、 「主对角线状态」 、 「副对角线状态」
     * @Author zph
     * @Date 2020/8/30 0:55
     * @Param [n]
     * @return java.util.List<java.util.List<java.lang.String>>
     */
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        if (n == 0) {
            return res;
        }


        col = new boolean[n];
        master = new boolean[2 * n - 1];
        slave = new boolean[2 * n - 1];
        Stack<Integer> stack = new Stack<>();

        dfs(0, stack);
        return res;
    }

    private void dfs(int row, Stack<Integer> stack) {
        if (row == n) {
            List<String> board = convert2board(stack, n);
            res.add(board);
            return;
        }

        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            //row - i + n - 1落到数组范围内
            if (!col[i] && !master[row + i] && !slave[row - i + n - 1]) {
                stack.add(i);
                col[i] = true;
                master[row + i] = true;
                slave[row - i + n - 1] = true;

                dfs(row + 1, stack);

                slave[row - i + n - 1] = false;
                master[row + i] = false;
                col[i] = false;
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
