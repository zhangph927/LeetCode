package 回溯法.q488_祖玛游戏;

import javax.naming.ldap.PagedResultsControl;

/**
 * @ClassName : Solution
 * @Description :488. 祖玛游戏
 * 回忆一下祖玛游戏。现在桌上有一串球，颜色有红色(R)，黄色(Y)，蓝色(B)，绿色(G)，还有白色(W)。 现在你手里也有几个球。
 * <p>
 * 每一次，你可以从手里的球选一个，然后把这个球插入到一串球中的某个位置上（包括最左端，最右端）。接着，如果有出现三个或者三个以上颜色相同的球相连的话，就把它们移除掉。重复这一步骤直到桌上所有的球都被移除。
 * <p>
 * 找到插入并可以移除掉桌上所有球所需的最少的球数。如果不能移除桌上所有的球，输出 -1 。
 * <p>
 * 示例:
 * 输入: "WRRBBW", "RB"
 * 输出: -1
 * 解释: WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW （翻译者标注：手上球已经用完，桌上还剩两个球无法消除，返回-1）
 * <p>
 * 输入: "WWRRBBWW", "WRBRW"
 * 输出: 2
 * 解释: WWRRBBWW -> WWRR[R]BBWW -> WWBBWW -> WWBB[B]WW -> WWWW -> empty
 * <p>
 * 输入:"G", "GGGGG"
 * 输出: 2
 * 解释: G -> G[G] -> GG[G] -> empty
 * <p>
 * 输入: "RBYYBBRRB", "YRBGB"
 * 输出: 3
 * 解释: RBYYBBRRB -> RBYY[Y]BBRRB -> RBBBRRB -> RRRB -> B -> B[B] -> BB[B] -> empty
 * 标注:
 * <p>
 * 你可以假设桌上一开始的球中，不会有三个及三个以上颜色相同且连着的球。
 * 桌上的球不会超过20个，输入的数据中代表这些球的字符串的名字是 "board" 。
 * 你手中的球不会超过5个，输入的数据中代表这些球的字符串的名字是 "hand"。
 * 输入的两个字符串均为非空字符串，且只包含字符 'R','Y','B','G','W'。
 * @Author : zph
 * @Date: 2020-10-07 22:26
 * @Version : V1.0
 */
public class Solution {

    private int result = Integer.MAX_VALUE;
    private int[] map = new int[26];
    private char[] colors = {'R', 'Y', 'B', 'G', 'W'};

    /**
     * @return int
     * @Title findMinStep
     * @Description 回溯
     * @Author zph
     * @Date 2020/10/7 22:28
     * @Param [board, hand]
     */
    public int findMinStep(String board, String hand) {
        char[] chars = hand.toCharArray();
        for (char c : chars) {
            map[c - 'A']++;
        }
        dfs(new StringBuilder(board), 0);

        return result == Integer.MAX_VALUE ? -1 : result;


    }

    private void dfs(StringBuilder board, int step) {
        if (step >= result) {
            return;
        }
        if (board.length() == 0) {
            result = Math.min(step, result);
            return;
        }
        int length = board.length();
        for (int i = 0; i < length; i++) {
            char c = board.charAt(i);

            int j = i;
            while (j + 1 < length && board.charAt(j + 1) == c) {
                j++;
            }
            //只有单个球
            if (j == i && map[c - 'A'] >= 2) {
                StringBuilder temp = new StringBuilder(board);
                temp.insert(i, c + "" + c);
                map[c - 'A'] -= 2;
                dfs(eliminate(temp), step + 2);
                map[c - 'A'] += 2;
            } else if (j == i + 1) {
                //存在两个颜色相同且相邻的球
                if (map[c - 'A'] >= 1) {
                    StringBuilder temp = new StringBuilder(board);
                    temp.insert(i, c);
                    map[c - 'A']--;
                    dfs(eliminate(temp), step + 1);
                    map[c - 'A']++;
                }

                for (char color : colors) {
                    if (color == c) {
                        continue;
                    }
                    if (map[color - 'A'] >= 1) {
                        //尝试往这两个颜色相同且相邻的球中间插入一个颜色不同的球
                        StringBuilder temp = new StringBuilder(board);
                        temp.insert(i + 1, color);
                        map[color - 'A']--;
                        dfs(eliminate(temp), step + 1);
                        map[color - 'A']++;

                    }

                }

            }


        }


    }

    private StringBuilder eliminate(StringBuilder sb) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < sb.length(); i++) {
                int j = i + 1;
                while (j < sb.length() && sb.charAt(j) == sb.charAt(i)) {
                    j++;
                }
                if (j - i >= 3) {
                    sb.delete(i, j);
                    flag = true;
                }
            }
        }
        return sb;
    }


}
