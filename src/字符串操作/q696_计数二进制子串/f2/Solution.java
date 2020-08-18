package 字符串操作.q696_计数二进制子串.f2;

/**
 * @ClassName : Solution
 * @Description :696. 计数二进制子串
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * <p>
 * 重复出现的子串要计算它们出现的次数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 * <p>
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 * <p>
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * 示例 2 :
 * <p>
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 * 注意：
 * <p>
 * s.length 在1到50,000之间。
 * s 只包含“0”或“1”字符。
 * @Author : zph
 * @Date: 2020-08-10 16:44
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title countBinarySubstrings
     * @Description 按字符分组 空间复杂度为1
     * @Author zph
     * @Date 2020/8/10 16:53
     * @Param [s]
     * @return int
     */
    public int countBinarySubstrings(String s) {
        int ptr=0;
        int length=s.length();
        int last=0;
        int res=0;
        while (ptr<length){
            int c=s.charAt(ptr);
            int count=0;
            while (ptr<length&&c==s.charAt(ptr)){
                ptr++;
                count++;
            }
            res+=Math.min(count,last);
            last=count;
        }
        return res;
    }
}
