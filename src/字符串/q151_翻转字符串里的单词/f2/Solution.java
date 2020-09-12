package 字符串.q151_翻转字符串里的单词.f2;

/**
 * @ClassName : Solution
 * @Description :151. 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 * 进阶：
 *
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 * @Author : zph
 * @Date: 2020-08-16 21:31
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title reverseWords
     * @Description 自行编写对应的函数
     * @Author zph
     * @Date 2020/8/16 21:55
     * @Param [s]
     * @return java.lang.String
     */
    public String reverseWords(String s) {
        //去空格
        StringBuffer buffer = trimSpaces(s);

        //翻转字符串
        reverse(buffer,0,buffer.length()-1);
        //翻转每个单词
        reverseEachWord(buffer);
        return buffer.toString();

    }
    private void reverseEachWord(StringBuffer sb){
        int length=sb.length();
        int start=0;
        int end=0;
        while (start<length){
            while (end<length&&sb.charAt(end)!=' '){
                end++;
            }
            reverse(sb,start,end-1);
            start=end+1;
            end++;
        }
    }

    private void reverse(StringBuffer sb,int left,int right){
        while (left<right){
            char temp=sb.charAt(left);
            sb.setCharAt(left++,sb.charAt(right));
            sb.setCharAt(right--,temp);
        }

    }



    private  StringBuffer trimSpaces(String s){

        int left=0;
        int right=s.length()-1;
        while (left<=right&&s.charAt(left)==' '){
            left++;
        }
        while (left<=right&&s.charAt(right)==' '){
            right--;
        }
        StringBuffer buffer = new StringBuffer();
        while (left<=right){
           char c= s.charAt(left);
           if(c!=' '){
               buffer.append(c);
           }else if(buffer.charAt(buffer.length()-1)!=' ') {
               buffer.append(c);
           }
           left++;
        }

        return buffer;



    }
}
