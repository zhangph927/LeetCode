package 动态规划.单词拆分.q140_单词拆分II.f2;

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
     * @Description 记忆化回溯
     * @Author zph
     * @Date 2020/10/12 0:25
     * @Param [s, wordDict]
     * @return java.util.List<java.lang.String>
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        List<List<String>> lists = word_Break(s, wordDictSet, 0);
        List<String> rest = new ArrayList<>();
        for(List<String> list:lists){
            rest.add(String.join(" ",list));
        }
        return rest;

    }
    HashMap<Integer, List<List<String>>> map = new HashMap<>();

    public List<List<String>> word_Break(String s, Set<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        List<List<String>> res = new LinkedList<>();
        if (start == s.length()) {
            res.add(new ArrayList<>());
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<List<String>> list = word_Break(s, wordDict, end);
                for (List<String> l : list) {
                    LinkedList<String> copyList = new LinkedList<>(l);
                    copyList.addFirst(s.substring(start, end));
                    res.add(copyList);
                }
            }
        }
        map.put(start, res);
        return res;
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
