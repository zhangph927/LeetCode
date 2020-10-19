package 回溯法.q301_删除无效的括号.f2;

import java.util.*;

/**
 * @ClassName : Solution
 * @Description :301. 删除无效的括号
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 *
 * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
 *
 * 示例 1:
 *
 * 输入: "()())()"
 * 输出: ["()()()", "(())()"]
 * 示例 2:
 *
 * 输入: "(a)())()"
 * 输出: ["(a)()()", "(a())()"]
 * 示例 3:
 *
 * 输入: ")("
 * 输出: [""]
 * @Author : zph
 * @Date: 2020-10-18 20:44
 * @Version : V1.0
 */
public class Solution {



    /**
     * @Title removeInvalidParentheses
     * @Description BFS
     * @Author zph
     * @Date 2020/10/18 20:51
     * @Param [s]
     * @return java.util.List<java.lang.String>
     */
    public List<String> removeInvalidParentheses(String s) {

        List<String> res = new ArrayList<>();
        if (s == null) {
            return res;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(s);
        queue.offer(s);
        boolean found = false;
        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (isVaild(str)) {
                res.add(str);
                found = true;
            }
            if (found) {
                continue;
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char c = str.charAt(i);

                if (c != '(' && c != ')') {
                    continue;
                }
                String subStr = str.substring(0, i) + str.substring(i + 1);
                if (!visited.contains(subStr)) {
                    visited.add(subStr);
                    queue.offer(subStr);

                }


            }


        }
        return res;


    }

    private boolean isVaild(String str) {
        int count = 0;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c == '(') {
                count++;
            }
            if (c == ')') {
                if(count==0){
                    return false;
                }else {
                    count--;
                }
            }
        }
        return count == 0;

    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        String str="(a)())()";
        List<String> strings = solution.removeInvalidParentheses(str);

        System.out.println(strings);
    }


}
