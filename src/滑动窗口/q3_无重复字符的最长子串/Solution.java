package 滑动窗口.q3_无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : Solution
 * @Description :3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @Author : zph
 * @Date: 2020-07-04 14:24
 * @Version : V1.0
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int length=chars.length;
        Map<Character, Integer> map = new HashMap<>();
        int maxLen=0;
        int start=0;

        for(int i=0;i<length;i++){
            char aChar = chars[i];
            if(map.containsKey(aChar)){
                //保证下一位从新开始
                start=Math.max(start,map.get(aChar)+1);
            }

            map.put(aChar,i);

            maxLen=Math.max(maxLen,i-start+1);
        }
        return  maxLen;


    }
}
