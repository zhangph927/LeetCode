package 字符串.反转字符串.q557_反转字符串中的单词III.f1;

/**
 * @ClassName : Solution
 * @Description :557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 *
 * 提示：
 *
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * @Author : zph
 * @Date: 2020-08-31 00:27
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title reverseWords
     * @Description 使用额外空间
     * @Author zph
     * @Date 2020/8/31 0:28
     * @Param [s]
     * @return java.lang.String
     */
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        int i=0;
        int length=chars.length;
        while (i<length){
            int start=i;
            while (i<length&&chars[i]!=' '){

                i++;
            }
            for(int j=start;j<i;j++){
                builder.append(chars[start+i-1-j]);
            }
            while (i<length&&chars[i]==' '){

                i++;
                builder.append(" ");
            }

        }
        return builder.toString();


    }
}
