package 贪心.q358_K距离间隔重排字符串;

import java.util.*;

/**
 * @ClassName : Solution
 * @Description :题目描述
 * 给你一个非空的字符串 s 和一个整数 k，你要将这个字符串中的字母进行重新排列，使得重排后的字符串中相同字母的位置间隔距离至少为 k。
 *
 * 所有输入的字符串都由小写字母组成，如果找不到距离至少为 k 的重排结果，请返回一个空字符串 “”。
 *
 * 示例 1：
 *
 * 输入: s = “aabbcc”, k = 3
 * 输出: “abcabc”
 * 解释: 相同的字母在新的字符串中间隔至少 3 个单位距离。
 *
 * 示例 2:
 *
 * 输入: s = “aaabc”, k = 3
 * 输出: “”
 * 解释: 没有办法找到可能的重排结果。
 *
 * 示例 3:
 *
 * 输入: s = “aaadbbcc”, k = 2
 * 输出: “abacabcd”
 * 解释: 相同的字母在新的字符串中间隔至少 2 个单位距离。
 *
 * 解题思路
 * 贪心法，每次尽量取频次大的字母加入结果
 * 1.统计每个字母出现的次数，存入map
 * 2.把所有的字母按照频次排序存入队列
 * 3.每次从队列中取k个最大频次的字母，加入结果字符串。
 * 4.然后相应频次减一后再放回队列。每次字符串长度要减掉K。最后一次不够K个，就取最后一次遍历的字符串的长度的字母加入结果字符串。
 * @Author : zph
 * @Date: 2020-10-21 23:56
 * @Version : V1.0
 */
public class Solution {
    public String rearrangeString(String str, int k) {
        if (k == 0) {
            return str;
        }
        // 1.构建单词与频率的映射
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        // 2.将所有出现的字母按照频率排序
        PriorityQueue<Character> queue = new PriorityQueue<>((c1, c2) -> {
            if (map.get(c2).intValue() != map.get(c1).intValue()) {
                return map.get(c2) - map.get(c1);
            } else {
                // 如果频率相同，按字典排序
                return c1.compareTo(c2);
            }
        });
        // 把字符放入队列,频率大的在前面
        for (char c : map.keySet()) {
            queue.offer(c);
        }
        // 试图构建字符串
        StringBuilder sb = new StringBuilder();
        // 初始字符长度
        int len = str.length();
        // 3. 把字符按出现次数多的字符开始，把每一个字符插入到间隔中
        while (!queue.isEmpty()) {
            List<Character> tempChars = new ArrayList<>();
            // 得到较小的数（最后剩下的一截可能不够K）
            int n = Math.min(k, len);
            // 从queue里取出TopN位数字，填充每一个间隔区间
            for (int i = 0; i < n; i++) {
                // 在个数为N的间隔区间里，剩下的不重复的字符串已经用完了,那么必然构造不出间隔为N的无重复字符串了，
                // 也就是在这个区间里必然有重复的字母，到这里就无法再继续构造了
                if (queue.isEmpty()) {
                    return "";
                }
                // 取出这个字符
                char ch = queue.poll();
                sb.append(ch);
                // 取出这个字符，相应频次要减1
                map.put(ch, map.get(ch) - 1);
                // 这个字符还有剩余,就加进来tempChars，重新放到queue里，进行下一次的遍历
                if (map.get(ch) > 0) {
                    tempChars.add(ch);
                }
                // 已经取过了，字符长度减1
                len--;
            }

            // 4.每个字母减过一次了，把还有剩余次数的字母再次加入到queue里，继续下一次的循环
            for (Character tempChar : tempChars) {
                queue.offer(tempChar);
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.rearrangeString("aabbcc", 3);
        String res2 = solution.rearrangeString("aaabc", 3);
        String res3 = solution.rearrangeString("aaadbbcc", 2);
        System.out.println(res);
        System.out.println(res2);
        System.out.println(res3);
    }


}
