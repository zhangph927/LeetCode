package 栈.q856_括号的分数.f1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName : Solution
 * @Description :856. 括号的分数
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 *
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 *
 *
 * 示例 1：
 *
 * 输入： "()"
 * 输出： 1
 * 示例 2：
 *
 * 输入： "(())"
 * 输出： 2
 * 示例 3：
 *
 * 输入： "()()"
 * 输出： 2
 * 示例 4：
 *
 * 输入： "(()(()))"
 * 输出： 6
 *
 *
 * 提示：
 *
 * S 是平衡括号字符串，且只含有 ( 和 ) 。
 * 2 <= S.length <= 50
 * @Author : zph
 * @Date: 2020-07-05 16:40
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title scoreOfParentheses
     * @Description 使用栈
     * @Author zph
     * @Date 2020/7/5 17:10
     * @Param [S]
     * @return int
     */
    public int scoreOfParentheses(String S) {
        Deque<Integer> stack=new LinkedList<>();
        //初始化0
        stack.push(0);
        char[] chars = S.toCharArray();
        int length=chars.length;
        for(int i=0;i<length;i++){
            if(chars[i]=='('){
                stack.push(0);
            }else {
                //当前层等分
                int score1=stack.pop();
                //上一层等分
                int score2=stack.pop();
                int newScore=Math.max(2*score1,1)+score2;
                stack.push(newScore);
            }
        }
        return  stack.pop();


    }
}
