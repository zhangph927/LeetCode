package 字符串操作.反转字符串.q541_反转字符串II;

/**
 * @ClassName : Solution
 * @Description :541. 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 *
 * 示例:
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *
 *
 * 提示：
 *
 * 该字符串只包含小写英文字母。
 * 给定字符串的长度和 k 在 [1, 10000] 范围内。
 * @Author : zph
 * @Date: 2020-08-31 00:11
 * @Version : V1.0
 */
public class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int length=chars.length;
        for (int i=0;i<length;i=i+2*k){
            int left=i;
            int right=(i+k-1)<length?i+k-1:length-1;
            while (left<right){
                char temp=chars[left];
                chars[left]=chars[right];
                chars[right]=temp;
                left++;
                right--;
            }

        }
        return new String(chars);

    }
}
