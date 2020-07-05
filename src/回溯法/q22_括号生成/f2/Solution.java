package 回溯法.q22_括号生成.f2;

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
    class Node {
        /**
         * 当前得到的字符串
         */
        private String res;
        /**
         * 剩余左括号数量
         */
        private int left;
        /**
         * 剩余右括号数量
         */
        private int right;

        public Node(String str, int left, int right) {
            this.res = str;
            this.left = left;
            this.right = right;
        }
    }


    /**
     * @Title generateParenthesis
     * @Description 广度优先遍历
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
        Queue<Node> queue=new LinkedList<>();
        queue.offer(new Node("",n,n));
        while (!queue.isEmpty()){
            Node node = queue.poll();
            int left = node.left;
            int right = node.right;
            String str = node.res;
            if(left==0&&right==0){
                res.add(str);
            }
            if(left>0){
                queue.offer(new Node(str+"(",left-1,right));
            }
            if(right>0&&left<right){
                queue.offer(new Node(str+")",left,right-1));
            }
        }

        return  res;
    }




}
