package 广度优先BFS.q127_单词接龙.f2;

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
     * @Description 双向广度优先遍历
     * @Author zph
     * @Date 2020/7/10 0:04
     * @Param [beginWord, endWord, wordList]
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        //总的访问集合
        Set<String> allVisit = new HashSet<>();
        //开始访问集合
        Set<String> beginVisit = new HashSet<>();
        //结束访问集合
        Set<String> endVisit = new HashSet<>();
        beginVisit.add(beginWord);
        endVisit.add(endWord);
        int step=1;
        int length=beginWord.length();
        while (!beginVisit.isEmpty()&&!endVisit.isEmpty()){
            //优先访问小集合
            if(beginVisit.size()>endVisit.size()){
               Set<String> temp= endVisit;
               endVisit=beginVisit;
               beginVisit=temp;
            }
            Set<String> nextVisit = new HashSet<>();
            for(String begin:beginVisit){
                char[] chars = begin.toCharArray();
                for(int i=0;i<length;i++){
                    char originChar=chars[i];
                    for(char k='a';k<='z';k++){
                        if(originChar==k){
                            continue;
                        }
                        chars[i]=k;
                        String newStr = String.valueOf(chars);
                        if(wordSet.contains(newStr)){
                            if(endVisit.contains(newStr)){
                                return  step+1;
                            }
                            if(!allVisit.contains(newStr)){
                                nextVisit.add(newStr);
                                allVisit.add(newStr);
                            }
                        }
                    }
                    chars[i]=originChar;
                }
            }
            step++;
            beginVisit=nextVisit;
        }
        return  0;




    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        Collections.addAll(wordList, words);

        Solution solution = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        int ladderLength = solution.ladderLength(beginWord, endWord, wordList);
        System.out.println(String.format("从 %s 到 %s 的最短转换序列的长度：%d。", beginWord, endWord, ladderLength));
    }


}
