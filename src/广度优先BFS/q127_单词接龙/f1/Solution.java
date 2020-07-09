package 广度优先BFS.q127_单词接龙.f1;

import java.util.*;

/**
 * @ClassName : Solution
 * @Description :127. 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
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
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: 0
 * <p>
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * @Author : zph
 * @Date: 2020-07-08 22:53
 * @Version : V1.0
 */
public class Solution {


    /**
     * @return int
     * @Title ladderLength
     * @Description 广度优先遍历
     * @Author zph
     * @Date 2020/7/10 0:04
     * @Param [beginWord, endWord, wordList]
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visit = new HashSet<>();
        queue.offer(beginWord);
        visit.add(beginWord);
        //开始位置算第一步
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                char[] chars = poll.toCharArray();
                int length = chars.length;
                for (int j = 0; j < length; j++) {
                    char originChar = chars[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        chars[j] = k;
                        String newStr = String.valueOf(chars);
                        if (wordSet.contains(newStr)) {
                            if (newStr.equals(endWord)) {
                                return step + 1;
                            }
                            if (!visit.contains(newStr)) {
                                queue.offer(newStr);
                                visit.add(newStr);
                            }
                        }
                        chars[j] = originChar;
                    }
                }


            }
            step++;
        }
        return 0;

    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        String[] wordListArray = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        Collections.addAll(wordList, wordListArray);
        Solution solution = new Solution();
        int res = solution.ladderLength(beginWord, endWord, wordList);
        System.out.println(res);
    }

}
