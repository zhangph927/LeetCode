package 滑动窗口.q567_字符串的排列.f1;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : Solution
 * @Description :567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * <p>
 * 示例2:
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * <p>
 * <p>
 * 注意：
 * <p>
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 * @Author : zph
 * @Date: 2020-10-19 12:30
 * @Version : V1.0
 */
public class Solution {

    Map<Character, Integer> need = new HashMap<Character, Integer>();
    Map<Character, Integer> window = new HashMap<Character, Integer>();

    /**
     * @return boolean
     * @Title checkInclusion
     * @Description 滑动窗口
     * @Author zph
     * @Date 2020/10/19 21:43
     * @Param [s1, s2]
     */
    public boolean checkInclusion(String s1, String s2) {

        char[] tChars = s1.toCharArray();
        for (char c : tChars) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        char[] sChars = s2.toCharArray();
        while (right < s2.length()) {
            // c 是将移入窗口的字符
            char c = sChars[right];
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                // 在这里判断是否找到了合法的子串
                char d = sChars[left];
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return false;

    }
}
