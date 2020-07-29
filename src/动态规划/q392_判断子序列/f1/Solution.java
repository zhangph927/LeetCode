package 动态规划.q392_判断子序列.f1;

/**
 * @ClassName : Solution
 * @Description :392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 *
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 *
 * 返回 false.
 *
 * 后续挑战 :
 *
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 致谢:
 *
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 * @Author : zph
 * @Date: 2020-07-27 22:11
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title isSubsequence
     * @Description 双指针
     * @Author zph
     * @Date 2020/7/27 22:13
     * @Param [s, t]
     * @return boolean
     */
    public boolean isSubsequence(String s, String t) {
        int slen=s.length();
        int tlen=t.length();
        char[] schars=s.toCharArray();
        char[] tchars=t.toCharArray();
        int i=0;
        int j=0;
        while (i<slen&&j<tlen){
            if(schars[i]==tchars[j]){
                i++;
            }
            j++;
        }
        return i==slen;

    }
}
