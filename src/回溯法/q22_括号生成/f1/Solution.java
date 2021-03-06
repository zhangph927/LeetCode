package 回溯法.q22_括号生成.f1;

import java.util.ArrayList;
import java.util.List;

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
     * @Description 回溯/或者深度优先
     * @Author zph
     * @Date 2020/7/5 17:42
     * @Param [n]
     * @return java.util.List<java.lang.String>
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n==0){
            return  res;
        }
        helper("",n,n,res);
        return  res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */

    private void helper(String curStr,int left,int right,List<String> res){
        if(left==0&&right==0){
            res.add(curStr);
            return;
        }
        if(left>right){
            return;
        }
        if(left>0){
            helper(curStr+"(",left-1,right,res);
        }
        if(right>0){
            helper(curStr+")",left,right-1,res);
        }
    }


}
