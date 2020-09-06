package 回溯法.分割回文串.q131_分割回文串.f2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :131. 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * @Author : zph
 * @Date: 2020-09-03 18:05
 * @Version : V1.0
 */
public class Solution {

    /**
     * @return java.util.List<java.util.List < java.lang.String>>
     * @Title partition
     * @Description 回溯+动态规划
     * @Author zph
     * @Date 2020/9/5 19:09
     * @Param [s]
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        Deque<String> path = new ArrayDeque<>();
        int length = s.length();
        //动态规划 空间换时间
        boolean[][] dp = new boolean[length][length];
        //初始化
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();

        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    //不构成区间 j-1-(i+1)+1<2
                    //j-i<3
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

            }
        }

        backTracking(s, length, 0, dp, path, res);
        return res;

    }

    /**
     * @return void
     * @Title backTracking
     * @Description TODO
     * @Author zph
     * @Date 2020/9/5 19:11
     * @Param [s, length 长度, start 开始位置, path 路径, res 结果]
     */
    private void backTracking(String s, int length, int start,
                              boolean[][] dp,
                              Deque<String> path, List<List<String>> res) {

        if (start == length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < length; i++) {
            //判断
            if (!dp[start][i]) {
                continue;
            }

            path.addLast(s.substring(start, i + 1));
            backTracking(s, length, i + 1, dp, path, res);

            path.removeLast();


        }


    }


}
