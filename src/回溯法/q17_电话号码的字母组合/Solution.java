package 回溯法.q17_电话号码的字母组合;

import java.util.*;

/**
 * @ClassName : Solution
 * @Description :17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * @Author : zph
 * @Date: 2020-07-26 18:14
 * @Version : V1.0
 */
public class Solution {
    private Map<String, String> map = new HashMap<>();

    {
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
    }

    private List<String> output = new ArrayList<>();

    /**
     * @return java.util.List<java.lang.String>
     * @Title letterCombinations
     * @Description 回溯算法
     * @Author zph
     * @Date 2020/7/26 18:22
     * @Param [digits]
     */
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0){
            return output;
        }
        backtrack("",digits);

        return output;
    }

    private void backtrack(String combination, String nextDigits) {
        if (nextDigits == null || nextDigits.length() == 0) {
            output.add(combination);
            return;
        }
        String digit = nextDigits.substring(0, 1);
        String letters = map.get(digit);
        int length=letters.length();
        for(int i=0;i<length;i++){
            String letter = map.get(digit).substring(i, i + 1);
            backtrack(combination+letter,nextDigits.substring(1));
        }
    }

    public static void main(String[] args) {


        Solution solution = new Solution();
        String digit="23";
        List<String> strings = solution.letterCombinations(digit);
        System.out.println(strings.toString());
    }
}
