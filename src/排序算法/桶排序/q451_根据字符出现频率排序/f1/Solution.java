package 排序算法.桶排序.q451_根据字符出现频率排序.f1;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName : Solution
 * @Description :451. 根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 *
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 *
 * 输入:
 * "cccaaa"
 *
 * 输出:
 * "cccaaa"
 *
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 *
 * 输入:
 * "Aabb"
 *
 * 输出:
 * "bbAa"
 *
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * @Author : zph
 * @Date: 2020-08-15 18:34
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title frequencySort
     * @Description 大顶推
     * @Author zph
     * @Date 2020/8/15 18:53
     * @Param [s]
     * @return java.lang.String
     */
    public String frequencySort(String s) {
        if(s==null||s.length()==0){
            return s;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for(char ch:chars){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        Queue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (e1,e2)->e2.getValue()-e1.getValue());
        pq.addAll(map.entrySet());
        StringBuffer buffer = new StringBuffer();
        while (!pq.isEmpty()){
            Map.Entry<Character, Integer> entry = pq.poll();
            Character key = entry.getKey();
            Integer value = entry.getValue();
            for(int i=0;i<value;i++){
                buffer.append(key);
            }
        }
        return buffer.toString();


    }
}
