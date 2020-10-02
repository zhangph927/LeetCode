package 双指针.q415_字符串相加;

/**
 * @ClassName : Solution
 * @Description :415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 *
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * @Author : zph
 * @Date: 2020-08-03 01:02
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title addStrings
     * @Description 双指针
     * @Author zph
     * @Date 2020/8/3 1:02
     * @Param [num1, num2]
     * @return java.lang.String
     */
    public String addStrings(String num1, String num2) {

        int i=num1.length()-1;
        int j=num2.length()-1;
        //进位标志位
        int add=0;
        StringBuffer buffer = new StringBuffer();
        while (i>=0||j>=0||add!=0){
            int x=i>=0?num1.charAt(i)-'0':0;
            int y=j>=0?num2.charAt(j)-'0':0;
            int num=x+y+add;
            int res=num%10;
            add=num/10;
            buffer.append(res);
            i--;
            j--;
        }
        buffer.reverse();
        return buffer.toString();


    }
}
