package 回溯法.q37_解数独;

import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @ClassName : Solution
 * @Description :37. 解数独
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * <p>
 * <p>
 * <p>
 * 一个数独。
 * <p>
 * <p>
 * <p>
 * 答案被标成红色。
 * <p>
 * Note:
 * <p>
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 * @Author : zph
 * @Date: 2020-09-07 00:01
 * @Version : V1.0
 */
public class Solution {
    /**
     * 回溯
     * 回溯解法：https://leetcode-cn.com/problems/sudoku-solver/solution/zi-cong-wo-xue-hui-liao-hui-su-suan-fa-zhong-yu-hu/
     * 逐行，从左到右，在每一个位置上试探1-9，成功就进入下一个位置，失败就取消本次选择，做下一个选择
     * 当前行试探完毕就换行，知道换到最后一行
     *
     * @param board
     */
    public void solveSudoku(char[][] board) {
        // 非法数独
        if (board == null || board.length != 9 || board[0] == null || board[0].length != 9)
            return;
        // 回溯法解决
        backTrace(board, 0, 0);
    }

    private boolean backTrace(char[][] board, int row, int col){
        int n = board.length; // 9
        // 当前行已全部试探过，换到下一行第一个位置
        if (col == 9)
            return backTrace(board, row + 1, 0);
        // 满足结束条件，全部行全部位置都已试探过
        if (row == n)
            // 最后一行最后一个位置[8][8]试探过后会试探[8][9]，会执行[9][0]，返回
            return true;
        // 这个位置数字已给出，不需要试探，直接试探下一个位置
        if (board[row][col] != '.')
            return backTrace(board, row, col + 1);
        // 遍历可选择列表(各选择之间并列)
        for (char c = '1'; c <= '9'; c++){
            // 排除不合法的选择
            if (!isValid(board, row, col, c))
                continue;
            // 做选择
            board[row][col] = c;
            // 进行下一步试探，发现当前选择能成功进行下去，就继续往下
            if (backTrace(board, row, col + 1))
                return true;
            // 撤销本次选择，并列进行下一次选择的试探
            board[row][col] = '.';
        }
        // 这个位置把1-9都试过了，都无法继续下去，说明上一次的选择失败，需要回溯
        return false;
    }

    /**
     * 判断 board[row][col]位置放入字符 ch,是否合理
     * 也就判断这个字符有没有在 同一行，同一列，同一个子数独中出现过
     * 行列比较容易，就是一个for循环
     * 而对于 给定的 board[i][j]，它所在的子数独的索引是 (i / 3) * 3 + j / 3
     * 要扫描这个子数独中的全部9个元素，for循环可以这样写
     * boardIndex = (i / 3) * 3 + j / 3
     * for(int k = 0; k < 9; k++){
     * board[(i/3)*3 + k/3][(j/3)*3 + k % 3]
     * }
     * 因为 i和j是确定的，所以 i / 3 * 3可以确定他所在的子数独在第一个三行，还是第二个三行，还是第三个三行
     * j / 3 * 3可以确定它所在的子数独是前三列还是中散列还是后三列，
     * 相当于这两个只是确定了这个【子数独的左上角坐标】，而需要借助 k 完全对这个9个位置的扫描
     *
     * 这里作者大佬的思路很赞，学习了。
     * 对于行列为(r, c)的数而言，(r/3, c/3)是它对应的 3 × 3 方框所在的位置，
     * 例如第4行第5个数(4, 5)所在的 3 × 3 方框是(1, 1)，
     * 也就是第1行第1列的方框，即中间那个（下标全都从0开始）。
     * 这两个数再×3，得到的是该方框最左上角的数的坐标(r/3)*3, (c/3)*3。
     * 最后一步是遍历这个方框内的9个格子，
     * 因为前面我们已经得到这个方框左上角元素的下标了，
     * 只需要在它的基础上分别在行和列上加上增量0, 1, 2就可以了。
     * 但是因为前面检查行和列的时候我们只用了一个变量i在循环，
     * 这里如果要分别遍历行和列的话，需要单独写一个两层循环出来。
     * 用i/3和i%3可以用一个变量控制行和列的增量，当i取值从0到8变化时，
     * (i/3, i%3)分别会是(0, 0), (0, 1), ..., (2, 1), (2, 2)，
     * 也可以理解成是将一个1×9的一维数组变形成了3×3的二维数组，
     * 实现对小方框内数字的遍历。建议代入一些r、c的值，
     * 然后把i从0到8对应写出来，会比较直观一些。
     * 不知道我的解释是否清晰，希望能有所帮助~
     *
     * @param board
     * @param row
     * @param col
     * @param ch
     * @return
     */
    private boolean isValid(char[][] board, int row, int col, char ch) {
        // 三个方向，任一方向重复，ch就不能放在这个位置
        for (int k = 0; k < 9; k++) {
            // 同一行九个位置已出现 ch
            if (board[row][k] == ch) return false;
            // 同一列九个位置中已出现 ch
            if (board[k][col] == ch) return false;
            // 同一个子数独九个位置中已出现 ch
            if (board[(row / 3) * 3 + k / 3][(col / 3) * 3 + k % 3] == ch) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board= {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        solution.solveSudoku(board);

    }

}
