package 广度优先BFS.单词接龙;


import java.util.*;

/**
 * @ClassName : Solution
 * @Description :
 * @Author : zph
 * @Date: 2020-11-07 22:36
 * @Version : V1.0
 */
public class Solution {


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);

        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visit = new HashSet<>();
        queue.offer(beginWord);
        visit.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                char[] chars = poll.toCharArray();
                int length = chars.length;
                for (int j = 0; j < length; j++) {
                    char originChar = chars[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[j] = ch;
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


}
