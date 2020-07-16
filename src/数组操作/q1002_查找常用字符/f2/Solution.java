package 数组操作.q1002_查找常用字符.f2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
     * @return java.util.List<java.lang.String>
     * @Title commonChars
     * @Description 根据数据特性，26位字母，构造哈希数组
     * @Author zph
     * @Date 2020/7/14 15:42
     * @Param [A]
     */
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        //特判
        if (A == null || A.length == 0) {
            return res;
        }
        int length = A.length;
        int[] hash = new int[26];
        int[] temp = new int[26];
        //初始化
        for (int i = 0; i < 26; i++) {
            hash[i] = 100;
        }
        for (int i = 0; i < length; i++) {
            char[] chars = A[i].toCharArray();
            int len = chars.length;
            for (int j = 0; j < len; j++) {
                temp[chars[j] - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                int tempNum = temp[j];
                int hashNum = hash[j];
                hash[j] = Math.min(tempNum, hashNum);
                temp[j] = 0;
            }
        }
        for (int i = 0; i < 26; i++) {
            while (hash[i] > 0) {
                res.add(String.valueOf((char) (i + 'a')));
                hash[i]--;
            }
        }
        return res;


    }

    public static void main(String[] args) {
        String[] str = {"bella", "label", "roller"};
        Solution solution = new Solution();
        List<String> strings = solution.commonChars(str);
        System.out.println(strings);

    }
}
