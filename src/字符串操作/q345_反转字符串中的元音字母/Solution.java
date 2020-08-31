package 字符串操作.q345_反转字符串中的元音字母;

/**
 * @ClassName : Solution
 * @Description :345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 * <p>
 * 输入："leetcode"
 * 输出："leotcede"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 元音字母不包含字母 "y" 。
 * @Author : zph
 * @Date: 2020-08-31 00:01
 * @Version : V1.0
 */
public class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int length = chars.length;
        int right = length - 1;
        while (left < right) {
            while (left < length && !isVowel(chars[left])) {
                left++;
            }
            while (right >= 0 && !isVowel(chars[right])) {
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(chars, left, right);
            left++;
            right--;
        }
        return new String(chars);


    }

    // 判断是不是元音
    private boolean isVowel(char ch) {
        // 这里要直接用 return 语句返回，不要返回 true 或者 false
        boolean flag = ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
        return flag;
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }


}
