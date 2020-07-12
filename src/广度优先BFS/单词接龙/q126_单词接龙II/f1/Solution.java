package 广度优先BFS.单词接龙.q126_单词接龙II.f1;

import com.sun.org.apache.xalan.internal.res.XSLTErrorResources;

import java.util.*;

/**
 * @ClassName : Solution
 * @Description :126. 单词接龙 II
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换后得到的单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出:
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: []
 * <p>
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 * @Author : zph
 * @Date: 2020-07-12 15:11
 * @Version : V1.0
 */
public class Solution {


    /**
     * @return java.util.List<java.util.List < java.lang.String>>
     * @Title findLadders
     * @Description 广度优先遍历
     * @Author zph
     * @Date 2020/7/12 15:28
     * @Param [beginWord, endWord, wordList]
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return res;
        }

        // 第 1 步：使用广度优先遍历得到后继结点列表 successors
        // key：字符串，value：广度优先遍历过程中 key 的后继结点列表
        Map<String, Set<String>> successors = new HashMap<>();
        boolean found = bidirectionalBfs(beginWord, endWord, wordSet, successors);
        if (!found) {
            return res;
        }
        // 第 2 步：基于后继结点列表 successors ，使用回溯算法得到所有最短路径列表
        //使用栈结构
        Deque<String> path = new ArrayDeque<>();
        path.addLast(beginWord);
        dfs(beginWord, endWord, successors, path, res);
        return res;


    }

    private void dfs(String beginWord, String endWord,
                     Map<String, Set<String>> successors,
                     Deque<String> path, List<List<String>> res) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
        }
        if (!successors.containsKey(beginWord)) {
            return;
        }
        Set<String> successWords = successors.get(beginWord);
        for (String word : successWords) {
            path.addLast(word);
            dfs(word, endWord, successors, path, res);
            path.removeLast();
        }
    }


    /**
     * @return boolean
     * @Title bfs
     * @Description 单词列表、起点、终点构成无向图 构建后继结点列表
     * @Author zph
     * @Date 2020/7/12 16:07
     * @Param [beginWord, endWord, wordSet, successors]
     */
    private boolean bidirectionalBfs(String beginWord, String endWord, Set<String> wordSet, Map<String, Set<String>> successors) {
        //总的访问集合
        Set<String> allVisit = new HashSet<>();
        allVisit.add(beginWord);
        allVisit.add(endWord);
        //开始访问集合
        Set<String> beginVisit = new HashSet<>();
        //结束访问集合
        Set<String> endVisit = new HashSet<>();
        beginVisit.add(beginWord);
        endVisit.add(endWord);
        int length = beginWord.length();

        int wordLength = beginWord.length();
        //找到终点标识
        boolean found = false;
        //交换标识
        boolean forward = true;
        while (!beginVisit.isEmpty() && !endVisit.isEmpty()) {
            //优先访问小集合
            if (beginVisit.size() > endVisit.size()) {
                Set<String> temp = endVisit;
                endVisit = beginVisit;
                beginVisit = temp;
                forward = !forward;
            }
            Set<String> nextLevelVisit = new HashSet<>();
            for (String begin : beginVisit) {
                char[] currentWordChar = Objects.requireNonNull(begin).toCharArray();
                for (int j = 0; j < wordLength; j++) {
                    char originChar = currentWordChar[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (originChar == ch) {
                            continue;
                        }
                        currentWordChar[j] = ch;
                        String newStr = new String(currentWordChar);
                        if (wordSet.contains(newStr)) {
                            if (endVisit.contains(newStr)) {
                                found = true;
                                addToSuccess(begin, newStr, forward, successors);
                            }

                            if (!allVisit.contains(newStr)) {
                                nextLevelVisit.add(newStr);
                                addToSuccess(begin, newStr, forward, successors);
                            }
                        }
                    }
                    currentWordChar[j] = originChar;
                }
            }
            beginVisit = nextLevelVisit;
            allVisit.addAll(nextLevelVisit);
            if (found) {
                break;
            }
        }
        return found;

    }

    private void addToSuccess(String beginWord, String endWord, boolean forward, Map<String, Set<String>> successors) {
        if (!forward) {
            String temp = endWord;
            endWord = beginWord;
            beginWord = temp;
        }
        successors.computeIfAbsent(beginWord, a -> new HashSet<>());
        successors.get(beginWord).add(endWord);


    }


    public static void main(String[] args) {
        String[] words = {"rex", "ted", "tex", "tad", "tax"};
        List<String> wordList = new ArrayList<>();
        Collections.addAll(wordList, words);

        Solution solution = new Solution();
        String beginWord = "red";
        String endWord = "tax";
        List<List<String>> res = solution.findLadders(beginWord, endWord, wordList);
        System.out.println(res);
    }


}
