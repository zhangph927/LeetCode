package 回溯法.N皇后.q51_N皇后.f1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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


    private static List<String> charToString(char[][] array) {
        List<String> result = new LinkedList<>();
        for (char[] chars : array) {
            result.add(String.valueOf(chars));
        }
        return result;
    }


    List<List<String>> res;

    /**
     * @Title solveNQueens
     * @Description 回溯
     * @Author zph
     * @Date 2020/8/30 0:50
     * @Param [n]
     * @return java.util.List<java.util.List<java.lang.String>>
     */
    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) return null;
        res = new LinkedList<>();
        char[][] board = new char[n][n];
        for (char[] chars : board) Arrays.fill(chars, '.');
        backtrack(board, 0);
        return res;
    }

    /**
     * 路径：board中小于row的那些行都已经成功放置了皇后
     * 可选择列表: 第row行的所有列都是放置Q的选择
     * 结束条件: row超过board的最后一行
     *
     * @param board
     * @param row
     */
    private void backtrack(char[][] board, int row) {
        if (row == board.length) {
            res.add(charToString(board));
            return;
        }
        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) continue;
            board[row][col] = 'Q';
            backtrack(board, row + 1);
            board[row][col] = '.';
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        int rows = board.length;
        // check is valid in col
        for (char[] chars : board) if (chars[col] == 'Q') return false;
        // check is valide upright
        for (int i = row - 1, j = col + 1; i >= 0 && j < rows; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        // check is valide upleft
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }


}
