package 字典树.q面试题17_13恢复空格.f2;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :面试题 17.13. 恢复空格
 * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 * <p>
 * 注意：本题相对原题稍作改动，只需返回未识别的字符数
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 * 提示：
 * <p>
 * 0 <= len(sentence) <= 1000
 * dictionary中总字符数不超过 150000。
 * 你可以认为dictionary和sentence中只包含小写字母。
 * @Author : zph
 * @Date: 2020-07-09 20:33
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title respace
     * @Description 动态规划+前缀树
     * @Author zph
     * @Date 2020/7/9 21:49
     * @Param [dictionary, sentence]
     * @return int
     */
    public int respace(String[] dictionary, String sentence) {
        Trie trie = new Trie();
        for(String str:dictionary){
            trie.insert(str);
        }
        int length=sentence.length();
        int[] dp=new int[length+1];
        for(int i=1;i<=length;i++){
            dp[i]=dp[i-1]+1;
            List<Integer> search = trie.search(sentence, i - 1);
            for(int idx:search){
                dp[i]=Math.min(dp[i],dp[idx]);
            }
        }
        return dp[length];

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] dictionary ={"looked","just","like","her","brother"};
        String sentence = "jesslookedjustliketimherbrother";

        int respace = solution.respace(dictionary, sentence);
        System.out.println(respace);


    }
}




