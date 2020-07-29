package 动态规划.q392_判断子序列.f2;

/**
 * @ClassName : Solution
 * @Description :392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * 返回 true.
 * <p>
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * 返回 false.
 * <p>
 * 后续挑战 :
 * <p>
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * 致谢:
 * <p>
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 * @Author : zph
 * @Date: 2020-07-27 22:11
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return boolean
     * @Title isSubsequence
     * @Description 动态规划
     * @Author zph
     * @Date 2020/7/27 22:13
     * @Param [s, t]
     */
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp=new int[m+1][26];
        for(int i=0;i<26;i++){
            dp[m][i]=m;
        }
        for(int i=m-1;i>=0;i--){
            for(int j=0;j<26;j++){
                if(t.charAt(i)==j+'a'){
                    dp[i][j]=i;
                }else {
                    dp[i][j]=dp[i+1][j];
                }
            }
        }
        int add=0;
        for(int i=0;i<n;i++){
            if(dp[add][s.charAt(i)-'a']==m){
                return false;
            }
            add=dp[add][s.charAt(i)-'a']+1;
        }
        return true;


    }

    public static void main(String[] args) {
       String s = "abc", t = "ahbgdc";
        Solution solution = new Solution();
        boolean subsequence = solution.isSubsequence(s, t);
        System.out.println(subsequence);

    }

}
