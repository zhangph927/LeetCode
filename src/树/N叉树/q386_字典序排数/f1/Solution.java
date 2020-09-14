package 树.N叉树.q386_字典序排数.f1;

import java.util.ArrayList;
import java.util.List;

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
     * @Description 十叉树 递归
     * @Author zph
     * @Date 2020/7/15 0:08
     * @Param [n]
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        dfs(res,n,0,true);
        return res;


    }
    private void dfs(List<Integer> res,int maxVal,int curVal,boolean isFirstVal){
        if(curVal>maxVal){
            return;
        }
        if(curVal>0){
            res.add(curVal);
        }
        int beginVal=isFirstVal?1:0;
        for(int i=beginVal;i<=9;i++){
            isFirstVal=false;
            int nextVal=10*curVal+i;
            dfs(res,maxVal,nextVal,isFirstVal);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> integers = solution.lexicalOrder(13);
        System.out.println(integers);



    }



}
