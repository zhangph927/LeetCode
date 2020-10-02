package 栈.q20_有效的括号;

import java.util.*;

/**
 * @Title
 * @Description 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 利用栈 o(n)
 * @Author zph
 * @Date 2020/7/5 0:49
 * @Param
 * @return
 */
public class Solution {
    /**
     * @Title isValid
     * @Description 栈
     * @Author zph
     * @Date 2020/10/2 23:03
     * @Param [s]
     * @return boolean
     */
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        char[] chars = s.toCharArray();
        int length=chars.length;
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<length;i++){
           char ch= chars[i];
            if(map.containsKey(ch)){
               char peek= stack.isEmpty()?'#':stack.peek();
               if(peek==map.get(ch)){
                   stack.pop();
               }else {
                   return false;
               }
            }else{
                stack.push(ch);
            }

        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()"));
    }
}
