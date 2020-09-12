package 字符串.q6_Z字形变换.f1;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * @Author : zph
 * @Date: 2020-08-18 00:46
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title convert
     * @Description 按行排序
     * @Author zph
     * @Date 2020/8/19 0:35
     * @Param [s, numRows]
     * @return java.lang.String
     */
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        List<StringBuffer> rows = new ArrayList<>();
        int min=Math.min(numRows,s.length());
        for(int i=0;i<min;i++){
            rows.add(new StringBuffer());
        }
        int curRow=0;
        boolean flag=false;
        char[] chars = s.toCharArray();
        for(char ch:chars){
            rows.get(curRow).append(ch);
            if(curRow==0||curRow==numRows-1){
                flag=!flag;
            }
            curRow+=flag?1:-1;
        }
        StringBuffer res=  new StringBuffer();

        for(StringBuffer row:rows){
            res.append(row);
        }
        return res.toString();


    }
}
