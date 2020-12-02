package 动态规划.线性DP.最经典双串.q1143_最长公共子序列;

import java.util.Arrays;

/**
 * @ClassName : Solution
 * @Description :
 * @Author : zph
 * @Date: 2020-10-30 12:36
 * @Version : V1.0
 */
public class Solution {


    int[][] memo;

    int longestCommonSubsequence(String s1, String s2) {
        if(s1==null||s1.length()==0||s2==null||s2.length()==0){
            return 0;
        }
        int m=s1.length();
        int n=s2.length();

        memo=new int[m][n];
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
        return dp(s1,0,s2,0);
    }

    private int dp(String s1,int i, String s2,int j){
        if(i==s1.length()||j==s2.length()){
            return 0;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            memo[i][j]=1+dp(s1,i+1,s2,j+1);
        }else {
            memo[i][j]=Math.max(dp(s1,i+1,s2,j),
                    dp(s1,i,s2,j+1));
        }
        return memo[i][j];

    }
}
