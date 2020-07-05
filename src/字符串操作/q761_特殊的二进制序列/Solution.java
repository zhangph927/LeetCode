package 字符串操作.q761_特殊的二进制序列;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :761. 特殊的二进制序列
 * 特殊的二进制序列是具有以下两个性质的二进制序列：
 *
 * 0 的数量与 1 的数量相等。
 * 二进制序列的每一个前缀码中 1 的数量要大于等于 0 的数量。
 * 给定一个特殊的二进制序列 S，以字符串形式表示。定义一个操作 为首先选择 S 的两个连续且非空的特殊的子串，然后将它们交换。（两个子串为连续的当且仅当第一个子串的最后一个字符恰好为第二个子串的第一个字符的前一个字符。)
 *
 * 在任意次数的操作之后，交换后的字符串按照字典序排列的最大的结果是什么？
 *
 * 示例 1:
 *
 * 输入: S = "11011000"
 * 输出: "11100100"
 * 解释:
 * 将子串 "10" （在S[1]出现） 和 "1100" （在S[3]出现）进行交换。
 * 这是在进行若干次操作后按字典序排列最大的结果。
 * 说明:
 *
 * S 的长度不超过 50。
 * S 保证为一个满足上述定义的特殊 的二进制序列。
 * @Author : zph
 * @Date: 2020-07-05 15:59
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title makeLargestSpecial
     * @Description 转换为括号问题解决
     * @Author zph
     * @Date 2020/7/5 16:09
     * @Param [S]
     * @return java.lang.String
     */
    public String makeLargestSpecial(String S) {
        char[] chars = S.toCharArray();
        int start=0;
        int count=0;
        int length=chars.length;
        List<String> res = new ArrayList<>();
        for(int i=0;i<length;i++){
            if(chars[i]=='1'){
                count++;
            }else {
                count--;
            }
            if(count==0){
               String temp="1"+makeLargestSpecial(S.substring(start+1,i))+"0";
               res.add(temp);
               start=i+1;
            }
        }
        Collections.sort(res,Collections.reverseOrder());
        return  String.join("",res);


    }
}
