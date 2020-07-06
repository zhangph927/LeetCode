package 动态规划.q10_正则表达式匹配;

/**
 * @ClassName : Solution
 * @Description :10. 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * @Author : zph
 * @Date: 2020-07-06 17:25
 * @Version : V1.0
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s="aaaaaaaaaab";
        String p="c*a*b";
        boolean match = solution.isMatch(s, p);
        System.out.println(match);


    }

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
      boolean[][] dp=  new boolean[sLen+1][pLen+1];
      dp[0][0]=true;
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();

        for(int i=0;i<=sLen;i++){
          for(int j=1;j<=pLen;j++){
              if(pChars[j-1]=='*'){
                  if(match(sChars,pChars,i,j-1)){
                      dp[i][j]=dp[i-1][j]||dp[i][j-2];
                  }else {
                      dp[i][j]=dp[i][j-2];
                  }
              }else {
                  if(match(sChars,pChars,i,j)){
                      dp[i][j]=dp[i-1][j-1];
                  }else {
                      //可以省略，保留是为了方便理解
                      dp[i][j]=false;
                  }

              }

          }

      }
        return  dp[sLen][pLen];



    }


    private  boolean match(char[] sChars,char[] pChars,int i,int j){
        if(i==0){
            return  false;
        }
        if(pChars[j-1]=='.'){
            return  true;
        }
        return sChars[i-1]==pChars[j-1];
    }


}
