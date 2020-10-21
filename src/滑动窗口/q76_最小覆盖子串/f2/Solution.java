package 滑动窗口.q76_最小覆盖子串.f2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName : Solution
 * @Description :76. 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * @Author : zph
 * @Date: 2020-08-02 00:53
 * @Version : V1.0
 */
public class Solution {
    Map<Character, Integer> need = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();

    /**
     * @Title minWindow
     * @Description 滑动窗口
     * @Author zph
     * @Date 2020/8/2 0:54
     * @Param [s, t]
     * @return java.lang.String
     */
    public String minWindow(String s, String t) {
        char[] tChars = t.toCharArray();
        for (char c : tChars){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        char[] sChars = s.toCharArray();
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = sChars[right];
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = sChars[left];
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ?
                "" : s.substring(start, start+len);
    }



}
