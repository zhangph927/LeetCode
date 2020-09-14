package 树.N叉树.q386_字典序排数.f2;

import java.util.*;

/**
 * @ClassName : Solution
 * @Description :386. 字典序排数
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 *
 * 例如，
 *
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 *
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 * @Author : zph
 * @Date: 2020-07-15 00:07
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title lexicalOrder
     * @Description 十叉树 迭代
     * @Author zph
     * @Date 2020/7/15 0:08
     * @Param [n]
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        if(n<9){
            for(int i=n;i>0;i--){
                stack.addLast(i);
            }
        }else {
            for(int i=9;i>0;i--){
                stack.addLast(i);
            }
        }
        int t,m=0;
        while (!stack.isEmpty()){
            t = stack.removeLast();
            res.add(t);
            if(10*t>n){
                continue;
            }else {
                m=n-t*10;
                if(m>9){
                    m=9;
                }
            }
            for(int i=m;i>=0;i--){
                stack.addLast(t*10+i);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> integers = solution.lexicalOrder(13);
        System.out.println(integers);



    }



}
