package 字符串操作.q49_字母异位词分组.f2;

import java.util.*;

/**
 * @ClassName : Solution
 * @Description :49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * @Author : zph
 * @Date: 2020-08-16 18:55
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title groupAnagrams
     * @Description 按计数分类
     * @Author zph
     * @Date 2020/8/16 21:17
     * @Param [strs]
     * @return java.util.List<java.util.List<java.lang.String>>
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null||strs.length==0){
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
      int[] count=  new int[26];
        for(String str:strs){
            Arrays.fill(count,0);
            char[] chars = str.toCharArray();
            for(char ch:chars){
                count[ch-'a']++;

            }
            StringBuffer buffer = new StringBuffer("");

            for(int i=0;i<26;i++){
                buffer.append("#");
                buffer.append(count[i]);
            }
            String key = buffer.toString();

            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());


    }
}
