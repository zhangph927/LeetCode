package 字符串.q678_有效的括号字符串.f4;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName : Solution
 * @Description :678. 有效的括号字符串
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 示例 1:
 *
 * 输入: "()"
 * 输出: True
 * 示例 2:
 *
 * 输入: "(*)"
 * 输出: True
 * 示例 3:
 *
 * 输入: "(*))"
 * 输出: True
 * 注意:
 *
 * 字符串大小将在 [1，100] 范围内。
 * @Author : zph
 * @Date: 2020-07-05 11:46
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title checkValidString
     * @Description 双栈
     * @Author zph
     * @Date 2020/7/5 15:12
     * @Param [s]
     * @return boolean
     */
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> star = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        int length=chars.length;
        for(int i=0;i<length;i++){
            if(chars[i]=='('){
                left.push(i);
            }else if(chars[i]=='*'){
                star.push(i);
            }else {
                if(!left.isEmpty()){
                    left.pop();
                }else if(!star.isEmpty()){
                    star.pop();
                }else {
                    return  false;
                }
            }

        }
        while (!left.isEmpty()&&!star.isEmpty()){
            Integer leftIndex = left.peek();
            Integer starIndex = star.peek();
            if(leftIndex>starIndex){
                return  false;
            }else {
                left.pop();
                star.pop();
            }
        }
        return  left.isEmpty();


    }




}
