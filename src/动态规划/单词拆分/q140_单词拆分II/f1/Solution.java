package 动态规划.单词拆分.q140_单词拆分II.f1;

import java.util.*;

/**
 * @ClassName : Solution
 * @Description :140. 单词拆分 II
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 *
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * @Author : zph
 * @Date: 2020-10-12 00:18
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title wordBreak
     * @Description “动态规划 + 回溯”求解具体值
     * @Author zph
     * @Date 2020/10/12 0:24
     * @Param [s, wordDict]
     * @return java.util.List<java.lang.String>
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        // 状态定义：以 s[i] 结尾的子字符串是否符合题意
        boolean[] dp = new boolean[len];

        // 预处理
        Set<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }

        // 动态规划问题一般都有起点，起点也相对好判断一些
        // dp[0] = wordSet.contains(s.charAt(0));
        for (int r = 0; r < len; r++) {
            if (wordSet.contains(s.substring(0, r + 1))) {
                dp[r] = true;
                continue;
            }
            for (int l = 0; l < r; l++) {
                // dp[l] 写在前面会更快一点，否则还要去切片，然后再放入 hash 表判重
                if (dp[l] && wordSet.contains(s.substring(l + 1, r + 1)) ) {
                    dp[r] = true;
                    // 这个 break 很重要，一旦得到 dp[r] = True ，循环不必再继续
                    break;
                }
            }
        }

        List<String> res = new ArrayList<>();
        if (dp[len - 1]) {
            LinkedList<String> queue = new LinkedList<>();
            dfs(s, len - 1, wordSet, res, queue, dp);
            return res;
        }

        return res;
    }

    private void dfs(String s, int end, Set<String> wordSet, List<String> res, LinkedList<String> queue, boolean[] dp) {
        if (wordSet.contains(s.substring(0, end + 1))) {
            queue.addFirst(s.substring(0, end + 1));

            StringBuilder stringBuilder = new StringBuilder();
            for (String word : queue) {
                stringBuilder.append(word);
                stringBuilder.append(" ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            res.add(stringBuilder.toString());

            queue.removeFirst();
        }

        for (int i = 0; i < end; i++) {

            if (dp[i]) {
                String suffix = s.substring(i + 1, end + 1);

                if (wordSet.contains(suffix)) {
                    queue.addFirst(suffix);
                    dfs(s, i, wordSet, res, queue, dp);
                    queue.removeFirst();
                }
            }

        }
    }


    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("applepen");
        wordDict.add("pine");
        wordDict.add("pineapple");
        Solution solution = new Solution();
        List<String> res = solution.wordBreak(s, wordDict);
        System.out.println(res);
    }

}
