package 贪心.q767_重构字符串.f2;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName : Solution
 * @Description :767. 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * <p>
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 * <p>
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 * <p>
 * S 只包含小写字母并且长度在[1, 500]区间内。
 * @Author : zph
 * @Date: 2020-10-21 23:37
 * @Version : V1.0
 */
public class Solution {

    /**
     * @return java.lang.String
     * @Title reorganizeString
     * @Description 贪心堆
     * @Author zph
     * @Date 2020/10/21 23:40
     * @Param [S]
     */
    public String reorganizeString(String S) {
        int N = S.length();
        int[] count = new int[26];
        for (char c : S.toCharArray()) count[c - 'a']++;
        PriorityQueue<MultiChar> pq = new PriorityQueue<MultiChar>((a, b) ->
                a.count == b.count ? a.letter - b.letter : b.count - a.count);

        for (int i = 0; i < 26; ++i)
            if (count[i] > 0) {
                if (count[i] > (N + 1) / 2) return "";
                pq.add(new MultiChar(count[i], (char) ('a' + i)));
            }

        StringBuilder ans = new StringBuilder();
        while (pq.size() >= 2) {
            MultiChar mc1 = pq.poll();
            MultiChar mc2 = pq.poll();
            /*This code turns out to be superfluous, but explains what is happening
            if (ans.length() == 0 || mc1.letter != ans.charAt(ans.length() - 1)) {
                ans.append(mc1.letter);
                ans.append(mc2.letter);
            } else {
                ans.append(mc2.letter);
                ans.append(mc1.letter);
            }*/
            ans.append(mc1.letter);
            ans.append(mc2.letter);
            if (--mc1.count > 0) pq.add(mc1);
            if (--mc2.count > 0) pq.add(mc2);
        }

        if (pq.size() > 0) ans.append(pq.poll().letter);
        return ans.toString();
    }

    class MultiChar {
        int count;
        char letter;

        MultiChar(int ct, char ch) {
            count = ct;
            letter = ch;
        }


    }

}
