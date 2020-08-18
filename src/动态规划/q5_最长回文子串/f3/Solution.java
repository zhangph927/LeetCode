package 动态规划.q5_最长回文子串.f3;

/**
 * @ClassName : Solution
 * @Description :5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * @Author : zph
 * @Date: 2020-08-17 23:40
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return java.lang.String
     * @Title longestPalindrome
     * @Description 中心扩散法
     * @Author zph
     * @Date 2020/8/17 23:57
     * @Param [s]
     */
    public String longestPalindrome(String s) {
        if(s==null||s.length()<2){
            return s;
        }
        char[] chars = s.toCharArray();
        int length=chars.length;
        int maxLen=1;
        String res=s.substring(0,1);
        for(int i=0;i<length-1;i++){
            String oddStr=centerSpread(s,i,i);
            String evenStr=centerSpread(s,i,i+1);
            String maxLenStr=oddStr.length()>evenStr.length()?oddStr:evenStr;
            if(maxLenStr.length()>maxLen){
                maxLen=maxLenStr.length();
                res=maxLenStr;
            }
        }
        return res;
    }

    private String centerSpread(String s,int left,int right){
        int length=s.length();
        int i=left;
        int j=right;
        while (i>=0&&j<length){
            if(s.charAt(i)==s.charAt(j)){
                i--;
                j++;
            }else {
                break;
            }
        }
        return s.substring(i+1,j);

    }



}
