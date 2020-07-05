package 回溯法.q22_括号生成.f3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName : Solution
 * @Description :22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 * 通过次数144,306提交次数190,661
 * @Author : zph
 * @Date: 2020-07-05 17:41
 * @Version : V1.0
 */
public class Solution {


    /**
     * @Title generateParenthesis
     * @Description 动态规划
     * @Author zph
     * @Date 2020/7/5 17:42
     * @Param [n]
     * @return java.util.List<java.lang.String>
     */
    public List<String> generateParenthesis(int n) {

        if(n==0){
            return  new ArrayList<>();
        }
        List<List<String>> dp = new ArrayList<>();
        List<String> dp0=new ArrayList<>();
        dp0.add("");
        dp.add(dp0);
        for(int i=1;i<n;i++){
            List<String> cur=new ArrayList<>();
            for(int j=0;j<i;j++){
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i-j-1);
                for(String s1:str1){
                    for(String s2:str2){
                        cur.add("("+s1+")"+s2);
                    }
                }

            }
            dp.add(cur);
        }
        return  dp.get(n);
    }




}
