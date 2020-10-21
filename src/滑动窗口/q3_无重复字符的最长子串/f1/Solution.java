package 滑动窗口.q3_无重复字符的最长子串.f1;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : Solution
 * @Description :3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @Author : zph
 * @Date: 2020-07-04 14:24
 * @Version : V1.0
 */
public class Solution {
    Map<Character, Integer> window = new HashMap<>();

    /**
     * @return int
     * @Title lengthOfLongestSubstring
     * @Description 滑动窗口
     * @Author zph
     * @Date 2020/10/19 22:16
     * @Param [s]
     */
    public int lengthOfLongestSubstring(String s) {

        int left = 0, right = 0;
        int res = 0;
        char[] sChars = s.toCharArray();
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = sChars[right];
            // 右移窗口
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 判断左侧窗口是否要收缩
            while (window.get(c) > 1) {
                // d 是将移出窗口的字符
                char d = sChars[left];
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                window.put(d, window.getOrDefault(d, 0) - 1);
            }

            res = Math.max(res, right - left);
        }
        return res;

    }
}
