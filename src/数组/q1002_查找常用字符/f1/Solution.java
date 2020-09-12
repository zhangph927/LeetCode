package 数组.q1002_查找常用字符.f1;

import java.util.*;

/**
 * @ClassName : Solution
 * @Description :1002. 查找常用字符
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * <p>
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 * @Author : zph
 * @Date: 2020-07-14 00:45
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title commonChars
     * @Description 哈希表
     * @Author zph
     * @Date 2020/7/14 13:59
     * @Param [A]
     * @return java.util.List<java.lang.String>
     */
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        if (A == null || A.length == 0) {
            return res;
        }
        int length = A.length;
        char[] chars = A[0].toCharArray();
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }


        for (int i = 1; i < length; i++) {
            char[] charsArr = A[i].toCharArray();
            Map<Character, Integer> temp = new HashMap<>();
            for (char ch : charsArr) {
                temp.put(ch, temp.getOrDefault(ch, 0) + 1);
            }
            intersecton(map, temp);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            for (int i = value; i > 0; i--) {
                res.add(String.valueOf(key));
            }
        }
        return res;
    }

    private void intersecton(Map<Character, Integer> map, Map<Character, Integer> temp) {
        map.keySet().retainAll(temp.keySet());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            Integer tempValue = temp.get(key);
            map.put(key, Math.min(value, tempValue));
        }
    }


    public static void main(String[] args) {
        String[] str = {"bella", "label", "roller"};
        Solution solution = new Solution();
        List<String> strings = solution.commonChars(str);
        System.out.println(strings);

    }
}
